package view.rmi;

import java.io.IOException;
import java.rmi.RemoteException;

import client.cli.rmi.ClientViewRemote;
import dto.changes.DTOChange;
import dto.queries.VisitorQueries;
import model.GameState;
import model.changes.Change;
import model.player.Player;
import view.View;
import view.VisitorChanges;

public class RMIView extends View {

	private final Player player;
	private final ClientViewRemote client;
	private GameState game;
	private VisitorChanges visitorChanges;
	private VisitorQueries visitorQueries;
	private server.RMIServer server;
	private RMIViewTimer timer;
	
	
	/**
	 * Constructor of RMIView
	 * Creates an RMIView linked to a specific ClientViewRemote
	 * 
	 * @param client	ClientViewRemote of the player connected
	 * @param server	RMIServer on which the player is connected
	 */
	public RMIView(ClientViewRemote client, server.RMIServer server) {
		this.client = client;
		this.server = server;
		this.player = new Player();
		this.player.setView(this);
		this.visitorChanges = new VisitorChanges();
		this.timer = new RMIViewTimer(this.client, this.server, this.player);
		(new Thread(this.timer)).start();
	}

	/**
	 * @see view.View#resetTimer()
	 */
	@Override
	public void resetTimer() {
		try {
			this.timer.reset();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("new timer started");
	}
	
	/**
	 * @see view.View#startTimer()
	 */
	@Override
	public void startTimer(){
		try {
			this.timer.start();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @see view.View#stopTimer()
	 */
	@Override
	public void stopTimer(){
		try {
			this.timer.stop();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the client
	 */
	public ClientViewRemote getClient() {
		return client;
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * @return if the object is enabled
	 */
	public boolean isEnabled() {
		return this.player.isEnabled();
	}
	
	/**
	 * Once the match is started, the RMIView is linked with the GameState of that match
	 * 
	 * @param game
	 * @throws IOException
	 */
	public void initRMIView(GameState game) throws IOException{
		this.game = game;
		this.visitorQueries = new VisitorQueries(this.game, this.player);
	}

	/**
	 * @return the visitorQueries
	 */
	public VisitorQueries getVisitorQueries() {
		return visitorQueries;
	}
	
	
	/**
	 * communicate to the client the notify received
	 * @see view.View#update(model.changes.Change)
	 */
	public void update(Change change) {
		
		System.out.println("Sending to the client " + change);
		
		try {
			DTOChange dtoChange = change.accept(this.visitorChanges);
			this.client.print(dtoChange.toString());
			System.out.println("DTOChange sent");
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the timer
	 */
	public RMIViewTimer getTimer() {
		return timer;
	}

	@Override
	public void disconnect() {
		this.server.disconnect(this.player);
		
	}
}
