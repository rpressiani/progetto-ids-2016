package client.cli.rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import server.RMIServerInterface;



public class CLIClientRMI {

	private static String HOST;
	private final static int PORT = 29998;
	private static final String NAME = "co4";
	
	private Scanner in;
	
	private RMIServerInterface serverStub;
	private ClientRMIView clientRMIView;
	
	/**
	 * @param in
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public CLIClientRMI(Scanner in, String HOST) throws RemoteException, NotBoundException {
		this.in = in;
		CLIClientRMI.HOST = HOST;
	}
	
	public void startClient() throws RemoteException, NotBoundException{
		Registry registry = LocateRegistry.getRegistry(HOST, PORT);
		this.serverStub = (RMIServerInterface) registry.lookup(NAME);
		
		this.clientRMIView=new ClientRMIView();
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.submit(new CLIClientOutHandlerRMI(serverStub, clientRMIView, this.in));
		
		this.serverStub.registerClient(clientRMIView);
	}
	
	/**
	 * @param args
	 * @throws RemoteException
	 * @throws NotBoundException
	 * @throws AlreadyBoundException
	 */
	public static void main(String[] args) throws RemoteException, NotBoundException, AlreadyBoundException {
		Scanner in = new Scanner(System.in);
		String localhost = new String("127.0.0.1");
		CLIClientRMI client = new CLIClientRMI(in, localhost);
		client.startClient();
	}
	
}