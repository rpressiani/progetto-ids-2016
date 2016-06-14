package client.rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import view.rmi.RMIViewRemote;


public class ClientRMI {

	private final static String HOST = "127.0.0.1";
	private final static int PORT = 29998;
	private static final String NAME = "co4";
	
	private RMIViewRemote serverStub;
	
	public ClientRMI() throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry(HOST, PORT);
		this.serverStub = (RMIViewRemote) registry.lookup(NAME);
		
		ClientRMIView rmiView=new ClientRMIView();
		
		this.serverStub.registerClient(rmiView);
		
		ExecutorService executor = Executors.newFixedThreadPool(2); //load from file
		executor.submit(new ClientOutHandlerRMI(serverStub, rmiView));
		
	}
	
	public static void main(String[] args) throws RemoteException, NotBoundException, AlreadyBoundException {
		new ClientRMI();
	}
	
	public void initMatch() throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry(HOST, PORT);
		this.serverStub = (RMIViewRemote) registry.lookup("match1");
	}
	
	
}
