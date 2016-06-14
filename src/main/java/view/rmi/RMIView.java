package view.rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import client.rmi.ClientViewRemote;
import client.socket.ClientMessage;
import dto.actions.DTOAction;
import dto.queries.DTOQuery;
import dto.utilities.DTOSetup;
import model.changes.Change;
import model.player.Player;
import utilities.Color;
import view.View;

public class RMIView extends View implements RMIViewRemote, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6855000797347157450L;
//	private Set<ClientViewRemote> clients;
	private Map<Player, ClientViewRemote> clients;
	
	public RMIView(Map<Player, ClientViewRemote> clients) {
		this.clients = clients;
	}
	
	public RMIView() {
		this.clients = new HashMap<Player, ClientViewRemote>();
	}
	
	@Override
	public void registerClient(ClientViewRemote clientStub) throws RemoteException {
		System.out.println("NEW CLIENT_RMI ACCEPTED");
		this.clients.put(new Player(), clientStub);
	}
	
	@Override
	public void registerClient(Player player, ClientViewRemote clientStub) throws RemoteException {
		this.clients.put(player, clientStub);
	}
	
	@Override
	public void unregisterClient(Player player) throws RemoteException {
		this.clients.remove(player);
	};
	
	@Override
	public void update(Change o) {
		System.out.println("SENDING THE CHANGE TO THE CLIENT");
		try {
			for (Entry<Player, ClientViewRemote> entry : clients.entrySet()) {
				
				entry.getValue().updateClient(o);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void receiveMessage(ClientMessage msgIn) throws RemoteException {
		
		System.out.println("MSG RMI RECEIVED");
		
		Player player = null;
		for (Entry<Player, ClientViewRemote> entry : this.clients.entrySet()) {
			if (entry.getValue().equals(msgIn.getClientRMI())) {
				player = entry.getKey();
				break;
			}
		}
		
		System.out.println("MSG RMI RECEIVED 2");
		
//		if (player == null) throw new NullPointerException("[CRITICAL] Player not found");
		
		ClientMessage msgOut;
		
		if (msgIn.getMessage() instanceof DTOSetup) {
			System.out.println("MSG RMI RECEIVED 3");
			
			DTOSetup setup = (DTOSetup) msgIn.getMessage();
			
			if (!player.isEnabled()) {
				player.setNickname(new String(setup.getNickname()));
				player.setColor(new Color(setup.getColor().getColorString()));
				player.setEnabled(true);
				
				StringBuilder playerEnabled = new StringBuilder();
				playerEnabled.append("\n[SERVER] Setup completed\n");
				playerEnabled.append("[SERVER] player.enabled == " + player.isEnabled() + "\n");
				playerEnabled.append("[SERVER] Waiting for a match to start...\n");
			}
		}
		
		System.out.println("prova");
		
		if (msgIn.getMessage() instanceof DTOAction) {
			DTOAction action = (DTOAction) msgIn.getMessage();
			System.out.println("SERVER VIEW: received DTOAction " + action);
			
			msgOut = new ClientMessage(player, action);
			System.out.println("RMIVIEW: " + this);
			this.notifyObserver(msgOut);
			System.out.println("Notify sent");
		}
		
//		if (msgIn.getMessage() instanceof DTOQuery) {
			
//			DTOQuery request = (DTOQuery) msgIn.getMessage();
//			DTOObject respond = request.accept(this.visitorQueries);
//			System.out.println("SERVER VIEW: received DTOQuery " + request);
			
			//SEND RESPONSE BACK

//		}
		
//		System.out.println(msg.getMessage());
		
	}

	/**
	 * @return the clients
	 */
	public Map<Player, ClientViewRemote> getClients() {
		return clients;
	}


}
