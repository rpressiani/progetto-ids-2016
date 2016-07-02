package gui.client;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import client.rmi.ClientOutHandlerRMI;
import client.rmi.ClientRMI;
import client.rmi.ClientRMIView;
import gui.LoginClientController;
import gui.MainApp;
import model.GameState;
import server.RMIServerInterface;

public class GUIClientRMI extends GUIClient {

	private static String HOST;
	private static int PORT;
	private static String NAME;
	//reference to the controller
	private LoginClientController loginController; 
	//
	private MainApp mainApp; 
	private GameState gameState; 
	private RMIServerInterface serverStub;
	private ClientRMIView clientRMIView;
	
	/* public void startClient() {
		Registry registry = LocateRegistry.getRegistry(HOST, PORT);
		this.serverStub = (RMIServerInterface) registry.lookup(loginController.getNickname());
		
		this.clientRMIView=new ClientRMIView();
		
		ExecutorService executor = Executors.newFixedThreadPool(2); //load from file
		executor.submit(new ClientOutHandlerRMI(serverStub, clientRMIView, this.in));
		
		this.serverStub.registerClient(clientRMIView);
	}*/ 
	
	public String getHost() {
		return HOST; 
	}
	public int getPort() {
		return PORT; 
	}
	public static void main(String[] args) throws RemoteException, NotBoundException, AlreadyBoundException {
		Scanner in = new Scanner(System.in); //have to fix it
		ClientRMI client = new ClientRMI(in);
		client.startClient();
	}
}
