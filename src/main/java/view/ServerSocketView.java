package view;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import actions.GeneralAction;
import controller.Change;

public class ServerSocketView extends View implements Runnable {
	
	private Socket socket; 
	private ObjectInputStream socketIn; 
	private ObjectOutputStream socketOut; 
	
	public ServerSocketView(Socket socket) throws IOException {
		this.socket = socket; 
		this.socketIn = new ObjectInputStream(socket.getInputStream()); 
		this.socketOut = new ObjectOutputStream(socket.getOutputStream()); 		
	}
	public void update(Change change) {
		try {
			this.socketOut.writeObject(change);
			this.socketOut.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		while(true) { //suggest: check this condition
			try {
				GeneralAction action = (GeneralAction) socketIn.readObject();
				this.notifyObserver(action);
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
	}

}
