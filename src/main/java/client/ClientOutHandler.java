package client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import client.socket.ClientMessage;
import dto.actions.DTONullAction;
import dto.actions.inputBonus.DTODoAgainAction;
import dto.actions.inputBonus.DTOGetAgainBonusPermission;
import dto.actions.inputBonus.DTOGetFreePermission;
import dto.actions.inputBonus.DTOGetFreeToken;
import dto.actions.main.DTOBuildEmporiumWithCard;
import dto.actions.main.DTOBuildEmporiumWithKing;
import dto.actions.main.DTOBuyPermissionCard;
import dto.actions.main.DTOElectCounsellor;
import dto.actions.market.DTOBuyAction;
import dto.actions.market.DTOSellAction;
import dto.actions.quick.DTOAddictionalAction;
import dto.actions.quick.DTOSubstitutePermissionCards;
import dto.actions.quick.DTOElectCounsellorWithAssistant;
import dto.actions.quick.DTOHireAssistant;
import dto.map.DTOCity;
import dto.map.DTORegion;
import dto.playerInfo.DTOAssistants;
import dto.playerInfo.DTOCoins;
import dto.queries.request.DTOProposalOrderRequest;
import dto.queries.request.DTOScoresRequest;
import dto.queries.request.DTOBalconiesStateRequest;
import dto.queries.request.DTOCurrentPlayerRequest;
import dto.queries.request.DTOFreeCounsellorsRequest;
import dto.queries.request.DTOMapRequest;
import dto.queries.request.DTOMarketStatusRequest;
import dto.queries.request.DTOPermissionAvailableRequest;
import dto.queries.request.DTOPingRequest;
import dto.queries.request.DTOPlayerInfoRequest;
import dto.queries.request.DTOPlayersListRequest;
import dto.utilities.DTOColor;
import dto.utilities.DTOPermissionCardSelection;
import dto.utilities.DTOPoliticalContainer;
import dto.utilities.DTOSetup;


public abstract class ClientOutHandler implements Runnable {
	
	private Scanner stdIn;
	
	public ClientOutHandler(Scanner in) {
		this.stdIn = in;
	}
	
	public abstract void sendMsg(ClientMessage msg);
	
