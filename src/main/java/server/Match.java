package server;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.HashMap;
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
	
	private Map<Player, RMIView> playersRMI = new HashMap<Player, RMIView>();
	private Map<Player, ServerSocketView> playersSocket = new HashMap<Player, ServerSocketView>();
	

	/**
	 * Constructor of the Match
	 * Creates a new match based on a list of players that will join it.
	 * 
	 * @param players					players that will join the match
	 * @param tmpViewSocket				map of players connected via socket with their ServerSocketView
	 * @param tmpViewRMI				map of players connected via RMI with their RMIView
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
		this.gameState.checkNotOnePlayer();
		this.controller = new Controller(this.gameState);
		
		this.serialID = serialIDGenerator;
		serialIDGenerator++;
		
		int k = 0;
		
		for (Player player : players) {
			if (tmpViewSocket.containsKey(player)) {
				ServerSocketView view = tmpViewSocket.get(player);
				playersSocket.put(player, view);
				view.getPlayer().initPlayer(this.gameState.getPoliticalDeck(), k, this.parser);
				k++;
				view.initServerSocketView(this.gameState);
				System.out.println(view.getPlayer());
				this.gameState.registerObserver(view.getPlayer(), view);
				view.registerObserver(this.controller);
			} else if (tmpViewRMI.containsKey(player)) {
				RMIView view = tmpViewRMI.get(player);
				playersRMI.put(player, view);
				view.getPlayer().initPlayer(this.gameState.getPoliticalDeck(), k, this.parser);
				k++;
				view.initRMIView(this.gameState);
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

	/**
	 * @return the playersRMI map
	 */
	public Map<Player, RMIView> getPlayersRMI() {
		return playersRMI;
	}

	/**
	 * @return the playersSocket map
	 */
	public Map<Player, ServerSocketView> getPlayersSocket() {
		return playersSocket;
	}

	/**
	 * @return the gameState
	 */
	public GameState getGameState() {
		return gameState;
	}

	/**
	 * @return the controller
	 */
	public Controller getController() {
		return controller;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + serialID;
		return result;
	}

	/**
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
