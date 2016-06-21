package client.rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import server.RMIServerInterface;



public class ClientRMI {

	private final static String HOST = "127.0.0.1";
	private final static int PORT = 29998;
	private static final String NAME = "co4";
	
	private Scanner in;
	
	private RMIServerInterface serverStub;
	private ClientRMIView clientRMIView;
	
	public ClientRMI(Scanner in) throws RemoteException, NotBoundException {
		this.in = in;
	}
	
	public void startClient() throws RemoteException, NotBoundException{
		Registry registry = LocateRegistry.getRegistry(HOST, PORT);
		this.serverStub = (RMIServerInterface) registry.lookup(NAME);
		
		this.clientRMIView=new ClientRMIView();
		
		ExecutorService executor = Executors.newFixedThreadPool(2); //load from file
		executor.submit(new ClientOutHandlerRMI(serverStub, clientRMIView, this.in));
		
		this.serverStub.registerClient(clientRMIView); //before or after executor?
	}
	
	public static void main(String[] args) throws RemoteException, NotBoundException, AlreadyBoundException {
		Scanner in = new Scanner(System.in);
		ClientRMI client = new ClientRMI(in);
		client.startClient();
	}
	
}