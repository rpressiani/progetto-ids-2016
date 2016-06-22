package view.rmi;

import java.rmi.RemoteException;
import java.util.Timer;

import client.rmi.ClientViewRemote;
import model.GameState;
import model.player.Player;

public class RMIViewTimer implements Runnable {
	
	private ClientViewRemote client;
	private Timer timer1;
	private Timer timer2;
	private GameState game;
	private server.RMIServer server;
	private Player player;
	
	public RMIViewTimer(ClientViewRemote client, GameState game, server.RMIServer server, Player player) {
		this.player = player;
		this.server = server;
		this.client = client;
		this.game = game;
		this.timer1 = new Timer();
		this.timer2 = new Timer();
	}

	@Override
	public void run() {
		try {
			System.out.println("Timer started");
			this.timer1.schedule(new RMITimerAdvice(this.client, this.server, this.player), 10*1000);
			this.timer2.schedule(new RMIDisconnect(this.client, this.game, this.server, this.player), 20*1000);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void reset() throws RemoteException{
		this.timer1.cancel();
		this.timer2.cancel();
		this.timer1 = new Timer();
		this.timer2 = new Timer();
		this.timer1.schedule(new RMITimerAdvice(this.client, this.server, this.player), 10*1000);
		this.timer2.schedule(new RMIDisconnect(this.client, this.game, this.server, this.player), 20*1000);
		System.out.println("Timer reset");
	}


}
