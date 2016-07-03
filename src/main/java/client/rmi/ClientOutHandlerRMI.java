package client.rmi;

import java.rmi.RemoteException;
import java.util.Scanner;

import client.CLIClientOutHandler;
import client.socket.ClientMessage;
import server.RMIServerInterface;

public class ClientOutHandlerRMI extends CLIClientOutHandler {
	
	private RMIServerInterface serverStub;
	private ClientViewRemote clientRMI;
	
	/**
	 * @param serverStub
	 * @param clientRMI
	 * @param in
	 */
	public ClientOutHandlerRMI(RMIServerInterface serverStub, ClientViewRemote clientRMI, Scanner in) {
		super(in);
		this.serverStub = serverStub;
		this.clientRMI = clientRMI;
	}

	@Override
	public void sendMsg(ClientMessage msgIn) {
		ClientMessage msgOut = new ClientMessage(this.clientRMI, msgIn.getMessage());
		try {
			this.serverStub.receiveMessage(msgOut);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void notifyCmdNotFound() {
		StringBuilder cmdNotFound = new StringBuilder();
		cmdNotFound.append("\n[ERROR] Command not found!\n");
		cmdNotFound.append("[ERROR] Insert legal commands\n");
		cmdNotFound.append("[ERROR] Enter help for command list\n");
		
		System.out.println(cmdNotFound.toString());
		
	}

}
