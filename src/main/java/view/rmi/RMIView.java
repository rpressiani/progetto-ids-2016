package view.rmi;

import java.io.IOException;

import client.rmi.ClientViewRemote;
import dto.changes.DTOChange;
import dto.queries.VisitorQueries;
import model.GameState;
import model.changes.Change;
import model.player.Player;
import view.View;
import view.VisitorChanges;

public class RMIView extends View {

//	private Map<Player, ClientViewRemote> clients;
	private final Player player;
	private final ClientViewRemote client;
	private GameState game;
	private VisitorChanges visitorChanges;
	private VisitorQueries visitorQueries;
	
//	public RMIView(Map<Player, ClientViewRemote> clients) {
//		this.clients = clients;
//	}
	
	public RMIView(ClientViewRemote client) {
//		this.clients = new HashMap<Player, ClientViewRemote>();
		this.client = client;
		this.player = new Player();
		this.visitorChanges = new VisitorChanges();
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
	
	public void initServerSocketView(GameState game) throws IOException{
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
}
