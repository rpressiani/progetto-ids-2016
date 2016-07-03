package client.socket;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import client.ClientOutHandler;

public class ClientOutHandlerSocket extends ClientOutHandler {
	
	private ObjectOutputStream socketOut; 
	
	/**
	 * @param socketOut
	 * @param in
	 */
	public ClientOutHandlerSocket(ObjectOutputStream socketOut, Scanner in) {
		super(in);
		if(socketOut==null) {
			throw new IllegalArgumentException("socketOut cannot be null"); 
		}
		this.socketOut = socketOut; 
	}

	@Override
	public void sendMsg(ClientMessage msg) {
		try {
			this.socketOut.writeObject(msg);
			this.socketOut.flush();
		} catch (IOException e) {
			System.out.println("SERVER IS DOWN");
		}
	}

}
