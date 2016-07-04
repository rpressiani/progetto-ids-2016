package view.socket;

import java.util.TimerTask;

import model.changes.ChangeMsg;
import model.player.Player;
import server.Server;

public class SocketTimerDisconnect extends TimerTask {
	
	private ServerSocketView client;
	private Server server;
	private Player player;
	
	public SocketTimerDisconnect(ServerSocketView client, Server server, Player player) {
		this.client = client;
		this.server = server;
		this.player = player;
	}

	@Override
	public void run() {
		this.client.update(new ChangeMsg("[SERVER] Client timeout! You've been disconnected.\n"));
		this.player.getView().stopTimer();
		this.server.disconnectSocket(this.player);
	}

}
