package view;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import client.ClientMessage;
import dto.actions.DTOAction;
import dto.changes.DTOChange;
import dto.utilities.DTOSetup;
import model.GameState;
import model.changes.Change;
import model.player.Player;
import query.Query;
import utilities.Color;

public class ServerSocketView extends View implements Runnable {
	
	private Socket socket; 
	private ObjectInputStream socketIn; 
	private ObjectOutputStream socketOut;
	private GameState game;
	private Player player;
	private boolean enabled = false;
	private VisitorChanges visitorChanges;
	
	public ServerSocketView(Socket socket) throws IOException, ClassNotFoundException {
		this.socket = socket; 
		this.socketIn = new ObjectInputStream(socket.getInputStream()); 
		this.socketOut = new ObjectOutputStream(socket.getOutputStream());
		this.visitorChanges = new VisitorChanges();
		
//		System.out.printn("insert nickname:\n");
		this.socketOut.writeObject("[SERVER] Insert 'setup <nickname> <color>' asap\n");
		this.socketOut.flush();
		this.player = new Player(); //set name and color while running only if running==false, after that set running as true
//										use a timer, notify the clients that if they're not running by the end of the timer they
//										will be disconnected. the player get to be part of the match only if they're are running
	}
	
	public void initServerSocketView(GameState game) throws IOException{
		this.game = game;
//		this.enable = true;
//		this.socketOut.writeObject(this.enable);
		this.socketOut.flush();
		System.out.println("initServerSocketView executed");
	}
	
	public void update(Change change) {
		
		System.out.println("Sending to the client " + change);
		
		try {
			DTOChange dtoChange = change.accept(this.visitorChanges, this.player);
			this.socketOut.writeObject(dtoChange);
			this.socketOut.flush();
			System.out.println("DTOChange sent");
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		
		try {
			this.socketOut.writeObject("ServerSocketView is running");
			this.socketOut.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		while(true) {	//suggest: check this condition
						//reply(ricky): condition is ok because serversocket must be always ready to receive actions
			try {
			
				Object obj = socketIn.readObject();
				
				if (obj instanceof ClientMessage) {
					
					ClientMessage msgIn = (ClientMessage) obj;
					System.out.println("RECEIVED MSG: " + msgIn);
					
//					if (game.getPlayersHashMap().containsKey(msgIn.getNickname())) {
						
//						Player player = game.getPlayersHashMap().get(msgIn.getNickname());
						ClientMessage msgOut;
						
						if (!enabled) {
							
							if (msgIn.getMessage() instanceof DTOSetup) {
								
								DTOSetup setup = (DTOSetup) msgIn.getMessage();
								
								this.player.setNickname(new String(setup.getNickname()));
								this.player.setColor(new Color(setup.getColor().getColorString()));
								this.enabled = true;
								
								StringBuilder playerEnabled = new StringBuilder();
								playerEnabled.append("\n[SERVER] Setup completed\n");
								playerEnabled.append("[SERVER] player.enabled == " + this.enabled + "\n");
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
							
							if (msgIn.getMessage() instanceof String) {
								String string = (String) msgIn.getMessage();
								System.out.println("SERVER VIEW: received String " + string);
								
								if (string.equals("ping")) {
									StringBuilder ping = new StringBuilder();
									ping.append("\n[SERVER] Ping received\n");
									ping.append("[SERVER] Client connected\n");
									ping.append("[SERVER] Server is responding\n");
									this.socketOut.writeObject(ping.toString());
									this.socketOut.flush();
								}
							}
							
							if (msgIn.getMessage() instanceof Query) {
								Query query = (Query) msgIn.getMessage();
								System.out.println("SERVER VIEW: received query " + query);
								
								this.socketOut.writeObject(query.perform(this.player, this.game));
								this.socketOut.flush();
							}
						}						
				}
				
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		return enabled;
	}

}