package client.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientSocket {
	
	private final static int PORT = 29999; //file!
	private final static String IP = "127.0.0.1";
	private String nickname;
	private Socket socket;
	
	private Scanner in;
	
	public ClientSocket(Scanner in) {
		this.in = in;
	}
	
	public void startClient() throws UnknownHostException, IOException {
		this.socket = new Socket(IP, PORT); 
		System.out.println("[CLIENT] Connection Created");
		ExecutorService executor = Executors.newFixedThreadPool(2); //load from file
		executor.submit(new ClientOutHandlerSocket(new ObjectOutputStream(socket.getOutputStream()), in));
		executor.submit(new ClientInHandler(new ObjectInputStream(socket.getInputStream())));
	}
	
	public void closeClient() throws IOException{
		this.socket.close();
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Scanner in = new Scanner(System.in);
		ClientSocket client = new ClientSocket(in); 
		client.startClient();
		
	}
	
	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}
}
