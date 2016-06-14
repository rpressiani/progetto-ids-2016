package client.rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import model.changes.Change;
import model.player.Player;
import view.rmi.RMIView;
import view.rmi.RMIViewRemote;

public class ClientRMIView extends UnicastRemoteObject implements ClientViewRemote, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6354186384238327446L;
	
	public ClientRMIView() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateClient(Change c) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeStub(RMIViewRemote serverStub) throws RemoteException {
		serverStub.registerClient(this);
	}

}
