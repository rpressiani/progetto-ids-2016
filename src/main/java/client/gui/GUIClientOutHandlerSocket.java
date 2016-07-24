package client.gui;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import client.ClientMessage;
import client.ClientOutHandler;
import dto.actions.market.DTOSellAction;
import dto.playerInfo.DTOAssistants;
import dto.playerInfo.DTOCoins;
import dto.utilities.DTOPermissionCardSelection;
import dto.utilities.DTOPoliticalContainer;

public class GUIClientOutHandlerSocket extends ClientOutHandler {
	
private ObjectOutputStream socketOut; 
	
	/**
	 * @param socketOut
	 * @param in
	 */
	public GUIClientOutHandlerSocket(ObjectOutputStream socketOut) {
		if(socketOut==null) {
			throw new IllegalArgumentException("socketOut cannot be null"); 
		}
		this.socketOut = socketOut; 
	}

	@Override
	public void sendMsg(ClientMessage msg) {
		try {
			this.socketOut.writeObject(msg);
			this.socketOut.flush();
		} catch (IOException e) {
			System.out.println("SERVER IS DOWN");
		}
	}

	@Override
	public void notifyCmdNotFound() {

	}

	/**
	 * @see client.ClientOutHandler#sellCommand()
	 */
	public void sellCommand(ArrayList<String> inputList) {
		ArrayList<Integer> proposal = new ArrayList<Integer>();
		ClientMessage msg;
		
		DTOCoins sellCoins;
		try {
			sellCoins = new DTOCoins(Integer.parseInt(inputList.get(1)));
		} catch (NumberFormatException e) {
			sellCoins = new DTOCoins(0);
		}
		DTOAssistants sellAssistants;
		try {
			sellAssistants = new DTOAssistants(Integer.parseInt(inputList.get(2)));
		} catch (NumberFormatException e) {
			sellAssistants = new DTOAssistants(0);
		}
		Set<DTOPermissionCardSelection> sellPermissions = new HashSet<DTOPermissionCardSelection>();
		int index = 3;
		while (inputList.get(index).charAt(0) == 'p') {
			Integer cardId = Integer.parseInt(inputList.get(index).substring(1));
			try {
				sellPermissions.add(new DTOPermissionCardSelection(cardId));
			} catch (NumberFormatException e) {
				sellPermissions.add(new DTOPermissionCardSelection(0));
			}
			index++;
		}
		boolean error = false;
		for (int i = index; i < index+7; i++) {
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
		if (proposal.get(proposal.size()-1).equals(-1)) {
			notifyCmdNotFound();
			return;
		}
		
		DTOPoliticalContainer sellPoliticals = new DTOPoliticalContainer(proposal);
		
		DTOCoins buyCoins;
		try {
			buyCoins = new DTOCoins(Integer.parseInt(inputList.get(index)));
		} catch (NumberFormatException e) {
			buyCoins = new DTOCoins(0);
		}
		DTOAssistants buyAssistants;
		try {
			buyAssistants = new DTOAssistants(Integer.parseInt(inputList.get(index+1)));
		} catch (NumberFormatException e) {
			buyAssistants = new DTOAssistants(0);
		}
		Set<DTOPermissionCardSelection> buyPermissions = new HashSet<DTOPermissionCardSelection>();
		int index2 = index+2;
		while (inputList.get(index2).charAt(0) == 'p') {
			Integer cardId = Integer.parseInt(inputList.get(index2).substring(1));
			try {
				buyPermissions.add(new DTOPermissionCardSelection(cardId));
			} catch (NumberFormatException e) {
				buyPermissions.add(new DTOPermissionCardSelection(0));
			}
			index2++;
		}
		
		error = false;
		proposal = new ArrayList<Integer>();
		for (int i = index2; i < index+7; i++) {
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
