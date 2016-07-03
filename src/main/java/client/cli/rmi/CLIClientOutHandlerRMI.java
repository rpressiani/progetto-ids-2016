package client.cli.rmi;

import java.rmi.RemoteException;
import java.util.Scanner;

import client.ClientMessage;
import client.cli.CLIClientOutHandler;
import server.RMIServerInterface;

public class CLIClientOutHandlerRMI extends CLIClientOutHandler {
	
	private RMIServerInterface serverStub;
	private ClientViewRemote clientRMI;
	
	/**
	 * @param serverStub
	 * @param clientRMI
	 * @param in
	 */
	public CLIClientOutHandlerRMI(RMIServerInterface serverStub, ClientViewRemote clientRMI, Scanner in) {
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
}
