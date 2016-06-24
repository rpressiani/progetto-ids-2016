package view.rmi;

import java.rmi.RemoteException;
import java.util.TimerTask;

import client.rmi.ClientViewRemote;
import model.GameState;
import model.player.Player;

public class RMIDisconnect extends TimerTask {
	
	private final ClientViewRemote client;
//	private final GameState game;
	private server.RMIServer server;
	private Player player;
	
	public RMIDisconnect(ClientViewRemote client, GameState game, server.RMIServer server, Player player) throws RemoteException {
		this.client = client;
//		this.game = game;
		this.server = server;
		this.player = player;
	}

	@Override
	public void run() {
		try {
			client.print("[SERVER] Client timeout! You've been disconnected.\n");
			this.server.disconnect(player);
			this.server.unregisterClient(this.client);
		} catch (RemoteException e) {
			try {
				this.server.disconnect(player);
				this.server.unregisterClient(this.client);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("ciao2");
		}

	}

}
