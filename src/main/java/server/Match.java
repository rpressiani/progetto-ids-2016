package server;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Map;

import client.rmi.ClientViewRemote;
import controller.Controller;
import model.GameState;
import model.changes.ChangeMsg;
import model.player.Player;
import parser.Parser;
import view.rmi.RMIView;
import view.rmi.RMIViewRemote;
import view.socket.ServerSocketView;

public class Match {
	
	private static int serialIDGenerator = 0;
	private final int serialID;
	private GameState gameState; 
	private Controller controller;
	private Parser parser;
	
	/**
	 * 
	 * @param players
	 * @param tmpViewSocket
	 * @throws IOException
	 * @throws AlreadyBoundException 
	 * @throws NotBoundException 
	 */
	public Match(ArrayList<Player> players, Map<Player, ServerSocketView> tmpViewSocket,
			Map<Player, ClientViewRemote> tmpViewRMI) throws IOException, AlreadyBoundException, NotBoundException {
		
		if(players==null || tmpViewSocket==null || tmpViewRMI==null){
			throw new NullPointerException("players or tmpViews can't be null");
		}
		
		this.parser = new Parser();
		this.gameState = new GameState(this.parser, players);
		this.controller = new Controller(this.gameState);
		
		this.serialID = serialIDGenerator;
		serialIDGenerator++;
		
		int k = 0;
		
		for (Map.Entry<Player, ServerSocketView> entry : tmpViewSocket.entrySet()) {
			ServerSocketView view = entry.getValue();
			if (view.isEnabled()) {
				view.getPlayer().initPlayer(this.gameState.getPoliticalDeck(), k, this.parser);
				k++;
				view.initServerSocketView(this.gameState);
				System.out.println(view.getPlayer());
				this.gameState.registerObserver(view.getPlayer(), view);
				view.registerObserver(this.controller);
			}
		}
		
		RMIView rmiViewMatch = new RMIView();
		RMIViewRemote viewRemote=(RMIViewRemote) UnicastRemoteObject.exportObject(rmiViewMatch, 0);
//		registry.bind("match1", rmiViewMatch);
		for (Map.Entry<Player, ClientViewRemote> entry : tmpViewRMI.entrySet()) {
			rmiViewMatch.registerClient(entry.getKey(), entry.getValue());
//			RMIViewRemote view = (RMIViewRemote) entry.getValue();
//			view = (RMIViewRemote) registry.lookup("match1");
			
		}
		
		this.gameState.registerObserver(rmiViewMatch);
		rmiViewMatch.registerObserver(this.controller);
		System.out.println(rmiViewMatch.getObservers());
		
		System.out.println("clients rmiviewMatch: " + rmiViewMatch.getClients());
		
//		this.gameState.notifyObserver(new ChangeMsg("[SERVER] New match started. The first player is " + this.gameState.getCurrentPlayer().getNickname() + ". Let's go!"));
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + serialID;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Match other = (Match) obj;
		if (serialID != other.serialID)
			return false;
		return true;
	}

}
