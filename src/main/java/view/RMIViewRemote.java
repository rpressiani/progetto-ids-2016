package view;

import java.rmi.Remote;
import java.rmi.RemoteException;

import client.ClientViewRemote;


public interface RMIViewRemote extends Remote {

	public void registerClient(ClientViewRemote clientStub) throws RemoteException;
}
