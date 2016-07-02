package view.socket;

import java.util.Timer;

import model.player.Player;
import server.Server;

public class SocketViewTimer implements Runnable {
	
	private ServerSocketView client;
	private Timer timer1;
	private Timer timer2;
	private Server server;
	private Player player;
	private boolean active = false;
	
	
	public SocketViewTimer(ServerSocketView client, Server server, Player player) {
		this.client = client;
		this.timer1 = new Timer();
		this.timer2 = new Timer();
		this.server = server; 
		this.player = player;
	}

	@Override
	public void run() {

	}
	
	public void reset(){
		this.timer1.cancel();
		this.timer2.cancel();
		this.timer1 = new Timer();
		this.timer2 = new Timer();
		this.timer1.schedule(new SocketTimerAdvice(this.client), 10*1000);
		this.timer2.schedule(new SocketTimerDisconnect(this.client, this.server, this.player), 20*1000);
		System.out.println("Timer reset");
	}
	
	public void stop(){
		this.timer1.cancel();
		this.timer2.cancel();
		this.active = false;
		System.out.println("Timer stop");
	}
	
	public void start(){
		this.timer1 = new Timer();
		this.timer2 = new Timer();
		this.timer1.schedule(new SocketTimerAdvice(this.client), 10*1000);
		this.timer2.schedule(new SocketTimerDisconnect(this.client, this.server, this.player), 20*1000);
		this.active = true;
		System.out.println("Timer start");
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}
	
	

}
