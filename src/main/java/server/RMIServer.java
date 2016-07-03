package server;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import client.ClientMessage;
import client.cli.rmi.ClientViewRemote;
import dto.DTOObject;
import dto.actions.DTOAction;
import dto.queries.DTOQuery;
import dto.utilities.DTOSetup;
import model.player.Player;
import utilities.Color;
import view.rmi.RMIView;

public class RMIServer implements RMIServerInterface {

	private Map<ClientViewRemote, RMIView> clients;
	private Map<Player, RMIView> tmpViewRMI;
	private Server server;
	
	/**
	 * RMIServer constructor
	 * Creates the RMI section of the server
	 * 
	 * @param tmpViewRMI	players connected via RMI with their view
	 * @param server		server on which the RMIServer is created
	 */
	public RMIServer(Map<Player, RMIView> tmpViewRMI, Server server) {
		this.clients = new HashMap<ClientViewRemote, RMIView>();
		this.tmpViewRMI = tmpViewRMI;
		this.server = server;
	}
	
	/**
	 * @see server.RMIServerInterface#registerClient(client.cli.rmi.ClientViewRemote)
	 */
	@Override
	public void registerClient(ClientViewRemote clientStub) throws RemoteException{
		System.out.println("NEW CLIENT_RMI ACCEPTED");
		RMIView assignedRMIView = new RMIView(clientStub, this);
		this.clients.put(clientStub, assignedRMIView);
		this.tmpViewRMI.put(assignedRMIView.getPlayer(), assignedRMIView);
		StringBuilder initString = new StringBuilder();
		initString.append("\n[SERVER] RMIView is running\n");
		initString.append("[SERVER] Insert 'setup <nickname> <color>' to enable your player to join a match.\n");
		clientStub.print(initString.toString());
	}
	
	/**
	 * Disconnect a player from the server
	 * @param player
	 */
	public void disconnect(Player player){
		this.server.disconnectRMI(player);
	}
	
	/**
	 * @see server.RMIServerInterface#unregisterClient(client.cli.rmi.ClientViewRemote)
	 */
	@Override
	public void unregisterClient(ClientViewRemote clientStub) throws RemoteException {
		this.clients.remove(clientStub);
	}
	
	/**
	 * @see server.RMIServerInterface#receiveMessage(client.ClientMessage)
	 */
	@Override
	public void receiveMessage(ClientMessage msgIn) throws RemoteException {
		System.out.println("MSG received: " + msgIn.getMessage());
		System.out.println("MSG RMI RECEIVED");
		
		Player player = null;
		RMIView view = null;
		for (Entry<ClientViewRemote, RMIView> entry : this.clients.entrySet()) {
			if (entry.getKey().equals(msgIn.getClientRMI())) {
				player = entry.getValue().getPlayer();
				view = entry.getValue();
				break;
			}
		}
		
		if (view.getTimer().isActive()) view.resetTimer();
		
		System.out.println(player);
		
		System.out.println("MSG RMI RECEIVED 2");
		
//		if (player == null) throw new NullPointerException("[CRITICAL] Player not found");
		
		ClientMessage msgOut;
		
		if (!player.isEnabled()) {
			
			if (msgIn.getMessage() instanceof DTOSetup) {
				
				DTOSetup setup = (DTOSetup) msgIn.getMessage();
				
				player.setNickname(new String(setup.getNickname()));
				player.setColor(new Color(setup.getColor().getColorString()));
				player.setEnabled(true);
				
				StringBuilder playerEnabled = new StringBuilder();
				playerEnabled.append("\n[SERVER] Setup completed\n");
				playerEnabled.append("[SERVER] player.enabled == " + player.isEnabled() + "\n");
				playerEnabled.append("[SERVER] Waiting for a match to start...\n");
				msgIn.getClientRMI().print(playerEnabled.toString());
				System.out.println(player);
			}
				
		} else {
			
			if (msgIn.getMessage() instanceof DTOAction) {
				DTOAction action = (DTOAction) msgIn.getMessage();
				System.out.println("SERVER VIEW: received DTOAction " + action);
				
				msgOut = new ClientMessage(this.clients.get(msgIn.getClientRMI()).getPlayer(), action);
				System.out.println(msgOut);
				
//				this.notifyObserver(msgOut);
				System.out.println("1: "+ this.clients.get(msgIn.getClientRMI()));
				System.out.println("2: "+ this.clients.get(msgIn.getClientRMI()).getPlayer());
				this.clients.get(msgIn.getClientRMI()).notifyObserver(msgOut);
				System.out.println("CONTROLLER NOTIFIED!");
			
			}
			
			
//			if (msgIn.getMessage() instanceof DTOAction) {
//				DTOAction action = (DTOAction) msgIn.getMessage();
//				System.out.println("SERVER VIEW: received DTOAction " + action);
//				
//				msgOut = new ClientMessage(this.player, action);
//				
//				this.notifyObserver(msgOut);
//			}
			
			if (msgIn.getMessage() instanceof DTOQuery) {
				
				DTOQuery request = (DTOQuery) msgIn.getMessage();
				DTOObject respond = request.accept(this.clients.get(msgIn.getClientRMI()).getVisitorQueries());
				System.out.println("SERVER VIEW: received DTOQuery " + request);
				
//				msgOut = new ClientMessage(this.clients.get(msgIn.getClientRMI()).getPlayer(), message)
				msgIn.getClientRMI().print(respond.toString());
				
			}
		}
		
		
	}
}
