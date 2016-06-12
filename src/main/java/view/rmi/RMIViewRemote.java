package view.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import client.rmi.ClientViewRemote;
import client.socket.ClientMessage;
import model.player.Player;


public interface RMIViewRemote extends Remote {

	public void registerClient(ClientViewRemote clientStub) throws RemoteException;
	public void registerClient(Player player, ClientViewRemote clientStub) throws RemoteException;
	public void unregisterClient(Player player) throws RemoteException;
	public void receiveMessage(ClientMessage msg) throws RemoteException;
}
