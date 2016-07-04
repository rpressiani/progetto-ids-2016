package view.socket;

import java.util.Timer;

import model.player.Player;
import server.Server;

public class SocketViewTimer implements Runnable {
	
	private ServerSocketView client;
	private Timer timer;
	private Server server;
	private Player player;
	private boolean active = false;
	
	
	/**
	 * Constructor of SocketViewTimer
	 * Creates timers for players connected via socket
	 * 
	 * @param client	player's ServerSocketView
	 * @param server	server on which the match is running, in order to disconnect the player if it is necessary
	 * @param player	one of the player in the match
	 */
	public SocketViewTimer(ServerSocketView client, Server server, Player player) {
		this.client = client;
		this.timer = new Timer();
		this.server = server; 
		this.player = player;
	}

	/**
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {

	}
	
	/**
	 * Stops timers and creates two new ones.
	 */
	public void reset(){
		this.timer.cancel();
		this.timer = new Timer();
		this.timer.schedule(new SocketTimerDisconnect(this.client, this.server, this.player), (long)20*1000);
		System.out.println("Timer reset");
	}
	
	/**
	 * Stops timers and set active false
	 */
	public void stop(){
		this.timer.cancel();
		this.active = false;
		System.out.println("Timer stop");
	}
	
	/**
	 * Creates two new timers and set active true
	 */
	public void start(){
		this.timer = new Timer();
		this.timer.schedule(new SocketTimerDisconnect(this.client, this.server, this.player), (long)20*1000);
		this.active = true;
		System.out.println("Timer start");
	}

	/**
	 * @return if timers are active or not
	 */
	public boolean isActive() {
		return active;
	}

}
