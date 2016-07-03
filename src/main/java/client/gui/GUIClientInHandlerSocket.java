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
				System.out.println("msg");
				
				if (obj instanceof DTOChange) {
					DTOChange change = (DTOChange) obj;
					System.out.println("run1");
					MainApp.alert(change.toString());
					System.out.println("run2");
				} else {
					System.out.println("run3");
					MainApp.alert(obj.toString());
					System.out.println("run4");
				}
				
			} catch (ClassNotFoundException | IOException e) {
				System.out.println("SERVER IS DOWN");
				break;
			} 
		}
	}

}
