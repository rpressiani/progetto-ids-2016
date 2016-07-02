package view.rmi;

import java.rmi.RemoteException;
import java.util.TimerTask;

import client.rmi.ClientViewRemote;
import model.player.Player;

public class RMITimerAdvice extends TimerTask {
	
	private final ClientViewRemote client;
	private server.RMIServer server;
	private Player player;
	
	public RMITimerAdvice(ClientViewRemote client, server.RMIServer server, Player player) throws RemoteException {
		this.server = server;
		this.client = client;
		this.player = player;
	}

	@Override
	public void run() {
		StringBuilder msg = new StringBuilder();
		msg.append("[SERVER] You've been inactive for a while!\n");
		msg.append("[SERVER] Do something if you doesn't want to be disconnected.\n");
		try {
			this.client.print(msg.toString());
		} catch (RemoteException e) {
			System.out.println("ciao");
			try {
				this.server.disconnect(player);
				this.server.unregisterClient(this.client);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}

	}

}
