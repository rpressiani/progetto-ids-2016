package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import client.rmi.ClientViewRemote;
import client.socket.ClientMessage;

public interface RMIServerInterface extends Remote {
	public void registerClient(ClientViewRemote clientStub) throws RemoteException;
	public void unregisterClient(ClientViewRemote clientStub) throws RemoteException;
	public void receiveMessage(ClientMessage msgIn) throws RemoteException;
}
