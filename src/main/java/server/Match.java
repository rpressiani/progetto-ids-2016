package server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import controller.Controller;
import model.GameState;
import model.player.Player;
import parser.Parser;
import view.ServerSocketView;

public class Match {
	
	private static int serialIDGenerator = 0;
	private final int serialID;
	private GameState gameState; 
	private Controller controller;
	private Parser parser;
	
	public Match(ArrayList<Player> players, Map<Player, ServerSocketView> tmpViewSocket) throws IOException {
		this.parser = new Parser();
		this.gameState = new GameState(this.parser, players);
		this.controller = new Controller(this.gameState);
		
		this.serialID = serialIDGenerator;
		serialIDGenerator++;
		
		int k = 0;
		
		for (Map.Entry<Player, ServerSocketView> entry : tmpViewSocket.entrySet()) {
			if (entry.getValue().isEnabled()) {
				entry.getValue().getPlayer().initPlayer(this.gameState.getPoliticalDeck(), k, this.parser);
				k++;
				entry.getValue().initServerSocketView(this.gameState);
				this.gameState.registerObserver(entry.getValue());
				entry.getValue().registerObserver(this.controller);
			}
		}
		
		//notify a match started change
		
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
