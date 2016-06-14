package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import view.rmi.RMIView;

public interface RMIServerInterface extends Remote {
	public RMIView connect() throws RemoteException;
}
