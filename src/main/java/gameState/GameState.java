package gameState;

import java.util.ArrayList;
import java.util.Set;

import council.Balcony;
import council.CounsellorGroup;
import council.GarbageState;
import map.Map;
import map.Region;
import player.Player;
import politicalDeck.PoliticalGarbage;
import politicalDeck.PoliticalRealDeck;
import sharedObjects.KingBonuses;
import sharedObjects.Nobility;

public class GameState {
	private Map map;
	private Set<Region> regions;
	private Nobility nobility;
	private PoliticalRealDeck politicalDeck;
	private PoliticalGarbage garbage;
	private Balcony balcony;
	private CounsellorGroup counsellorGroup;
	private GarbageState counsellorGarbage;
	private KingBonuses kingBonuses;
	private ArrayList<Player> players;
	private Player currentPlayer;

	/**
	 * @return the map
	 */
	public Map getMap() {
		return map;
	}
	
	/**
	 * @return the regions
	 */
	public Set<Region> getRegions() {
		return regions;
	}
	
	/**
	 * @return the nobility
	 */
	public Nobility getNobility() {
		return nobility;
	}
	
	/**
	 * @return the politicalDeck
	 */
	public PoliticalRealDeck getPoliticalDeck() {
		return politicalDeck;
	}
	
	/**
	 * @return the garbage
	 */
	public PoliticalGarbage getGarbage() {
		return garbage;
	}
	
	/**
	 * @return the balcony
	 */
	public Balcony getBalcony() {
		return balcony;
	}
	
	/**
	 * @return the counsellorGroup
	 */
	public CounsellorGroup getCounsellorGroup() {
		return counsellorGroup;
	}
	
	/**
	 * @return the counsellorGarbage
	 */
	public GarbageState getCounsellorGarbage() {
		return counsellorGarbage;
	}
	
	/**
	 * @return the kingBonuses
	 */
	public KingBonuses getKingBonuses() {
		return kingBonuses;
	}
	
	/**
	 * @param players the players to set
	 */
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	/**
	 * @return the players
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	/**
	 * @return the currentPlayer
	 */
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	/**
	 * @param currentPlayer the currentPlayer to set
	 */
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	
	public void nextPlayer(Player player){
		int i=this.getPlayers().indexOf(player);
		if((i+1)!=this.getPlayers().size()) this.setCurrentPlayer(this.getPlayers().get(i+1));
		else this.setCurrentPlayer(this.getPlayers().get(0));
	}
	
}
