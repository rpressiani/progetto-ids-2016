package view;

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

public class Server {
	
	private final static int PORT = 1111; //load from file!
	private GameState gameState; 
	private Controller controller;
	private Parser parser;
	
	//players and GameState presence in Server need to be verified!! 
	private ArrayList<Player> players;
	
	public Server() {
		this.parser = new Parser();
		this.players = new ArrayList<Player>();
		this.gameState = new GameState(parser, players); 
		this.controller = new Controller(gameState); 
	}
	private void startSocket() throws IOException {
		ExecutorService executor = Executors.newCachedThreadPool(); 
		ServerSocket serverSocket = new ServerSocket(PORT); 
		System.out.println("Server ready on Port "+PORT);
		while(true) {
			Socket socket = serverSocket.accept(); 
			ServerSocketView view = new ServerSocketView(socket); 
			this.gameState.registerObserver(view);
			view.registerObserver(this.controller);
			executor.submit(view); 
		}
	}
	public static void main(String[] args) throws IOException {
		Server server = new Server(); 
		server.startSocket();
	}

}
