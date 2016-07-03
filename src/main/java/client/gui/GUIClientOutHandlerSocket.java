package client.gui;

import java.io.IOException;
import java.io.ObjectOutputStream;

import client.ClientMessage;
import client.ClientOutHandler;

public class GUIClientOutHandlerSocket extends ClientOutHandler {
	
private ObjectOutputStream socketOut; 
	
	/**
	 * @param socketOut
	 * @param in
	 */
	public GUIClientOutHandlerSocket(ObjectOutputStream socketOut) {
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
		// TODO Auto-generated method stub

	}

	@Override
	public void sellCommand() {
		// TODO Auto-generated method stub

	}

}