	public void run() {
		
		System.out.println("[CLIENT] ClientOutHandler is RUNNING");
		
		while (true) {
			String inputLine = stdIn.nextLine();
			ArrayList<String> inputList = new ArrayList<String>(Arrays.asList(inputLine.split(" ")));
			
			StringBuilder cmdNotFound = new StringBuilder();
			cmdNotFound.append("\n[ERROR] Command not found!\n");
			cmdNotFound.append("[ERROR] Insert legal commands\n");
			cmdNotFound.append("[ERROR] Enter help for command list\n");
			
				
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
				help.append("[CLI] \t\taddAction <main_action>\n");
				help.append("[CLI] \t\tsubPermissionCards <region>\n");
				help.append("[CLI] \t\telectCounsellorAssistant <region> <color>\n");
				help.append("[CLI] \t\thireAssistant\n");
				
				help.append("[CLI] *\tBonus action\n");
				help.append("[CLI] \t\tbonusToken <city1> ... <city-n> \n");
				help.append("[CLI] \t\tbonusFreePermission <region> <index> \n");
				help.append("[CLI] \t\tbonusPermissionGift <index> \n");
				help.append("[CLI] \t\tbonusDoActionAgain <main_action> \n");
				
				help.append("[CLI] *\tMarket action\n");
				help.append("[CLI] \t\tsell \n");
				help.append("[CLI] \t\tbuy <playerNickname> \n");
				
				help.append("[CLI] *\tQueries \n");
				help.append("[CLI] \t\tgetscores \n");
				help.append("[CLI] \t\tgetcurrentplayer \n");
				help.append("[CLI] \t\tgetinfo \n");
				help.append("[CLI] \t\tgetplayerinfo <player> \n");
				help.append("[CLI] \t\tgetplayers \n");
				help.append("[CLI] \t\tgetfreecounsellors \n");
				help.append("[CLI] \t\tgetbalconies \n");
				help.append("[CLI] \t\tgetpermissionavailable \n");
				help.append("[CLI] \t\tgetmap \n");
				help.append("[CLI] \t\tgetmarket \n");
				
				help.append("[CLI] *\tOther Commands \n");
				help.append("[CLI] \t\tpass\n");
				help.append("[CLI] \t\tping\n");
				help.append("[CLI] \n");
				help.append("[CLI] Remember that the order for the card proposal is the one written below:");
				msg = new ClientMessage(new DTOProposalOrderRequest());
				System.out.println(help.toString());
				sendMsg(msg);
				
			} else if(inputList.get(0).equals("setup")){
				msg = new ClientMessage(new DTOSetup(inputList.get(1), new DTOColor(inputList.get(2))));
				sendMsg(msg);
			} else {
				
				switch (inputList.get(0)) {
					
					/*----- GENERAL-----*/
				case "ping":
					msg = new ClientMessage(new DTOPingRequest());
					sendMsg(msg);
					break;
					
					/*----- ACTIONS -----*/
				case "subPermissionCards":
					if (inputList.size() == 2) {
						msg = new ClientMessage(new DTOSubstitutePermissionCards(new DTORegion(inputList.get(2))));
						sendMsg(msg);
						break;
					} else {
						System.out.println(cmdNotFound.toString());
						break;
					}
				case "hireAssistant":
					if (inputList.size() == 1) {
						msg = new ClientMessage(new DTOHireAssistant());
						sendMsg(msg);
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
						sendMsg(msg);
						break;
					} else {
						System.out.println(cmdNotFound.toString());
						break;
					}
				case "addAction":
					System.out.println("addAction detected");
					switch (inputList.get(1)) {
					case "buildEmpCard":
						if (inputList.size() == 4) {
							msg = new ClientMessage(new DTOAddictionalAction(new DTOBuildEmporiumWithCard(
									new DTOPermissionCardSelection(Integer.parseInt(inputList.get(2))),
									new DTOCity(inputList.get(3)))));
							sendMsg(msg);
							break;
						} else {
							System.out.println(cmdNotFound.toString());
							break;
						}
					case "buildEmpKing":
						if (inputList.size() >= 4) {
							proposal = getProposal(inputList, 3);
							msg = new ClientMessage(new DTOAddictionalAction(new DTOBuildEmporiumWithKing(
									new DTOPoliticalContainer(proposal),
									new DTOCity(inputList.get(2)))));

							if (proposal.get(proposal.size()-1).equals(-1)) {
								System.out.println(cmdNotFound.toString());
								break;
							} else {
								sendMsg(msg);
								break;
							}
						} else {
							System.out.println(cmdNotFound.toString());
							break;
						}
					case "buyPermissionCard":
						if (inputList.size() >= 4) {
							proposal = getProposal(inputList, 4);
							msg = new ClientMessage(new DTOAddictionalAction(new DTOBuyPermissionCard(
									new DTORegion(inputList.get(2)),
									new DTOPoliticalContainer(proposal),
									Integer.parseInt(inputList.get(3)))));
							if (proposal.get(proposal.size()-1).equals(-1)) {
								System.out.println(cmdNotFound.toString());
								break;
							} else {
								sendMsg(msg);
								break;
							}
						} else {
							System.out.println(cmdNotFound.toString());
							break;
						}
					case "electCounsellor":
						System.out.println("electDetected");
						System.out.println(inputList.size());
						if (inputList.size() == 4) {
							System.out.println("inside if");
							msg = new ClientMessage(new DTOAddictionalAction(new DTOElectCounsellor(
									new DTORegion(inputList.get(2)),
									new DTOColor(inputList.get(3)))));
							sendMsg(msg);
							System.out.println("msg sent");
							break;
						} else {
							System.out.println(cmdNotFound.toString());
							break;
						}

					default:
						System.out.println(cmdNotFound.toString());
						break;
					}
					break;
					
				case "buildEmpCard":
					if (inputList.size() == 3) {
						msg = new ClientMessage(new DTOBuildEmporiumWithCard(
								new DTOPermissionCardSelection(Integer.parseInt(inputList.get(1))),
								new DTOCity(inputList.get(2))));
						sendMsg(msg);
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
							sendMsg(msg);
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
							sendMsg(msg);
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
						sendMsg(msg);
						break;
					} else {
						System.out.println(cmdNotFound.toString());
						break;
					}
				case "pass":
					if (inputList.size() == 1) {
						msg = new ClientMessage(new DTONullAction());
						sendMsg(msg);
						break;
					} else {
						System.out.println(cmdNotFound.toString());
						break;
					}
					
					/*----- BONUS -----*/
					
				case "buy":
					if (inputList.size() == 2) {
						msg = new ClientMessage(new DTOBuyAction(inputList.get(1)));
						sendMsg(msg);
						break;
					} else {
						System.out.println(cmdNotFound.toString());
						break;
					}
				case "sell":
					if (inputList.size() == 1) {
						
						System.out.println("Now insert what you want to sell following the order below:");
						System.out.println("<coins> <assistants> p<cardId(1)> ... p<cardId(n)> <politicalProposal>");
						System.out.println("If you don't want to sell coins, assistants or political cards insert 0 (zero) in that field.\n");
						String sellLine = stdIn.nextLine();
						ArrayList<String> sellList = new ArrayList<String>(Arrays.asList(sellLine.split(" ")));
						
						if (sellList.size() <= 2) {
							System.out.println(cmdNotFound.toString());
							break;
						}
						
						DTOCoins sellCoins;
						try {
							sellCoins = new DTOCoins(Integer.parseInt(sellList.get(0)));
						} catch (NumberFormatException e) {
							sellCoins = new DTOCoins(0);
						}
						DTOAssistants sellAssistants;
						try {
							sellAssistants = new DTOAssistants(Integer.parseInt(sellList.get(1)));
						} catch (NumberFormatException e) {
							sellAssistants = new DTOAssistants(0);
						}
						Set<DTOPermissionCardSelection> sellPermissions = new HashSet<DTOPermissionCardSelection>();
						int index = 2;
						while (sellList.get(index).charAt(0) == 'p') {
							Integer cardId = Integer.parseInt(sellList.get(index).substring(1));
							try {
								sellPermissions.add(new DTOPermissionCardSelection(cardId));
							} catch (NumberFormatException e) {
								sellPermissions.add(new DTOPermissionCardSelection(0));
							}
							index++;
						}
						
						proposal = getProposal(sellList, index);
						if (proposal.get(proposal.size()-1).equals(-1)) {
							System.out.println(cmdNotFound.toString());
							break;
						}
						
						DTOPoliticalContainer sellPoliticals = new DTOPoliticalContainer(proposal);
						
						System.out.println("Now insert what you want to buy following the order below:");
						System.out.println("<coins> <assistants> p<cardId(1)> ... p<cardId(n)> <politicalProposal>");
						System.out.println("If you don't want to sell coins, assistants or political cards insert 0 (zero) in that field.\n");
						String buyLine = stdIn.nextLine();
						ArrayList<String> buyList = new ArrayList<String>(Arrays.asList(buyLine.split(" ")));
						
						if (buyList.size() <= 2) {
							System.out.println(cmdNotFound.toString());
							break;
						}
						
						DTOCoins buyCoins;
						try {
							buyCoins = new DTOCoins(Integer.parseInt(buyList.get(0)));
						} catch (NumberFormatException e) {
							buyCoins = new DTOCoins(0);
						}
						DTOAssistants buyAssistants;
						try {
							buyAssistants = new DTOAssistants(Integer.parseInt(buyList.get(1)));
						} catch (NumberFormatException e) {
							buyAssistants = new DTOAssistants(0);
						}
						Set<DTOPermissionCardSelection> buyPermissions = new HashSet<DTOPermissionCardSelection>();
						index = 2;
						while (buyList.get(index).charAt(0) == 'p') {
							Integer cardId = Integer.parseInt(buyList.get(index).substring(1));
							try {
								buyPermissions.add(new DTOPermissionCardSelection(cardId));
							} catch (NumberFormatException e) {
								buyPermissions.add(new DTOPermissionCardSelection(0));
							}
							index++;
						}
						
						proposal = getProposal(buyList, index);
						if (proposal.get(proposal.size()-1).equals(-1)) {
							System.out.println(cmdNotFound.toString());
							break;
						}
						
						DTOPoliticalContainer buyPoliticals = new DTOPoliticalContainer(proposal);

						msg = new ClientMessage(new DTOSellAction(
								sellCoins,
								sellAssistants,
								sellPermissions,
								sellPoliticals,
								buyCoins,
								buyAssistants,
								buyPermissions,
								buyPoliticals));
						sendMsg(msg);
						break;
					} else {
						System.out.println(cmdNotFound.toString());
						break;
					}
					
					/*----- BONUS -----*/
					
				case "bonusToken":
					if (inputList.size() >= 2) {
						Set<DTOCity> cities = new HashSet<DTOCity>();
						for (int i = 1; i < inputList.size(); i++) {
							cities.add(new DTOCity(inputList.get(i)));
						}
						msg = new ClientMessage(new DTOGetFreeToken(cities));
						sendMsg(msg);
						break;
					} else {
						System.out.println(cmdNotFound.toString());
						break;
					}
				case "bonusFreePermission":
					if (inputList.size() == 3) {
						DTORegion region = new DTORegion(inputList.get(1));
						int index = Integer.parseInt(inputList.get(2));
						msg = new ClientMessage(new DTOGetFreePermission(region, index));
						sendMsg(msg);
						break;
					} else {
						System.out.println(cmdNotFound.toString());
						break;
					}
				case "bonusPermissionGift":
					if (inputList.size() == 2) {
						DTOPermissionCardSelection card = new DTOPermissionCardSelection(Integer.parseInt(inputList.get(1)));
						msg = new ClientMessage(new DTOGetAgainBonusPermission(card));
						sendMsg(msg);
						break;
					} else {
						System.out.println(cmdNotFound.toString());
						break;
					}
				case "bonusDoActionAgain":
					switch (inputList.get(1)) {
						case "buildEmpCard":
							if (inputList.size() == 4) {
								msg = new ClientMessage(new DTODoAgainAction(new DTOBuildEmporiumWithCard(
										new DTOPermissionCardSelection(Integer.parseInt(inputList.get(2))),
										new DTOCity(inputList.get(3)))));
								sendMsg(msg);
								break;
							} else {
								System.out.println(cmdNotFound.toString());
								break;
							}
						case "buildEmpKing":
							if (inputList.size() >= 4) {
								proposal = getProposal(inputList, 3);
								msg = new ClientMessage(new DTODoAgainAction(new DTOBuildEmporiumWithKing(
										new DTOPoliticalContainer(proposal),
										new DTOCity(inputList.get(2)))));

								if (proposal.get(proposal.size()-1).equals(-1)) {
									System.out.println(cmdNotFound.toString());
									break;
								} else {
									sendMsg(msg);
									break;
								}
							} else {
								System.out.println(cmdNotFound.toString());
								break;
							}
						case "buyPermissionCard":
							if (inputList.size() >= 4) {
								proposal = getProposal(inputList, 4);
								msg = new ClientMessage(new DTODoAgainAction(new DTOBuyPermissionCard(
										new DTORegion(inputList.get(2)),
										new DTOPoliticalContainer(proposal),
										Integer.parseInt(inputList.get(3)))));
								if (proposal.get(proposal.size()-1).equals(-1)) {
									System.out.println(cmdNotFound.toString());
									break;
								} else {
									sendMsg(msg);
									break;
								}
							} else {
								System.out.println(cmdNotFound.toString());
								break;
							}
						case "electCounsellor":
							System.out.println("electDetected");
							System.out.println(inputList.size());
							if (inputList.size() == 4) {
								System.out.println("inside if");
								msg = new ClientMessage(new DTODoAgainAction(new DTOElectCounsellor(
										new DTORegion(inputList.get(2)),
										new DTOColor(inputList.get(3)))));
								sendMsg(msg);
								System.out.println("msg sent");
								break;
							} else {
								System.out.println(cmdNotFound.toString());
								break;
							}

						default:
							System.out.println(cmdNotFound.toString());
							break;
						}
						break;
					
					/*----- QUERIES -----*/
					
				case "getcurrentplayer":
					if (inputList.size() == 1) {
						msg = new ClientMessage(new DTOCurrentPlayerRequest());
						sendMsg(msg);
						break;
					} else {
						System.out.println(cmdNotFound.toString());
						break;
					}
				case "getscores":
					if (inputList.size() == 1) {
						msg = new ClientMessage(new DTOScoresRequest());
						sendMsg(msg);
						break;
					} else {
						System.out.println(cmdNotFound.toString());
						break;
					}
				case "getinfo":
					if (inputList.size() == 1) {
						msg = new ClientMessage(new DTOPlayerInfoRequest());
						sendMsg(msg);
						break;
					} else {
						System.out.println(cmdNotFound.toString());
						break;
					}
				case "getplayerinfo":
					if (inputList.size() == 2) {
						msg = new ClientMessage(new DTOPlayerInfoRequest(inputList.get(1)));
						sendMsg(msg);
						break;
					} else {
						System.out.println(cmdNotFound.toString());
						break;
					}
				case "getplayers":
					if (inputList.size() == 1) {
						msg = new ClientMessage(new DTOPlayersListRequest());
						sendMsg(msg);
						break;
					} else {
						System.out.println(cmdNotFound.toString());
						break;
					}
				case "getfreecounsellors":
					if (inputList.size() == 1) {
						msg = new ClientMessage(new DTOFreeCounsellorsRequest());
						sendMsg(msg);
						break;
					} else {
						System.out.println(cmdNotFound.toString());
						break;
					}
				case "getbalconies":
					if (inputList.size() == 1) {
						msg = new ClientMessage(new DTOBalconiesStateRequest());
						sendMsg(msg);
						break;
					} else {
						System.out.println(cmdNotFound.toString());
						break;
					}
				case "getpermissionavailable":
					if (inputList.size() == 1) {
						msg = new ClientMessage(new DTOPermissionAvailableRequest());
						sendMsg(msg);
						break;
					} else {
						System.out.println(cmdNotFound.toString());
						break;
					}
				case "getmap":
					if (inputList.size() == 1) {
						msg = new ClientMessage(new DTOMapRequest());
						sendMsg(msg);
						break;
					} else {
						System.out.println(cmdNotFound.toString());
						break;
					}
				case "getmarket":
					if (inputList.size() == 1) {
						msg = new ClientMessage(new DTOMarketStatusRequest());
						sendMsg(msg);
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
				
		}

	}
	
	/**
	 * returns the player political card proposal as an ArrayList of Integer
	 * 
	 * @param	inputList				list of Strings that contains the command and the parameters retrieved from the client

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
