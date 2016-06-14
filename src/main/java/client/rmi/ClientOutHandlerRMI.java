package client.rmi;

import java.rmi.RemoteException;

import client.ClientOutHandler;
import client.socket.ClientMessage;
import server.RMIServerInterface;

public class ClientOutHandlerRMI extends ClientOutHandler {
	
	private RMIServerInterface serverStub;
	private ClientViewRemote clientRMI;
	
	public ClientOutHandlerRMI(RMIServerInterface serverStub, ClientViewRemote clientRMI) {
		this.serverStub = serverStub;
		this.clientRMI = clientRMI;
	}

	@Override
	public void sendMsg(ClientMessage msgIn) {
		ClientMessage msgOut = new ClientMessage(this.clientRMI, msgIn.getMessage());
		try {
			System.out.println("MSG READY");
			this.serverStub.receiveMessage(msgOut);
			System.out.println("MSG SENT");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
