package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import client.cli.rmi.ClientViewRemote;
import client.cli.socket.ClientMessage;

public interface RMIServerInterface extends Remote {
	/**
	 * Add a player and his clientStub to the RMIServer
	 * 
	 * @param clientStub
	 * @throws RemoteException
	 */
	public void registerClient(ClientViewRemote clientStub) throws RemoteException;
	
	/**
	 * Remove a player and his clientStub from the RMIServer
	 * 
	 * @param clientStub
	 * @throws RemoteException
	 */
	public void unregisterClient(ClientViewRemote clientStub) throws RemoteException;
	
	/**
	 * Method called by the client to sent a message to the RMIServer
	 * 
	 * @param msgIn
	 * @throws RemoteException
	 */
	public void receiveMessage(ClientMessage msgIn) throws RemoteException;
}
