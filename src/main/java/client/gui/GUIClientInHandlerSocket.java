package client.gui;

import java.io.IOException;
import java.io.ObjectInputStream;

import dto.changes.DTOChange;
import gui.MainApp;


public class GUIClientInHandlerSocket implements Runnable {
	
	private ObjectInputStream socketIn;
	
	/**
	 * @param socketIn
	 */
	public GUIClientInHandlerSocket(ObjectInputStream socketIn) {
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
					MainApp.alert(change.toString());
				} else {
					MainApp.alert(obj.toString());
				}
				
			} catch (ClassNotFoundException | IOException e) {
				System.out.println("SERVER IS DOWN");
				break;
			} 
		}
	}

}
