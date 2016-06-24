package gui.client;

import java.net.Socket;

import gui.ChooseConnectionController;
import gui.LoginClientController;

public class GUIClientSocket extends GUIClient {
	private static String PORT; 
	private final static String IP = "127.0.0.1";
	private String nickname;
	private Socket socket;
	
	private LoginClientController loginController; 
	private ChooseConnectionController connectionController; 
	
	public GUIClientSocket(int PORT, String IP, String nickname, Socket socket) {
		GUIClientSocket.PORT = connectionController.getPort(); 
		this.nickname = loginController.getNickname(); 
		this.socket = socket; 
	}
	//TODO: fix the scanner thing
	public void startClient() {
		
	}
	public static void main(String[] args) {
		
	}
	
	public String getNickname() {
		return nickname; 
	}
	public String getPort() {
		return PORT; 
	}
	public String getIP() {
		return IP; 
	}
	public Socket getSocket() {
		return socket; 
	}
	
}
