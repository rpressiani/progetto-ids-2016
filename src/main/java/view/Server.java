package view;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import controller.Controller;
import gameState.GameState;

public class Server {
	
	private final static int PORT = 1111; //load from file!
	private GameState gameState; 
	private Controller controller; 
	
	public Server() {
		this.gameState = new GameState(); 
		this.controller = new Controller(gameState); 
	}
	private void startSocket() throws IOException {
		ExecutorService executor = Executors.newCachedThreadPool(); 
		ServerSocket serverSocket = new ServerSocket(PORT); 
		
	}

}
