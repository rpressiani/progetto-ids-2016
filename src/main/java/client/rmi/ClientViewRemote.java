package client.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import model.changes.Change;

public interface ClientViewRemote extends Remote {

	public void updateClient(Change c) throws RemoteException;
}
