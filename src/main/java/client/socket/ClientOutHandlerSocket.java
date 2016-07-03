package client.socket;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import client.CLIClientOutHandler;

public class ClientOutHandlerSocket extends CLIClientOutHandler {
	
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

	@Override
	public void notifyCmdNotFound() {
		StringBuilder cmdNotFound = new StringBuilder();
		cmdNotFound.append("\n[ERROR] Command not found!\n");
		cmdNotFound.append("[ERROR] Insert legal commands\n");
		cmdNotFound.append("[ERROR] Enter help for command list\n");
		
		System.out.println(cmdNotFound.toString());
		
	}

}
