package server;

import java.rmi.RemoteException;

import view.rmi.RMIView;

public class RMIServer implements RMIServerInterface {

	public RMIView connect() throws RemoteException{
		return new RMIView();
	}
}
