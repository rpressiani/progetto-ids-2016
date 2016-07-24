package view.rmi;

import java.rmi.RemoteException;
import java.util.Timer;

import client.cli.rmi.ClientViewRemote;
import model.player.Player;

public class RMIViewTimer implements Runnable {
	
	private ClientViewRemote client;
	private Timer timer;
	private server.RMIServer server;
	private Player player;
	private boolean active = false;
	
	public RMIViewTimer(ClientViewRemote client, server.RMIServer server, Player player) {
		this.player = player;
		this.server = server;
		this.client = client;
		this.timer = new Timer();
	}

	@Override
	public void run() {
		
	}
	
	public void reset() throws RemoteException{
		this.timer.cancel();
		this.timer = new Timer();
		this.timer.schedule(new RMIDisconnect(this.client, this.server, this.player), (long)1000*1000);
		System.out.println("Timer reset");
	}
	
	public void stop() throws RemoteException{
		this.timer.cancel();
		this.active = false;
		System.out.println("Timer stop");
	}
	
	public void start() throws RemoteException{
		this.timer = new Timer();
		this.timer.schedule(new RMIDisconnect(this.client, this.server, this.player), (long)1000*1000);
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
