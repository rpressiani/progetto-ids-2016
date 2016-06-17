package view.rmi;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import client.rmi.ClientViewRemote;
import client.socket.ClientMessage;
import dto.actions.DTOAction;
import dto.changes.DTOChange;
import dto.queries.DTOQuery;
import dto.queries.VisitorQueries;
import dto.utilities.DTOSetup;
import model.GameState;
import model.changes.Change;
import model.player.Player;
import utilities.Color;
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
	
//	public void registerClient(ClientViewRemote clientStub) throws RemoteException {
//		System.out.println("NEW CLIENT_RMI ACCEPTED");
//		this.clients.put(new Player(), clientStub);
//	}
//	
//
//	public void registerClient(Player player, ClientViewRemote clientStub) throws RemoteException {
//		this.clients.put(player, clientStub);
//	}
//	
//	
//	public void unregisterClient(Player player) throws RemoteException {
//		this.clients.remove(player);
//	}
//	
//	@Override
//	public void update(Change o) {
//		System.out.println("SENDING THE CHANGE TO THE CLIENT");
//		try {
//			for (Entry<Player, ClientViewRemote> entry : clients.entrySet()) {
//				
//				entry.getValue().updateClient(o);
//			}
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//
//	public void receiveMessage(ClientMessage msgIn) throws RemoteException {
//		
//		System.out.println("MSG RMI RECEIVED");
//		
//		Player player = null;
//		for (Entry<Player, ClientViewRemote> entry : this.clients.entrySet()) {
//			if (entry.getValue().equals(msgIn.getClientRMI())) {
//				player = entry.getKey();
//				break;
//			}
//		}
//		
//		System.out.println("MSG RMI RECEIVED 2");
//		
////		if (player == null) throw new NullPointerException("[CRITICAL] Player not found");
//		
//		ClientMessage msgOut;
//		
//		if (msgIn.getMessage() instanceof DTOSetup) {
//			System.out.println("MSG RMI RECEIVED 3");
//			
//			DTOSetup setup = (DTOSetup) msgIn.getMessage();
//			
//			if (!player.isEnabled()) {
//				player.setNickname(new String(setup.getNickname()));
//				player.setColor(new Color(setup.getColor().getColorString()));
//				player.setEnabled(true);
//				
//				StringBuilder playerEnabled = new StringBuilder();
//				playerEnabled.append("\n[SERVER] Setup completed\n");
//				playerEnabled.append("[SERVER] player.enabled == " + player.isEnabled() + "\n");
//				playerEnabled.append("[SERVER] Waiting for a match to start...\n");
//			}
//		}
//		
//		System.out.println("prova");
//		
//		if (msgIn.getMessage() instanceof DTOAction) {
//			DTOAction action = (DTOAction) msgIn.getMessage();
//			System.out.println("SERVER VIEW: received DTOAction " + action);
//			
//			msgOut = new ClientMessage(player, action);
//			System.out.println("RMIVIEW: " + this);
//			this.notifyObserver(msgOut);
//			System.out.println("Notify sent");
//		}
//		
////		if (msgIn.getMessage() instanceof DTOQuery) {
//			
////			DTOQuery request = (DTOQuery) msgIn.getMessage();
////			DTOObject respond = request.accept(this.visitorQueries);
////			System.out.println("SERVER VIEW: received DTOQuery " + request);
//			
//			//SEND RESPONSE BACK
//
////		}
//		
////		System.out.println(msg.getMessage());
//		
//	}
//
//	/**
//	 * @return the clients
//	 */
//	public Map<Player, ClientViewRemote> getClients() {
//		return clients;
//	}


}
