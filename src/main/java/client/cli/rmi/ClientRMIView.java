package client.cli.rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import model.changes.Change;
import server.RMIServerInterface;

public class ClientRMIView extends UnicastRemoteObject implements ClientViewRemote, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6354186384238327446L;
	
	/**
	 * Calls UnicastRemoteObject constructor
	 * @throws RemoteException
	 */
	public ClientRMIView() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateClient(Change c) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeStub(RMIServerInterface serverStub) throws RemoteException {
		//serverStub.registerClient(this);
	}

	@Override
	public void print(String message) throws RemoteException {
		System.out.println(message);
		
	}

}
