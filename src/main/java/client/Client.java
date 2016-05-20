package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	private final static int PORT = 1111; //file!
	private final static String IP = "127.0.0.1"; 
	
	public void startClient() throws UnknownHostException, IOException {
		Socket socket = new Socket(IP, PORT); 
		System.out.println("Connection Created");
		//to be implemented
	}

}
