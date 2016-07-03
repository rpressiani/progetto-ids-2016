package client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import client.socket.ClientMessage;
import dto.actions.market.DTOSellAction;
import dto.playerInfo.DTOAssistants;
import dto.playerInfo.DTOCoins;
import dto.utilities.DTOPermissionCardSelection;
import dto.utilities.DTOPoliticalContainer;


public abstract class CLIClientOutHandler extends ClientOutHandler implements Runnable {
	
	private Scanner stdIn;
	
	/**
	 * @param in
	 * Constructor
	 */
	public CLIClientOutHandler(Scanner in) {
		this.stdIn = in;
	}
	
	public void run() {
		
		System.out.println("[CLIENT] ClientOutHandler is RUNNING");
		
		while (true) {
			String inputLine = stdIn.nextLine();
			ArrayList<String> inputList = new ArrayList<String>(Arrays.asList(inputLine.split(" ")));
			
			
			
			activate(inputList);
				
		}

	}
	
	public void sellCommand(){
		ArrayList<Integer> proposal;
		ClientMessage msg;
		
		System.out.println("Now insert what you want to sell following the order below:");
		System.out.println("<coins> <assistants> p<cardId(1)> ... p<cardId(n)> <politicalProposal>");
		System.out.println("If you don't want to sell coins, assistants or political cards insert 0 (zero) in that field.\n");
		String sellLine = stdIn.nextLine();
		ArrayList<String> sellList = new ArrayList<String>(Arrays.asList(sellLine.split(" ")));
		
		if (sellList.size() <= 2) {
			notifyCmdNotFound();
			return;
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
		
		proposal = ClientOutHandler.getProposal(sellList, index);
		if (proposal.get(proposal.size()-1).equals(-1)) {
			notifyCmdNotFound();
			return;
		}
		
		DTOPoliticalContainer sellPoliticals = new DTOPoliticalContainer(proposal);
		
		System.out.println("Now insert what you want to buy following the order below:");
		System.out.println("<coins> <assistants> p<cardId(1)> ... p<cardId(n)> <politicalProposal>");
		System.out.println("If you don't want to sell coins, assistants or political cards insert 0 (zero) in that field.\n");
		String buyLine = stdIn.nextLine();
		ArrayList<String> buyList = new ArrayList<String>(Arrays.asList(buyLine.split(" ")));
		
		if (buyList.size() <= 2) {
			notifyCmdNotFound();
			return;
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
		
		proposal = ClientOutHandler.getProposal(buyList, index);
		if (proposal.get(proposal.size()-1).equals(-1)) {
			notifyCmdNotFound();
			return;
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
		return;
	}

}
