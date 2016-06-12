package client.rmi;

import java.rmi.RemoteException;

import client.ClientOutHandler;
import client.socket.ClientMessage;
import view.rmi.RMIViewRemote;

public class ClientOutHandlerRMI extends ClientOutHandler {
	
	private RMIViewRemote serverStub;
	private ClientViewRemote clientRMI;
	
	public ClientOutHandlerRMI(RMIViewRemote serverStub, ClientViewRemote clientRMI) {
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
