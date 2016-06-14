package client.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import model.changes.Change;
import view.rmi.RMIViewRemote;

public interface ClientViewRemote extends Remote {

	public void updateClient(Change c) throws RemoteException;
	public void changeStub(RMIViewRemote serverStub) throws RemoteException;
}
