package client;

import java.io.IOException;
import java.io.ObjectInputStream;

import model.changes.Change;


public class ClientInHandler implements Runnable {
	
	private ObjectInputStream socketIn;
	
	public ClientInHandler(ObjectInputStream socketIn) {
		if(socketIn==null) {
			throw new IllegalArgumentException("socketIn cannot be null"); 
		}
		this.socketIn = socketIn; 
	}
	
	public void run() {
		while(true) {
			try {
				Object obj = socketIn.readObject();
				
				if (obj instanceof Change) {
					Change line = (Change) obj;
					System.out.println(line);
				}
				
				System.out.println(obj);
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}

}
