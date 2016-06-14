package client.rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import server.RMIServerInterface;



public class ClientRMI {

	private final static String HOST = "127.0.0.1";
	private final static int PORT = 29998;
	private static final String NAME = "co4";
	
	private RMIServerInterface serverStub;
	
	public ClientRMI() throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry(HOST, PORT);
		this.serverStub = (RMIServerInterface) registry.lookup(NAME);
		
		ClientRMIView clientRmiView=new ClientRMIView();
		
		this.serverStub.registerClient(clientRmiView);
		
		ExecutorService executor = Executors.newFixedThreadPool(2); //load from file
		//executor.submit(new ClientOutHandlerRMI(rmiView, clientRmiView));
		
	}
	
	public static void main(String[] args) throws RemoteException, NotBoundException, AlreadyBoundException {
		new ClientRMI();
	}
	
}
