package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import model.player.Player;
import view.rmi.RMIView;
import view.rmi.RMIViewRemote;
import view.socket.ServerSocketView;

public class Server {
	
	private final static int PORT = 29999; //load from file!
	private final static int RMI_PORT = 52365;
	private final String NAME = "prigionieri";
	
	/**
	 * start the socket
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void startSocket() throws IOException, ClassNotFoundException {
		ExecutorService viewExecutor = Executors.newCachedThreadPool(); 
		ExecutorService matchExecutor = Executors.newCachedThreadPool();
		ServerSocket serverSocket = new ServerSocket(PORT); 
		System.out.println("SERVER SOCKET READY ON PORT: " + PORT);
		
		Map<Player, ServerSocketView> tmpViewSocket = new HashMap<Player, ServerSocketView>();
		matchExecutor.submit(new MatchCreator(tmpViewSocket));
		
		
		while(true) {
			
			Socket socket = serverSocket.accept();
			ServerSocketView view = new ServerSocketView(socket);
			viewExecutor.submit(view);
			tmpViewSocket.put(view.getPlayer(), view);
			System.out.println("NEW CLIENTSOCKET ACCEPTED");
		}
	}
	
	private void startRMI() throws RemoteException, AlreadyBoundException{
		Registry registry = LocateRegistry.createRegistry(RMI_PORT);
		System.out.println("Constructing the RMI registry");
		RMIView rmiView=new RMIView();
		RMIViewRemote viewRemote=(RMIViewRemote) UnicastRemoteObject.exportObject(rmiView, 0);
		System.out.println("Binding the server implementation to the registry");
		registry.bind(NAME, rmiView);
	}
	
	/**
	 * 
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws AlreadyBoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, AlreadyBoundException {
		Server server = new Server();
		
		System.out.println("STARTING RMI");
		server.startRMI();
		
		System.out.println("STARTING SOCKET");
		server.startSocket();
	
	}

}