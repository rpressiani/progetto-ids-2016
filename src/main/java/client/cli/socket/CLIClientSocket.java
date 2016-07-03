package client.cli.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CLIClientSocket {
	
	private final static int PORT = 29999;
	private final static String IP = "127.0.0.1";
	private Socket socket;
	
	private Scanner in;
	
	/**
	 * @param in
	 */
	public CLIClientSocket(Scanner in) {
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
	 * @throws IOException
	 * closes client socket
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
		CLIClientSocket client = new CLIClientSocket(in); 
		client.startClient();
		
	}
}
