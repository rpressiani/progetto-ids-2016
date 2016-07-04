package client.gui;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import gui.LoginClientController;
import gui.MainApp;
import javafx.application.Application;

public class GUIClientSocket {
	private final static int PORT = 29999;
	private static String IP;
	private Socket socket;
	
	private LoginClientController loginController; 
	
	private GUIClientOutHandlerSocket outHandler;
	
	public GUIClientSocket(String IP) {
		GUIClientSocket.IP = IP;
	}
	
	/**
	 * starts client
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public void startClient() throws UnknownHostException, IOException {
		this.socket = new Socket(IP, PORT);
		this.outHandler = new GUIClientOutHandlerSocket(new ObjectOutputStream(socket.getOutputStream()));
		System.out.println("[CLIENT] Connection Created");
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.submit(new GUIClientInHandlerSocket(new ObjectInputStream(socket.getInputStream())));
		String[] args = null;
		MainApp.print("Starting GUI");
		MainApp.setOutHandler(this.outHandler);
		Application.launch(MainApp.class, args);
		
	}
	
	/**
	 * @return the ClientOutHandler
	 */
	public GUIClientOutHandlerSocket getOutHandler() {
		return outHandler;
	}

	/**
	 * closes client socket
	 * @throws IOException
	 */
	public void closeClient() throws IOException{
		this.socket.close();
	}
	
	/**
	 * @param args
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		String localhost = "127.0.0.1";
		GUIClientSocket client = new GUIClientSocket(localhost); 
		client.startClient();
		
	}
	
}
