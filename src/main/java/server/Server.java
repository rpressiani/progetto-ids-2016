package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import controller.Controller;
import model.GameState;
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
		this.players.add(new Player("player1", new Color("RED")));
		this.players.add(new Player("player2", new Color("GREEN")));
		this.players.add(new Player("player3", new Color("YELLOW")));
		this.players.add(new Player("player4", new Color("BLUE")));
		
		this.gameState = new GameState(parser, players); 
		this.controller = new Controller(gameState); 
	}
	private void startSocket() throws IOException {
		ExecutorService executor = Executors.newCachedThreadPool(); 
		ServerSocket serverSocket = new ServerSocket(PORT); 
		System.out.println("SERVER SOCKET READY ON PORT: " + PORT);
		while(true) {
			Socket socket = serverSocket.accept();
			System.out.println("NEW CLIENTSOCKET ACCEPTED");
			ServerSocketView view = new ServerSocketView(socket, this.gameState); 
			this.gameState.registerObserver(view);
			view.registerObserver(this.controller);
			executor.submit(view);
		}
	}
	public static void main(String[] args) throws IOException {
		Server server = new Server();
		
		System.out.println("STARTING SOCKET");
		server.startSocket();
	}

}
