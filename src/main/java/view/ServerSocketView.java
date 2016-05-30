package view;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import client.ClientMessage;
import controller.changes.Change;
import model.GameState;
import model.actions.GeneralAction;
import model.player.Player;
import query.Query;

public class ServerSocketView extends View implements Runnable {
	
//	private Socket socket; 
	private ObjectInputStream socketIn; 
	private ObjectOutputStream socketOut;
	private GameState game;
	
	public ServerSocketView(Socket socket, GameState game) throws IOException {
//		this.socket = socket; 
		this.socketIn = new ObjectInputStream(socket.getInputStream()); 
		this.socketOut = new ObjectOutputStream(socket.getOutputStream());
		this.game = game;
	}
	public void update(Change change) {
		
		System.out.println("Sending to the client " + change);
		
		try {
			this.socketOut.writeObject(change);
			this.socketOut.flush();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		while(true) {	//suggest: check this condition
						//reply(ricky): condition is ok because serversocket must be always ready to receive actions
			try {
				Object obj = socketIn.readObject();
				if (obj instanceof ClientMessage) {
					
					ClientMessage msgIn = (ClientMessage) obj;
					System.out.println("RECEIVED MSG: " + msgIn);
					
					if (game.getPlayersHashMap().containsKey(msgIn.getNickname())) {
						
						Player player = game.getPlayersHashMap().get(msgIn.getNickname());
						ClientMessage msgOut;
						
						if (msgIn.getMessage() instanceof GeneralAction) {
							GeneralAction action = (GeneralAction) msgIn.getMessage();
							System.out.println("SERVER VIEW: received GeneralAction " + action);
							
							msgOut = new ClientMessage(player, msgIn.getMessage());
							
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
							
							this.socketOut.writeObject(query.perform(player, this.game));
							this.socketOut.flush();
						}
						
					} else {
						StringBuilder userNotFound = new StringBuilder();
						userNotFound.append("\n[ERROR] User not found!\n");
						userNotFound.append("[ERROR] Remember that the user input is case sensitive\n");
						this.socketOut.writeObject(userNotFound.toString());
						this.socketOut.flush();
					}
				}
				
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
	}

}