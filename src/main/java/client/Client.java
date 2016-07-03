package client;

import java.io.IOException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.util.Scanner;

import client.cli.rmi.CLIClientRMI;
import client.cli.socket.CLIClientSocket;
import client.gui.GUIClientSocket;

public class Client {

	/**
	 * @param args
	 * @throws UnknownHostException
	 * @throws IOException
	 * @throws NotBoundException
	 */
	public static void main(String[] args) throws UnknownHostException, IOException, NotBoundException {
		Scanner in = new Scanner(System.in);
		
			
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
					CLIClientSocket socketCLI = new CLIClientSocket(in);
					socketCLI.startClient();
				} else {
					System.out.println("\n[CLIENT] Starting new SOCKET GUI");
					GUIClientSocket socketCLI = new GUIClientSocket();
					socketCLI.startClient();
				}
			} else {
				if (view.equals("1")) {
					System.out.println("\n[CLIENT] Starting new RMI CLI");
					CLIClientRMI clientRMI = new CLIClientRMI(in);
					clientRMI.startClient();
				} else {
					System.out.println("\n[CLIENT] RMI GUI still need to be implemented\n\n\n");
				}
			}
	
	}

}
