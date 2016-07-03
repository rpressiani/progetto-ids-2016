package client.gui;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import client.cli.socket.ClientInHandler;
import gui.ChooseConnectionController;
import gui.LoginClientController;

public class GUIClientSocket {
	private final static int PORT = 29999;
	private final static String IP = "127.0.0.1";
	private Socket socket;
	
	private LoginClientController loginController; 
	private ChooseConnectionController connectionController;
	
	private GUIClientOutHandlerSocket outHandler;
	
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
		executor.submit(new ClientInHandler(new ObjectInputStream(socket.getInputStream())));
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
		GUIClientSocket client = new GUIClientSocket(); 
		client.startClient();
		
	}
	
}
