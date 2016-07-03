package client.cli.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import model.changes.Change;
import server.RMIServerInterface;

public interface ClientViewRemote extends Remote {

	public void updateClient(Change c) throws RemoteException;
	public void changeStub(RMIServerInterface serverStub) throws RemoteException;
	public void print(String message) throws RemoteException;
}
