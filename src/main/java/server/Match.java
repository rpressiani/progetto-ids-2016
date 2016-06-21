package server;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Map;

import controller.Controller;
import model.GameState;
import model.changes.ChangeMsg;
import model.player.Player;
import parser.Parser;
import view.rmi.RMIView;
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
	public Match(ArrayList<Player> players, Map<Player,ServerSocketView> tmpViewSocket,
			Map<Player, RMIView> tmpViewRMI) throws IOException, AlreadyBoundException, NotBoundException {
		
		if(players==null || tmpViewSocket==null || tmpViewRMI==null){
			throw new NullPointerException("players or tmpViews can't be null");
		}
		
		this.parser = new Parser();
		this.gameState = new GameState(this.parser, players);
		this.controller = new Controller(this.gameState);
		
		this.serialID = serialIDGenerator;
		serialIDGenerator++;
		
		int k = 0;
		
		for (Player player : players) {
			if (tmpViewSocket.containsKey(player)) {
				ServerSocketView view = tmpViewSocket.get(player);
				view.getPlayer().initPlayer(this.gameState.getPoliticalDeck(), k, this.parser);
				k++;
				view.initServerSocketView(this.gameState);
				System.out.println(view.getPlayer());
				this.gameState.registerObserver(view.getPlayer(), view);
				view.registerObserver(this.controller);
			} else if (tmpViewRMI.containsKey(player)) {
				RMIView view = tmpViewRMI.get(player);
				view.getPlayer().initPlayer(this.gameState.getPoliticalDeck(), k, this.parser);
				k++;
				view.initServerSocketView(this.gameState);
				System.out.println(view.getPlayer());
				this.gameState.registerObserver(view.getPlayer(), view);
				view.registerObserver(this.controller);
				System.out.println("VIEW OBSERVERS: " + view.getObservers());
			}
		}
		
		System.out.println("GAMESTATE OBSERVERS: " + this.gameState.getObservers());
		
		this.gameState.notifyObserver(new ChangeMsg("[SERVER] New match started. The first player is " +
				this.gameState.getCurrentPlayer().getNickname() + ". Let's go!"));
		
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
