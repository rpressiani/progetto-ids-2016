package view;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import client.ClientMessage;
import model.GameState;
import model.actions.GeneralAction;
import model.query.Query;
import controller.Change;

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
					
					ClientMessage msg = (ClientMessage) obj;
					
					if (msg.getMessage() instanceof GeneralAction) {
						GeneralAction action = (GeneralAction) msg.getMessage();
						System.out.println("SERVER VIEW: received GeneralAction " + action);
						
						this.notifyObserver(msg);
					}
					
					if (msg.getMessage() instanceof String) {
						String string = (String) msg.getMessage();
						System.out.println("SERVER VIEW: received String " + string);
						
						this.socketOut.writeObject("SERVER: Hello World!");
						this.socketOut.flush();
					}
					
					if (msg.getMessage() instanceof Query) {
						Query query = (Query) msg.getMessage();
						System.out.println("SERVER VIEW: received query " + query);
						
						this.socketOut.writeObject(query.perform(this.game));
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
