package view.rmi;

import java.rmi.RemoteException;
import java.util.Timer;

import client.cli.rmi.ClientViewRemote;
import model.player.Player;

public class RMIViewTimer implements Runnable {
	
	private ClientViewRemote client;
	private Timer timer1;
	private Timer timer2;
	private server.RMIServer server;
	private Player player;
	private boolean active = false;
	
	public RMIViewTimer(ClientViewRemote client, server.RMIServer server, Player player) {
		this.player = player;
		this.server = server;
		this.client = client;
		this.timer1 = new Timer();
		this.timer2 = new Timer();
	}

	@Override
	public void run() {
		
	}
	
	public void reset() throws RemoteException{
		this.timer1.cancel();
		this.timer2.cancel();
		this.timer1 = new Timer();
		this.timer2 = new Timer();
		this.timer1.schedule(new RMITimerAdvice(this.client, this.server, this.player), 10*1000);
		this.timer2.schedule(new RMIDisconnect(this.client, this.server, this.player), 20*1000);
		System.out.println("Timer reset");
	}
	
	public void stop() throws RemoteException{
		this.timer1.cancel();
		this.timer2.cancel();
		this.active = false;
		System.out.println("Timer stop");
	}
	
	public void start() throws RemoteException{
		this.timer1 = new Timer();
		this.timer2 = new Timer();
		this.timer1.schedule(new RMITimerAdvice(this.client, this.server, this.player), 10*1000);
		this.timer2.schedule(new RMIDisconnect(this.client, this.server, this.player), 20*1000);
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
