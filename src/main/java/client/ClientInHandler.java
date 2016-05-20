package client;

import java.io.IOException;
import java.io.ObjectInputStream;

import controller.Change;

public class ClientInHandler implements Runnable {
	
	private ObjectInputStream socketIn; 
	
	public ClientInHandler(ObjectInputStream socketIn) {
		this.socketIn = socketIn; 
	}
	public void run() {
		while(true) {
			try {
				Change line; 
				line = (Change) socketIn.readObject();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}

}
