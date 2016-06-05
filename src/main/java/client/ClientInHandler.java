package client;

import java.io.IOException;
import java.io.ObjectInputStream;

import dto.changes.DTOChange;


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
				
				if (obj instanceof DTOChange) {
					DTOChange change = (DTOChange) obj;
//					System.out.println("DTOChange received");
					System.out.println(change);
				} else {
					System.out.println(obj);
				}
				
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}

}
