package client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ClientOutHandler implements Runnable {
	
	private ObjectOutputStream socketOut; 
	
	public ClientOutHandler(ObjectOutputStream socketOut) {
		this.socketOut = socketOut; 
	}
	public void run() {
		/*System.out.println("Running");
		Scanner stdIn = new Scanner(System.in); 
		while(true) {
			String inputLine = stdIn.nextLine(); 
			Action action; 
			if(inputLine.equals(Switch.ON.toString())) {
				action = new TurnOn(); 
			} else {
				if(inputLine.equals(Switch.OFF.toString())) {
					action = new TurnOff(); 
				} else {
					action = new Scommetti(); 
				}
			} 
			System.out.println("Sending Action");
			try {
				socketOut.writeObject(action);
			} catch(IOException e) {
				e.printStackTrace();
			}
		}*/
	}

}
