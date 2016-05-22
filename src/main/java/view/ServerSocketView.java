package view;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import model.actions.GeneralAction;
import controller.Change;

public class ServerSocketView extends View implements Runnable {
	
//	private Socket socket; 
	private ObjectInputStream socketIn; 
	private ObjectOutputStream socketOut; 
	
	public ServerSocketView(Socket socket) throws IOException {
//		this.socket = socket; 
		this.socketIn = new ObjectInputStream(socket.getInputStream()); 
		this.socketOut = new ObjectOutputStream(socket.getOutputStream()); 		
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
				if (obj instanceof GeneralAction) {
					GeneralAction action = (GeneralAction) obj;
					System.out.println("SERVER VIEW: received GeneralAction " + action);
					
					this.notifyObserver(action);
				}
				
				if (obj instanceof String) {
					String string = (String) obj;
					System.out.println("SERVER VIEW: received String " + string);
					
					this.socketOut.writeObject("SERVER: Hello World!");
					this.socketOut.flush();
				}
				
				
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
	}

}
