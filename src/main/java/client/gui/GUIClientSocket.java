package client.gui;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import client.cli.socket.CLIClientOutHandlerSocket;
import client.cli.socket.ClientInHandler;
import gui.ChooseConnectionController;
import gui.LoginClientController;

public class GUIClientSocket {
	private final static int PORT = 29999;
	private final static String IP = "127.0.0.1";
	private Socket socket;
	
	private LoginClientController loginController; 
	private ChooseConnectionController connectionController;
	
	private Scanner in;
	
	public GUIClientSocket(Scanner in) {
		this.in = in;
	}
	
	/**
	 * starts client
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public void startClient() throws UnknownHostException, IOException {
		this.socket = new Socket(IP, PORT); 
		System.out.println("[CLIENT] Connection Created");
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.submit(new CLIClientOutHandlerSocket(new ObjectOutputStream(socket.getOutputStream()), in));
		executor.submit(new ClientInHandler(new ObjectInputStream(socket.getInputStream())));
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
		Scanner in = new Scanner(System.in);
		GUIClientSocket client = new GUIClientSocket(in); 
		client.startClient();
		
	}
	
}
