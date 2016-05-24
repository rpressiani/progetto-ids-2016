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
		if(socketOut==null) {
			throw new IllegalArgumentException("socketOut cannot be null"); 
		}
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
				
					/*----- GENERAL-----*/
				case "ping":
					msg = new ClientMessage(inputList.get(0), "ping");
					socketOut.writeObject(msg);
					socketOut.flush();
					break;
					
					/*----- ACTIONS -----*/
					
					
					
					/*----- QUERIES -----*/
				case "getscores":
					Query<String> queryScores = new GetScores();
					msg = new ClientMessage(inputList.get(0), queryScores);
					socketOut.writeObject(msg);
					socketOut.flush();
					break;
				case "getcoins":
					Query<String> queryCoins = new GetCoins();
					msg = new ClientMessage(inputList.get(0), queryCoins);
					socketOut.writeObject(msg);
					socketOut.flush();
					break;
					
				default:
					StringBuilder cmdNotFound = new StringBuilder();
					cmdNotFound.append("\n[ERROR] Command not found!\n");
					cmdNotFound.append("[ERROR] Insert legal commands following the instruction below:\n");
					cmdNotFound.append("[ERROR] <nickname> <command>\n");
					System.out.println(cmdNotFound.toString());
					break;
				}
				
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
		}

	}

}
