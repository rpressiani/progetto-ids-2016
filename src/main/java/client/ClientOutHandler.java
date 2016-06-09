package client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import dto.actions.DTONullAction;
import dto.actions.main.DTOBuildEmporiumWithCard;
import dto.actions.main.DTOBuildEmporiumWithKing;
import dto.actions.main.DTOBuyPermissionCard;
import dto.actions.main.DTOElectCounsellor;
import dto.actions.quick.DTOAddictionalAction;
import dto.actions.quick.DTOSubstitutePermissionCards;
import dto.actions.quick.DTOElectCounsellorWithAssistant;
import dto.actions.quick.DTOHireAssistant;
import dto.map.DTOCity;
import dto.map.DTORegion;
import dto.queries.request.DTOProposalOrderRequest;
import dto.queries.request.DTOScoresRequest;
import dto.queries.request.DTOCurrentPlayerRequest;
import dto.queries.request.DTOPingRequest;
import dto.queries.request.DTOPlayerInfoRequest;
import dto.queries.request.DTOPlayersListRequest;
import dto.utilities.DTOColor;
import dto.utilities.DTOPermissionCardSelection;
import dto.utilities.DTOPoliticalContainer;
import dto.utilities.DTOSetup;


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
			cmdNotFound.append("[ERROR] Insert legal commands\n");
			cmdNotFound.append("[ERROR] Enter help for command list\n");
			
			try {
				
				ClientMessage msg;
				ArrayList<Integer> proposal;
				
				if (inputList.get(0).equals("help")) {
					StringBuilder help = new StringBuilder();
					
					help.append("\n[CLI] Insert legal commands following the instruction below:\n");
					help.append("[CLI] <nickname> <command>\n");
					help.append("[CLI] COMMAND LIST: \n");
					help.append("[CLI] *\tMain Actions \n");
					help.append("[CLI] \t\tbuildEmpCard <idCard> <city>\n");
					help.append("[CLI] \t\tbuildEmpKing <city> <proposal>\n");
					help.append("[CLI] \t\tbuyPermissionCard <region> <cardIndex> <proposal> \n");
					help.append("[CLI] \t\telectCounsellor <region> <color>\n");
					help.append("[CLI] *\tQuick Actions \n");
					help.append("[CLI] \t\taddAction <action>\n");
					help.append("[CLI] \t\tsubPermissionCards <region>\n");
					help.append("[CLI] \t\telectCounsellorAssistant <region> <color>\n");
					help.append("[CLI] \t\thireAssistant\n");
					help.append("[CLI] *\tQueries \n");
					help.append("[CLI] \t\tgetscores \n");
					help.append("[CLI] \t\tgetcurrentplayer \n");
					help.append("[CLI] \t\tgetinfo \n");
					help.append("[CLI] \t\tgetplayerinfo <player> \n");
					help.append("[CLI] \t\tgetplayers \n");
					help.append("[CLI] *\tOther Commands \n");
					help.append("[CLI] \t\tpass\n");
					help.append("[CLI] \t\tping\n");
					help.append("[CLI] \n");
					help.append("[CLI] Remember that the order for the card proposal is the one written below:");
					msg = new ClientMessage(new DTOProposalOrderRequest());
					System.out.println(help.toString());
					socketOut.writeObject(msg);
					socketOut.flush();
					
				} else if(inputList.get(0).equals("setup")){
					msg = new ClientMessage(new DTOSetup(inputList.get(1), new DTOColor(inputList.get(2))));
					socketOut.writeObject(msg);
					socketOut.flush();
//					System.out.println("DTOSetup sent");
				} else {
					
					switch (inputList.get(0)) {
						
						/*----- GENERAL-----*/
					case "ping":
						msg = new ClientMessage(new DTOPingRequest());
						socketOut.writeObject(msg);
						socketOut.flush();
						break;
						
						/*----- ACTIONS -----*/
					case "subPermissionCards":
						if (inputList.size() == 2) {
							msg = new ClientMessage(new DTOSubstitutePermissionCards(new DTORegion(inputList.get(2))));
							socketOut.writeObject(msg);
							socketOut.flush();
							break;
						} else {
							System.out.println(cmdNotFound.toString());
							break;
						}
					case "hireAssistant":
						if (inputList.size() == 1) {
							msg = new ClientMessage(new DTOHireAssistant());
							socketOut.writeObject(msg);
							socketOut.flush();
							break;
						} else {
							System.out.println(cmdNotFound.toString());
							break;
						}
					case "electCounsellorAss":
						if (inputList.size() == 3) {
							msg = new ClientMessage(new DTOElectCounsellorWithAssistant(
									new DTORegion(inputList.get(1)),
									new DTOColor(inputList.get(2))));
							socketOut.writeObject(msg);
							socketOut.flush();
							break;
						} else {
							System.out.println(cmdNotFound.toString());
							break;
						}
					case "addAction":
						switch (inputList.get(1)) {
						case "buildEmpCard":
							if (inputList.size() == 4) {
								msg = new ClientMessage(new DTOBuildEmporiumWithCard(
										new DTOPermissionCardSelection(Integer.parseInt(inputList.get(2))),
										new DTOCity(inputList.get(3))));
								socketOut.writeObject(msg);
								socketOut.flush();
								break;
							} else {
								System.out.println(cmdNotFound.toString());
								break;
							}
						case "buildEmpKing":
							if (inputList.size() >= 4) {
								proposal = getProposal(inputList, 3);
								msg = new ClientMessage(new DTOBuildEmporiumWithKing(
										new DTOPoliticalContainer(proposal),
										new DTOCity(inputList.get(2))));

								if (proposal.get(proposal.size()-1).equals(-1)) {
									System.out.println(cmdNotFound.toString());
									break;
								} else {
									socketOut.writeObject(msg);
									socketOut.flush();
									break;
								}
							} else {
								System.out.println(cmdNotFound.toString());
								break;
							}
						case "buyPermissionCard":
							if (inputList.size() >= 4) {
								proposal = getProposal(inputList, 4);
								msg = new ClientMessage(new DTOBuyPermissionCard(
										new DTORegion(inputList.get(2)),
										new DTOPoliticalContainer(proposal),
										Integer.parseInt(inputList.get(3))));
								if (proposal.get(proposal.size()-1).equals(-1)) {
									System.out.println(cmdNotFound.toString());
									break;
								} else {
									socketOut.writeObject(msg);
									socketOut.flush();
									break;
								}
							} else {
								System.out.println(cmdNotFound.toString());
								break;
							}
						case "electCounsellor":
							if (inputList.size() == 3) {
								msg = new ClientMessage(new DTOElectCounsellor(
										new DTORegion(inputList.get(1)),
										new DTOColor(inputList.get(2))));
								socketOut.writeObject(msg);
								socketOut.flush();
								break;
							} else {
								System.out.println(cmdNotFound.toString());
								break;
							}

						default:
							System.out.println(cmdNotFound.toString());
							break;
						}
						
					case "buildEmpCard":
						if (inputList.size() == 3) {
							msg = new ClientMessage(new DTOBuildEmporiumWithCard(
									new DTOPermissionCardSelection(Integer.parseInt(inputList.get(1))),
									new DTOCity(inputList.get(2))));
							socketOut.writeObject(msg);
							socketOut.flush();
							break;
						} else {
							System.out.println(cmdNotFound.toString());
							break;
						}
					case "buildEmpKing":
						if (inputList.size() >= 3) {
							proposal = getProposal(inputList, 2);
							msg = new ClientMessage(new DTOBuildEmporiumWithKing(
									new DTOPoliticalContainer(proposal),
									new DTOCity(inputList.get(1))));

							if (proposal.get(proposal.size()-1).equals(-1)) {
								System.out.println(cmdNotFound.toString());
								break;
							} else {
								socketOut.writeObject(msg);
								socketOut.flush();
								break;
							}
						} else {
							System.out.println(cmdNotFound.toString());
							break;
						}
					case "buyPermissionCard":
						if (inputList.size() >= 3) {
							proposal = getProposal(inputList, 3);
							msg = new ClientMessage(new DTOBuyPermissionCard(
									new DTORegion(inputList.get(1)),
									new DTOPoliticalContainer(proposal),
									Integer.parseInt(inputList.get(2))));
							if (proposal.get(proposal.size()-1).equals(-1)) {
								System.out.println(cmdNotFound.toString());
								break;
							} else {
								socketOut.writeObject(msg);
								socketOut.flush();
								break;
							}
						} else {
							System.out.println(cmdNotFound.toString());
							break;
						}
					case "electCounsellor":
						if (inputList.size() == 3) {
							msg = new ClientMessage(new DTOElectCounsellor(
									new DTORegion(inputList.get(1)),
									new DTOColor(inputList.get(2))));
							socketOut.writeObject(msg);
							socketOut.flush();
							break;
						} else {
							System.out.println(cmdNotFound.toString());
							break;
						}
					case "pass":
						if (inputList.size() == 1) {
							msg = new ClientMessage(new DTONullAction());
							socketOut.writeObject(msg);
							socketOut.flush();
							break;
						} else {
							System.out.println(cmdNotFound.toString());
							break;
						}
						
						/*----- QUERIES -----*/
						
					case "getcurrentplayer":
						if (inputList.size() == 1) {
							msg = new ClientMessage(new DTOCurrentPlayerRequest());
							socketOut.writeObject(msg);
							socketOut.flush();
							break;
						} else {
							System.out.println(cmdNotFound.toString());
							break;
						}
					case "getscores":
						if (inputList.size() == 1) {
							msg = new ClientMessage(new DTOScoresRequest());
							socketOut.writeObject(msg);
							socketOut.flush();
							break;
						} else {
							System.out.println(cmdNotFound.toString());
							break;
						}
					case "getinfo":
						if (inputList.size() == 1) {
							msg = new ClientMessage(new DTOPlayerInfoRequest());
							socketOut.writeObject(msg);
							socketOut.flush();
							break;
						} else {
							System.out.println(cmdNotFound.toString());
							break;
						}
					case "getplayerinfo":
						if (inputList.size() == 2) {
							msg = new ClientMessage(new DTOPlayerInfoRequest(inputList.get(1)));
							socketOut.writeObject(msg);
							socketOut.flush();
							break;
						} else {
							System.out.println(cmdNotFound.toString());
							break;
						}
					case "getplayers":
						if (inputList.size() == 1) {
							msg = new ClientMessage(new DTOPlayersListRequest());
							socketOut.writeObject(msg);
							socketOut.flush();
							break;
						} else {
							System.out.println(cmdNotFound.toString());
							break;
						}
						
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
	
	/**
	 * returns the player political card proposal as an ArrayList of Integer
	 * 
	 * @param	inputList				List of String that contains the command and the parameters retrieved from the client
	 * @param	from					index from which the player political card proposal starts
	 * 
	 * @throws	NumberFormatException	if a NaN is passed by the player in the card proposal
	 * 
	 * @return							an ArrayList of Integer that contains the player political card proposal
	 */
	private static ArrayList<Integer> getProposal(ArrayList<String> inputList, int from){
		ArrayList<Integer> proposal = new ArrayList<Integer>();
		
		boolean error = false;
		
		for (int i = from; i < inputList.size(); i++) {
			try {
				if (error) {
					proposal.add(-1);
				} else {
					proposal.add(Integer.parseInt(inputList.get(i)));
				}
			} catch (NumberFormatException e) {
				proposal.add(-1);
				error = true;
			}
			
		}
		return proposal;
	}

}
