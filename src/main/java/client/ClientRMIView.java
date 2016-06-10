package client;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import model.changes.Change;

public class ClientRMIView extends UnicastRemoteObject implements ClientViewRemote, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6354186384238327446L;
	
	protected ClientRMIView() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateClient(Change c) throws RemoteException {
		// TODO Auto-generated method stub

	}

}
