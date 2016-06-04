package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import controller.Controller;
import model.GameState;
import model.player.Player;
import parser.Parser;
import view.ServerSocketView;

public class Server {
	
	private final static int PORT = 29999; //load from file!
	
	public Server() {
	}
	
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
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Server server = new Server();
		
		System.out.println("STARTING SOCKET");
		server.startSocket();
	}

}