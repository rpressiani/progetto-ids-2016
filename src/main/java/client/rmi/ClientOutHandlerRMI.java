package client.rmi;

import java.rmi.RemoteException;
import java.util.Scanner;

import client.ClientOutHandler;
import client.socket.ClientMessage;
import server.RMIServerInterface;

public class ClientOutHandlerRMI extends ClientOutHandler {
	
	private RMIServerInterface serverStub;
	private ClientViewRemote clientRMI;
	
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

}
