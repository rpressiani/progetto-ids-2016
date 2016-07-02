package view.socket;

import java.util.TimerTask;

import model.changes.ChangeMsg;

public class SocketTimerAdvice extends TimerTask {
	
	private ServerSocketView client;
	
	public SocketTimerAdvice(ServerSocketView client) {
		this.client = client;
	}

	@Override
	public void run() {
		StringBuilder msg = new StringBuilder();
		msg.append("[SERVER] You've been inactive for a while!\n");
		msg.append("[SERVER] Do something if you doesn't want to be disconnected.\n");
		this.client.update(new ChangeMsg(msg.toString()));

	}

}
