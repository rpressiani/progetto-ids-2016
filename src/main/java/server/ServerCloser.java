package server;

import java.io.IOException;
import java.util.Scanner;

public class ServerCloser implements Runnable {
	
	private Server server;
	
	public ServerCloser(Server server) {
		this.server = server;
	}

	@Override
	public void run() {
		Scanner in = new Scanner(System.in);
		while (true) {
			if (in.nextLine().equals("quit") && Server.getRunningMatches().size()==0){
				in.close();
				try {
					this.server.closeServer();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
