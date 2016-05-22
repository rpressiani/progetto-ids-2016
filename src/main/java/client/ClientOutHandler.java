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
		
		System.out.println("ClientOutHandler is RUNNING");
		Scanner stdIn = new Scanner(System.in);
		
		while (true) {
			
			String inputLine = stdIn.nextLine();
			
			try {
				
				switch (inputLine) {
				case "HELLO":
					socketOut.writeObject("HELLO");
					socketOut.flush();
					break;
					
				default:
					break;
				}
				
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
		}

	}

}
