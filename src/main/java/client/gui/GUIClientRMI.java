package client.gui;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import gui.MainApp;
import javafx.application.Application;
import server.RMIServerInterface;

public class GUIClientRMI {

	private static String HOST;
	private final static int PORT = 29998;
	private static final String NAME = "co4";
	
	private RMIServerInterface serverStub;
	private GUIClientRMIView clientRMIView;
	
	private GUIClientOutHandlerRMI outHandler;
	
	public GUIClientRMI(String HOST) {
		GUIClientRMI.HOST = HOST;
	}
	
	public void startClient() throws RemoteException, NotBoundException{
		Registry registry = LocateRegistry.getRegistry(GUIClientRMI.HOST, PORT);
		this.serverStub = (RMIServerInterface) registry.lookup(NAME);
		
		this.clientRMIView=new GUIClientRMIView();
		
//		ExecutorService executor = Executors.newFixedThreadPool(2);
//		executor.submit(new GUIClientOutHandlerRMI(serverStub, this.clientRMIView));
		
		this.outHandler = new GUIClientOutHandlerRMI(serverStub, this.clientRMIView);
		
		this.serverStub.registerClient(clientRMIView);
		
		String[] args = null;
		MainApp.print("Starting GUI");
		MainApp.setOutHandler(this.outHandler);
		Application.launch(MainApp.class, args);
	}
	
	public String getHost() {
		return HOST; 
	}
	public int getPort() {
		return PORT; 
	}
	public static void main(String[] args) throws RemoteException, NotBoundException, AlreadyBoundException {
		GUIClientRMI client = new GUIClientRMI("127.0.0.1");
		client.startClient();
	}
}
