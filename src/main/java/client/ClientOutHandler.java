package client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import dto.actions.main.DTOBuildEmporiumWithCard;
import dto.actions.main.DTOBuildEmporiumWithKing;
import dto.actions.main.DTOBuyPermissionCard;
import dto.actions.main.DTOElectCounsellor;
import dto.actions.quick.DTOAddictionalAction;
import dto.actions.quick.DTOChangePermissionCards;
import dto.actions.quick.DTOElectCounsellorWithAssistant;
import dto.actions.quick.DTOHireAssistant;
import dto.map.DTOCity;
import dto.map.DTORegion;
import dto.utilities.DTOColor;
import dto.utilities.DTOPermissionCard;
import model.actions.main.BuildEmporiumWithKing;
import query.GetCoins;
import query.GetCurrentPlayer;
import query.GetScores;
import query.Query;

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
			
			StringBuilder cmdNotFound = new StringBuilder();
			cmdNotFound.append("\n[ERROR] Command not found!\n");
			cmdNotFound.append("[ERROR] Insert legal commands following the instruction below:\n");
			cmdNotFound.append("[ERROR] <nickname> <command>\n");
			cmdNotFound.append("[ERROR] Enter help for command list\n");
			
			try {
				
				ClientMessage msg;
				if (inputList.get(0).equals("help")) {
					StringBuilder help = new StringBuilder();
					help.append("\n[CLI] Insert legal commands following the instruction below:\n");
					help.append("[CLI] <nickname> <command>\n");
					help.append("[CLI] COMMAND LIST: \n");
					help.append("[CLI] *\tMain Actions \n");
					help.append("[CLI] \t\tbuildEmpCard <idCard> <city>\n");
					help.append("[CLI] \t\tbuildEmpKing \n");
					help.append("[CLI] \t\tbuyPermissionCard \n");
					help.append("[CLI] \t\telectCounsellor <region> <color>\n");
					help.append("[CLI] *\tQuick Actions \n");
					help.append("[CLI] \t\taddAction <action>\n");
					help.append("[CLI] \t\tchangePermissionCards <region>\n");
					help.append("[CLI] \t\telectCounsellorAss <region> <color>\n");
					help.append("[CLI] \t\thireAss\n");
					help.append("[CLI] *\tQueries \n");
					help.append("[CLI] \t\tgetscores \n");
					help.append("[CLI] \t\tgetcoins \n");
					help.append("[CLI] *\tOther Commands \n");
					help.append("[CLI] \t\tping\n");
					System.out.println(help.toString());
				} else if(inputList.get(0).equals("setup")){
					socketOut.writeObject(inputList.get(1));
					socketOut.flush();
				} else {
					
					switch (inputList.get(0)) {
						
						/*----- GENERAL-----*/
					case "ping":
						msg = new ClientMessage("ping");
						socketOut.writeObject(msg);
						socketOut.flush();
						break;
						
						/*----- ACTIONS -----*/
					case "changePermissionCards":
						if (inputList.size() == 2) {
							msg = new ClientMessage(new DTOChangePermissionCards(new DTORegion(inputList.get(2))));
							socketOut.writeObject(msg);
							socketOut.flush();
							break;
						} else {
							System.out.println(cmdNotFound.toString());
							break;
						}
					case "hireAss":
						msg = new ClientMessage(new DTOHireAssistant());
						socketOut.writeObject(msg);
						socketOut.flush();
						break;
					case "electCounsellorAss":
						msg = new ClientMessage(new DTOElectCounsellorWithAssistant(
								new DTORegion(inputList.get(1)),
								new DTOColor(inputList.get(2))));
						socketOut.writeObject(msg);
						socketOut.flush();
						break;
					case "addAction":
						switch (inputList.get(1)) {
						case "buildEmpCard":
							msg = new ClientMessage(new DTOBuildEmporiumWithCard(
									new DTOPermissionCard(Integer.parseInt(inputList.get(2))),
									new DTOCity(inputList.get(3))));
							socketOut.writeObject(msg);
							socketOut.flush();
							break;
						case "buildEmpKing":
							//msg = new ClientMessage(new DTOBuildEmporiumWithKing());
							//socketOut.writeObject(msg);
							socketOut.flush();
							break;
						case "buyPermissionCard":
							//msg = new ClientMessage(new DTOBuyPermissionCard());
							//socketOut.writeObject(msg);
							socketOut.flush();
							break;
						case "electCounsellor":
							msg = new ClientMessage(new DTOElectCounsellor(
									new DTORegion(inputList.get(2)),
									new DTOColor(inputList.get(3))));
							socketOut.writeObject(msg);
							socketOut.flush();
							break;

						default:
							System.out.println(cmdNotFound.toString());
							break;
						}
						
					case "buildEmpCard":
						msg = new ClientMessage(new DTOBuildEmporiumWithCard(
								new DTOPermissionCard(Integer.parseInt(inputList.get(1))),
								new DTOCity(inputList.get(2))));
						socketOut.writeObject(msg);
						socketOut.flush();
						break;
					case "buildEmpKing":
						//msg = new ClientMessage(new DTOBuildEmporiumWithKing());
						//socketOut.writeObject(msg);
						socketOut.flush();
						break;
					case "buyPermissionCard":
						//msg = new ClientMessage(new DTOBuyPermissionCard());
						//socketOut.writeObject(msg);
						socketOut.flush();
						break;
					case "electCounsellor":
						msg = new ClientMessage(new DTOElectCounsellor(
								new DTORegion(inputList.get(1)),
								new DTOColor(inputList.get(2))));
						socketOut.writeObject(msg);
						socketOut.flush();
						break;
						
						
						/*----- QUERIES -----*/
					case "getscores":
						Query<String> queryScores = new GetScores();
						msg = new ClientMessage(queryScores);
						socketOut.writeObject(msg);
						socketOut.flush();
						break;
					case "getcoins":
						Query<String> queryCoins = new GetCoins();
						msg = new ClientMessage(queryCoins);
						socketOut.writeObject(msg);
						socketOut.flush();
						break;
					case "getcurrentplayer":
						Query<String> queryCurrentPlayer = new GetCurrentPlayer();
						msg = new ClientMessage(queryCurrentPlayer);
						socketOut.writeObject(msg);
						socketOut.flush();
						break;
						
					default:
						System.out.println(cmdNotFound.toString());
						break;
					}
				}
				
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
		}

	}

}
