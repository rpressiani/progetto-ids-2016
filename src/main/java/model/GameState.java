package model;

import java.util.ArrayList;

//import controller.BalconyStateChange;
import controller.Change;
import controller.CurrentPlayerChange;
import model.council.Balcony;
import model.council.GarbageState;
import model.map.Map;
import model.player.Player;
import model.politicalDeck.PoliticalGarbage;
import model.politicalDeck.PoliticalRealDeck;
import model.sharedObjects.King;
import model.sharedObjects.KingBonuses;
import model.sharedObjects.Nobility;
import observer.Observable;
import parser.Parser;

public class GameState extends Observable<Change>{
	private Map map;
	private Nobility nobility;
	private PoliticalRealDeck politicalDeck;
	private PoliticalGarbage politicalGarbage;
	private Balcony kingBalcony;
//	private CounsellorGroup counsellorGroup; 
	private GarbageState counsellorGarbage;
	private KingBonuses kingBonuses;
	private King king;
	private ArrayList<Player> players;
	private Player currentPlayer;
	
	public GameState(Parser parser, ArrayList<Player> players) {
		
		this.counsellorGarbage = new GarbageState(parser);
		this.map = new Map(parser, this.counsellorGarbage);
		this.king = new King(parser, this.map);
		this.kingBalcony = new Balcony(this.counsellorGarbage, parser);
		this.kingBonuses = new KingBonuses(parser);
		this.nobility = new Nobility(parser); //NEED TO BE CONSTRUCTED VIA PARSER
		this.politicalGarbage = new PoliticalGarbage(parser);
		this.politicalDeck = new PoliticalRealDeck(parser, this.politicalGarbage);
		this.players = players;
		
		
		//Players sorting still to be decided
//		this.currentPlayer = this.players.get(0);
		
	}

	/**
	 * @return the map
	 */
	public Map getMap() {
		return map;
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
		return politicalGarbage;
	}
	
	/**
	 * @return the balcony
	 */
	public Balcony getKingBalcony() {
		return kingBalcony;
	}
	
//	/**
//	 * @return the counsellorGroup
//	 */
//	public CounsellorGroup getCounsellorGroup() {
//		return counsellorGroup;
//	}
	
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
	 * @return the king
	 */
	public King getKing() {
		return king;
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
		this.notifyObserver(new CurrentPlayerChange(currentPlayer));
	}
	
	public void nextPlayer(Player player){
		int i=this.getPlayers().indexOf(player);
		if((i+1)!=this.getPlayers().size()) this.setCurrentPlayer(this.getPlayers().get(i+1));
		else this.setCurrentPlayer(this.getPlayers().get(0));
		//this.notifyObserver(new CurrentPlayerChange(player));
	}
	
	/*public void setNewBalcony(Balcony balcony) {
		this.balcony = balcony; 
		this.notifyObserver(new BalconyStateChange(balcony));
	}*/
}
