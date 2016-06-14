package server;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import client.rmi.ClientViewRemote;
import client.socket.ClientMessage;
import view.rmi.RMIView;

public class RMIServer implements RMIServerInterface {

	private Map<ClientViewRemote, RMIView> clients;
	
	public RMIServer() {
		this.clients = new HashMap<ClientViewRemote, RMIView>();
	}
	
	@Override
	public void registerClient(ClientViewRemote clientStub) throws RemoteException{
		System.out.println("NEW CLIENT_RMI ACCEPTED");
		this.clients.put(clientStub, new RMIView());
	}
	
	@Override
	public void unregisterClient(ClientViewRemote clientStub) throws RemoteException {
		this.clients.remove(clientStub);
	}
	
	@Override
	public void receiveMessage(ClientMessage msgIn) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
}
