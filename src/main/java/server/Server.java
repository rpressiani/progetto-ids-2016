package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.text.View;

import controller.Controller;
import model.GameState;
import model.map.Ancestry;
import model.player.Player;
import parser.Parser;
import utilities.Color;
import view.ServerSocketView;

public class Server {
	
	private final static int PORT = 29999; //load from file!
	private GameState gameState; 
	private Controller controller;
	private Parser parser;
	
	//players presence in Server need to be verified!! 
	private ArrayList<Player> players;
	
	public Server() {
		this.parser = new Parser();
		this.players = new ArrayList<Player>();
		
		//players created for testing reasons
//		this.players.add(new Player("player1", new Color("RED")));
//		this.players.add(new Player("player2", new Color("GREEN")));
//		this.players.add(new Player("player3", new Color("YELLOW")));
//		this.players.add(new Player("player4", new Color("BLUE")));
//		
//		this.gameState = new GameState(parser, players);
//		System.out.println(this.gameState.getCounsellorGarbage().toString());
//		
//		players.get(0).initPlayer(this.gameState.getPoliticalDeck(), 0, this.parser);
//		players.get(1).initPlayer(this.gameState.getPoliticalDeck(), 1, this.parser);
//		players.get(2).initPlayer(this.gameState.getPoliticalDeck(), 2, this.parser);
//		players.get(3).initPlayer(this.gameState.getPoliticalDeck(), 3, this.parser);
//		
//		this.controller = new Controller(gameState); 
	}
	
	private void startSocket() throws IOException, ClassNotFoundException {
		ExecutorService executor = Executors.newCachedThreadPool(); 
		ServerSocket serverSocket = new ServerSocket(PORT); 
		System.out.println("SERVER SOCKET READY ON PORT: " + PORT);
		
		int i = 0;
		int counter = 2;
		Map<ServerSocketView, Socket> tmpViewSocket = new HashMap<ServerSocketView, Socket>();
//		Map<Player, Socket> tmpPlayerSocket = new HashMap<Player, Socket>();
		
		while(true) {
			if (i >= counter) {
//				System.out.println("ciao");
				
				for (Map.Entry<ServerSocketView, Socket> entry : tmpViewSocket.entrySet()) {
					if (entry.getKey().isEnabled()) {
						Player player = entry.getKey().getPlayer();
						this.players.add(player);
					}
//					tmpPlayerSocket.put(player, entry.getValue());
				}
				
				if (this.players.size() >= 2) {
					this.gameState = new GameState(this.parser, this.players);
					this.controller = new Controller(this.gameState); 
					
					System.out.println(this.gameState.getCounsellorGarbage().toString());
					
					for (Map.Entry<ServerSocketView, Socket> entry : tmpViewSocket.entrySet()) {
						if (entry.getKey().isEnabled()) {
							entry.getKey().initServerSocketView(this.gameState);
							this.gameState.registerObserver(entry.getKey());
							entry.getKey().registerObserver(this.controller);	
						}
					}
					
					int k = 0;
					
					for (Player player : players) {
						player.initPlayer(this.gameState.getPoliticalDeck(), k, this.parser);
						k++;
					}
					System.out.println("Match running");
				}
				
			}
			
			Socket socket = serverSocket.accept();
			ServerSocketView view = new ServerSocketView(socket);
			executor.submit(view);
			System.out.println("iterate");
			tmpViewSocket.put(view, socket);
			System.out.println("NEW CLIENTSOCKET ACCEPTED");
			
			i++;
		}
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Server server = new Server();
		
		System.out.println("STARTING SOCKET");
		server.startSocket();
	}

}