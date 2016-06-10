package client;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import view.RMIViewRemote;


public class ClientRMI {

	private final static String HOST = "127.0.0.1";
	private final static int PORT = 52365;
	private static final String NAME = "prigionieri";
	
	public static void main(String[] args) throws RemoteException, NotBoundException, AlreadyBoundException {
		
		Registry registry = LocateRegistry.getRegistry(HOST, PORT);
		RMIViewRemote serverStub = (RMIViewRemote) registry.lookup(NAME);

		ClientRMIView rmiView=new ClientRMIView();
		
		serverStub.registerClient(rmiView);
	}
}
