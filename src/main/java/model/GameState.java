package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

import model.changes.Change;
import model.council.Balcony;
import model.council.GarbageState;
import model.map.Map;
import model.market.Market;
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
	private GarbageState counsellorGarbage;
	private KingBonuses kingBonuses;
	private King king;
	private ArrayList<Player> players;
	private HashMap<String, Player> playersHashMap;
	private Player currentPlayer;
	private Market market;
	private Parser parser;

	public GameState(Parser parser, ArrayList<Player> players) {
		if(parser==null) {
			throw new NullPointerException("cannot have a null parser"); 
		}
		if(players==null) {
			throw new NullPointerException("there should be at least one player"); 
		}
		this.counsellorGarbage = new GarbageState(parser);
		this.map = new Map(parser, this.counsellorGarbage);
		this.king = new King(parser, this.map);
		this.kingBalcony = new Balcony(this.counsellorGarbage, parser);
		this.kingBonuses = new KingBonuses(parser);
		this.nobility = new Nobility(parser);
		this.politicalGarbage = new PoliticalGarbage(parser);
		this.politicalDeck = new PoliticalRealDeck(parser, this.politicalGarbage);
		this.players = players;
		this.parser=parser;

		this.playersHashMap = new HashMap<String, Player>();
		
		for (Player player : players) {
			this.playersHashMap.put(player.getNickname(), player);
		}

		
		//Players sorting still to be decided
		this.currentPlayer = this.players.get(0);
		
	}

	//temporary for ClientLogic
	public GameState(ArrayList<Player> players2) {
		this.players=players2;
		this.currentPlayer=this.players.get(0);
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
		if(players==null) {
			throw new NullPointerException("players should not be null"); 
		}
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
		if(currentPlayer==null) {
			throw new NullPointerException("currentPlayer should not be null"); 
		}
		this.currentPlayer = currentPlayer;
	}
	
	/**
	 * @return the playersHashMap
	 */
	public HashMap<String, Player> getPlayersHashMap() {
		return playersHashMap;

	}
	
	/**
	 * @return the market
	 */
	public Market getMarket() {
		return market;
	}
	
	/**
	 * @return the parser
	 */
	public Parser getParser() {
		return parser;
	}
	
	public void nextPlayer(Player player){
		if(player==null) {
			throw new NullPointerException("player should not be null"); 
		}
		if(player==this.getCurrentPlayer()){
			int i=this.getPlayers().indexOf(player);
			if((i+1)!=this.getPlayers().size()) this.setCurrentPlayer(this.getPlayers().get(i+1));
			else this.setCurrentPlayer(this.getPlayers().get(0));
		}
	}

	public Player calculateWinner(ArrayList<Player> players){
	
		int maxPermissions=players.get(0).getPermissionHand().size();
		
		for(Player p : players){
			if(p.getPermissionHand().size()>maxPermissions) maxPermissions=p.getPermissionHand().size();
		}
		
		for(Player p : players){
			if(p.getPermissionHand().size()==maxPermissions) p.getScore().add(3);
		}
		
		
		Collections.sort(players, new NobilityComparator());
		
		int i;
		int maxNobility=players.get(0).getNobilityLevel().getItems();
		
		for(i=0 ; maxNobility==players.get(i).getNobilityLevel().getItems(); i++){
			players.get(i).getScore().add(5);
		}
		
		if(i==1){
			maxNobility=players.get(i).getNobilityLevel().getItems();
			for(i=1; maxNobility==players.get(i).getNobilityLevel().getItems(); i++){
				players.get(i).getScore().add(2);
			}
		}
		
		
		Collections.sort(players, new ScoreComparator());
	
		i=0;
		int maxScore=players.get(0).getScore().getItems();
		
		while(maxScore==players.get(i).getScore().getItems()){
			i++;
		}
		
		if(i==1) return players.get(0);
		
		else{
			int maxAssistantsPlusPoliticals=players.get(0).getAssistantsPlusPoliticals();
			HashMap<Player, Integer> result=new HashMap<Player, Integer>();
			
			for(int j=0; j<i; j++){
				result.put(players.get(j), players.get(j).getAssistantsPlusPoliticals());
				
				if(players.get(j).getAssistantsPlusPoliticals()>maxAssistantsPlusPoliticals) maxAssistantsPlusPoliticals=
						players.get(j).getAssistantsPlusPoliticals();
				
			}
			
			for(Entry<Player,Integer> entry : result.entrySet()){
				if(entry.getValue()==maxAssistantsPlusPoliticals){
					players.add(0,entry.getKey());
				}
			}
			
			return players.get(0);
		}
		
	}
	
}
