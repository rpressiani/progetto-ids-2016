package client;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

import client.socket.ClientSocket;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Scanner in = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("[CLIENT] Welcome to Council of Four! Set your preferences before starting a new match.");
			System.out.println("[CLIENT] Connection: type 1 for SOCKET, 2 for RMI\n");
			String connection;
			while (true) {
				 connection = new String(in.nextLine());
				 if (connection.equals("1") || connection.equals("2")) break;
				 System.out.println("\n[CLIENT] Input not valid");
				 System.out.println("[CLIENT] Connection: type 1 for SOCKET, 2 for RMI\n");
			}
			
			System.out.println("\n[CLIENT] View: type 1 for CLI, 2 for GUI\n");
			String view;
			while (true) {
				 view = new String(in.nextLine());
				 if (view.equals("1") || view.equals("2")) break;
				 System.out.println("\n[CLIENT] Input not valid");
				 System.out.println("[CLIENT] View: type 1 for CLI, 2 for GUI\n");
			}
			
			
			if (connection.equals("1")) {
				if (view.equals("1")) {
					System.out.println("\n[CLIENT] Starting new SOCKET CLI");
					ClientSocket socketCLI = new ClientSocket();
					socketCLI.startClient();
					break;
				} else {
					System.out.println("\n[CLIENT] SOCKET GUI still need to be implemented\n\n\n");
				}
			} else {
				if (view.equals("1")) {
					System.out.println("\n[CLIENT] RMI CLI still need to be implemented\n\n\n");
				} else {
					System.out.println("\n[CLIENT] RMI GUI still need to be implemented\n\n\n");
				}
			}
			
		}

		in.close();
	}

}