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
