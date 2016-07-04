package view.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import client.ClientMessage;
import dto.DTOObject;
import dto.actions.DTOAction;
import dto.changes.DTOChange;
import dto.queries.DTOQuery;
import dto.queries.VisitorQueries;
import dto.utilities.DTOSetup;
import model.GameState;
import model.changes.Change;
import model.player.Player;
import server.Server;
import utilities.Color;
import view.View;
import view.VisitorChanges;

public class ServerSocketView extends View implements Runnable {
	
	private Socket socket; 
	private ObjectInputStream socketIn; 
	private ObjectOutputStream socketOut;
	private GameState game;
	private Player player;
	private VisitorChanges visitorChanges;
	private VisitorQueries visitorQueries;
	private SocketViewTimer timer;
	
	private Server server;
	
	/**
	 * @param server
	 * @param socket
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public ServerSocketView(Socket socket, Server server) throws IOException, ClassNotFoundException {
		this.socket = socket;
		this.server = server;
		this.socketIn = new ObjectInputStream(this.socket.getInputStream()); 
		this.socketOut = new ObjectOutputStream(this.socket.getOutputStream());
		this.visitorChanges = new VisitorChanges();

		this.player = new Player();
		this.player.setView(this);
		
		this.timer = new SocketViewTimer(this, this.server, this.player);
		(new Thread(this.timer)).start();
	}
	
	/**
	 * initialize the ServerSocketView
	 * @param game
	 * @throws IOException
	 */
	public void initServerSocketView(GameState game) throws IOException{
		this.game = game;
		this.visitorQueries = new VisitorQueries(this.game, this.player);
	}
	
	
	/**
	 * @see view.View#update(model.changes.Change)
	 */
	public void update(Change change) {
		
		System.out.println("Sending to the client " + change);
		
		try {
			DTOChange dtoChange = change.accept(this.visitorChanges);
			this.socketOut.writeObject(dtoChange);
			this.socketOut.flush();
			System.out.println("DTOChange sent");
			
		} catch(IOException e) {
			System.out.println("disconnected");
		}
	}
	
	
	
	/**
	 * Loops on socketIn.readObject() waiting for a message to be received.
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		
		try {
			StringBuilder initString = new StringBuilder();
			initString.append("\n[SERVER] ServerSocketView is running\n");
			initString.append("[SERVER] Insert 'setup <nickname> <color>' to enable your player to join a match.\n");
			this.socketOut.writeObject(initString);
			this.socketOut.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		while(true) {	
						
			try {
			
				Object obj = socketIn.readObject();
				
				if (this.timer.isActive()) this.timer.reset();
				
				if (obj instanceof ClientMessage) {
					
					ClientMessage msgIn = (ClientMessage) obj;
					System.out.println("RECEIVED MSG: " + msgIn);
					
					ClientMessage msgOut;
					
					if (!this.player.isEnabled()) {
						
						if (msgIn.getMessage() instanceof DTOSetup) {
							
							DTOSetup setup = (DTOSetup) msgIn.getMessage();
							
							this.player.setNickname(new String(setup.getNickname()));
							this.player.setColor(new Color(setup.getColor().getColorString()));
							this.player.setEnabled(true);
							
							StringBuilder playerEnabled = new StringBuilder();
							playerEnabled.append("\n[SERVER] Setup completed\n");
							playerEnabled.append("[SERVER] player.enabled == " + this.player.isEnabled() + "\n");
							playerEnabled.append("[SERVER] Waiting for a match to start...\n");
							this.socketOut.writeObject(playerEnabled.toString());
							this.socketOut.flush();
						}
							
					} else {
						
						if (msgIn.getMessage() instanceof DTOAction) {
							DTOAction action = (DTOAction) msgIn.getMessage();
							System.out.println("SERVER VIEW: received DTOAction " + action);
							
							msgOut = new ClientMessage(this.player, action);
							
							this.notifyObserver(msgOut);
						}
						
						if (msgIn.getMessage() instanceof DTOQuery) {
							
							DTOQuery request = (DTOQuery) msgIn.getMessage();
							DTOObject respond = request.accept(this.visitorQueries);
							System.out.println("SERVER VIEW: received DTOQuery " + request);
							
							this.socketOut.writeObject(respond);
							this.socketOut.flush();
						}
					}						
				}
				
			} catch (ClassNotFoundException | IOException e) {
				System.out.println("CLIENT_SOCKET DISCONNECTED");
				try {
					this.server.disconnectSocket(player);
					this.socketIn.close();
					this.socketOut.close();
					this.socket.close();
					break;
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			} 
		}
		
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @return if the object is enabled
	 */
	public boolean isEnabled() {
		return this.player.isEnabled();
	}
	
	
	/**
	 * @see view.View#startTimer()
	 */
	@Override
	public void startTimer() {
		this.timer.start();
		
	}

	/**
	 * @see view.View#stopTimer()
	 */
	@Override
	public void stopTimer() {
		this.timer.stop();
		
	}

	/**
	 * @see view.View#resetTimer()
	 */
	@Override
	public void resetTimer() {
		this.timer.reset();
		
	}

	/**
	 * @return the timer
	 */
	public SocketViewTimer getTimer() {
		return timer;
	}

	@Override
	public void disconnect() {
		this.server.disconnectSocket(this.player);
		
	}

	/**
	 * @return the socket
	 */
	public Socket getSocket() {
		return socket;
	}

}