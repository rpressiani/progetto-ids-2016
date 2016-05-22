package client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import model.query.GetCoins;
import model.query.GetScores;
import model.query.Query;

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
			ArrayList<String> inputList = new ArrayList<String>(Arrays.asList(inputLine.split(" ")));
			
			try {
				
				ClientMessage msg;
				
				switch (inputList.get(1)) {
				case "HELLO":
					msg = new ClientMessage(inputList.get(0), "HELLO");
					socketOut.writeObject(msg);
					socketOut.flush();
					break;
				case "GETSCORES":
					Query<String> queryScores = new GetScores();
					msg = new ClientMessage(inputList.get(0), queryScores);
					socketOut.writeObject(msg);
					socketOut.flush();
					break;
				case "GETCOINS":
					Query<String> queryCoins = new GetCoins();
					msg = new ClientMessage(inputList.get(0), queryCoins);
					socketOut.writeObject(msg);
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
