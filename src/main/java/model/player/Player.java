package model.player;

import java.util.HashSet;
import java.util.Set;

import utilities.Color;
import model.GameState;
import model.actions.GeneralAction;
import model.actions.NullAction;
import model.actions.main.MainAction;
import model.actions.market.BuyAction;
import model.actions.market.SellAction;
import model.actions.quick.QuickAction;
import model.bonusable.PermissionCard;
import model.map.City;
import model.politicalDeck.PoliticalCard;
import model.politicalDeck.PoliticalHand;
import model.politicalDeck.PoliticalRealDeck;
import model.stateMachine.state.State;
import model.stateMachine.state.StartState;
import parser.Parser;

/**
 * @author Riccardo Pressiani
 *
 */
public class Player {
	
	private static int serialIDGenerator = 0;
	private final int serialID;
	private int id;
	private boolean enabled;
	private String nickname;
	private Coins coins;
	private NobilityLevel nobilityLevel;
	private Score score;
	private Assistants assistants;
	private Color color;
	private PoliticalHand politicalHand;
	private Set<PermissionCard> permissionHand;
	private Set<City> builtCities; 
	private State state;
	
	/**
	 * Constructor
	 * Set nickname, color, hand and create the other objects.
	 * 
	 * @param nickname	nickname chosen by the player
	 * @param color		color chosen by the player
	 */
	public Player() {
		this.enabled = false;
		this.serialID = serialIDGenerator;
		serialIDGenerator++;
		this.nickname = null;
		this.color = null;
		this.nobilityLevel = new NobilityLevel();
		this.score = new Score();
		this.builtCities = new HashSet<City>();
		this.permissionHand= new HashSet<PermissionCard>();
	}
	
	/**
	 * initPlayer conclude the setting of the player after he has joined a specific match. An ID is set, coins and assistants
	 * are set based on the content of the configuration file and the PoliticalHand of the player is instantiated.
	 * 
	 * @param deck							PoliticalRealDeck in use during the match
	 * @param id							the order of the players, it must start from 0 (zero)and be incremental (e.g 0, 1, 2, 3, ...)
	 * @param parser						Parser in use during the match
	 * 
	 * @throws IlleagalArgumentException	if id is lower of zero
	 */
	public void initPlayer(PoliticalRealDeck deck, Integer id, Parser parser) throws IllegalArgumentException {
		if (id < 0) throw new IllegalArgumentException("id must be greater or equal than zero");
		if (this.nickname == null || this.color == null) throw new NullPointerException("cannot init a player if it is not enabled");
		if(deck==null || parser==null) {
			throw new NullPointerException("parser and deck cannot be nulle"); 
		}
		this.id = id;	//as a player register to a match this ID attribute has to increment, basically it'll represent the order
						//of the players in a match
		this.politicalHand = new PoliticalHand(deck);
		this.coins = new Coins(parser.getCFGRoot().getPlayers().getPlayer().get(this.id).getCoins().intValue());
		this.assistants = new Assistants(parser.getCFGRoot().getPlayers().getPlayer().get(this.id).getAssistants().intValue());
		this.state = new StartState();
	}
	
	/**
	 * @param action
	 * @param gameState
	 * @throws NullPointerException if action or gameState are null
	 */
	public void move(GeneralAction action, GameState gameState) {
		if(action==null) {
			throw new NullPointerException("action cannot be null"); 
		}
		if(gameState==null) {
			throw new NullPointerException("player should be playing a game which is not null"); 
		}
		if(action instanceof MainAction){
			this.getState().transition(this, (MainAction)action, gameState);
		}
		
		if(action instanceof QuickAction){
			this.getState().transition(this, (QuickAction)action, gameState);
		}
		
		if(action instanceof NullAction){
			this.getState().transition(this, (NullAction)action, gameState);
		}
		
		if(action instanceof SellAction){
			this.getState().transition(this, (SellAction)action, gameState);
		}
		
		if(action instanceof BuyAction){
			this.getState().transition(this, (BuyAction)action, gameState);
		}
	}
	
	/*public void move(MainAction action, GameState gameState){
		this.getState().transition(this, action, gameState);
	}
	
	public void move(QuickAction action, GameState gameState){
		this.getState().transition(this, action, gameState);
	}
	
	public void move(NullAction action, GameState gameState){
		this.getState().transition(this, action, gameState);
	}*/

	public void printState(){
		this.getState().printOut(this, this.state);
	}
	
	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @return the coins
	 */
	public Coins getCoins(){
		return coins;
	}
	
	/**
	 * @return the nobility
	 */
	public NobilityLevel getNobilityLevel() {
		return nobilityLevel;
	}

//	/* (non-Javadoc)
//	 * @see java.lang.Object#toString()
//	 */
//	@Override
//	public String toString() {
//		return "Player [id=" + id + ", nickname=" + nickname + ", coins=" + coins + ", nobilityLevel=" + nobilityLevel
//				+ ", score=" + score + ", assistants=" + assistants + ", color=" + color + ", politicalHand="
//				+ politicalHand + "]";
//	}

	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Player [serialID=" + serialID + ", enabled=" + enabled + ", nickname=" + nickname + ", color=" + color
				+ "]";
	}

	/**
	 * @return the score
	 */
	public Score getScore() {
		return score;
	}

	/**
	 * @return the assistants
	 */
	public Assistants getAssistants() {
		return assistants;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * @return the hand
	 */
	public PoliticalHand getPoliticalHand() {
		return politicalHand;
	}

	/**
	 * @return the permissionHand
	 */
	public Set<PermissionCard> getPermissionHand() {
		return permissionHand;
	}
	
	/**
	 * @return the cities where a player has already built at least one emporium
	 */
	public Set<City> getBuiltCities() {
		return builtCities; 
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the currentState
	 */
	public State getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(State state) {
		if(state==null) {
			throw new IllegalArgumentException("cannot set a null state"); 
		}
		this.state = state;
	}

	/**
	 * @return the serialID
	 */
	public int getSerialID() {
		return serialID;
	}

	public int getAssistantsPlusPoliticals(){
		int res=0;
		for(PoliticalCard c : this.getPoliticalHand().getDeck()){
			res=res+c.getNumCards();
		}
		
		res=res+this.getAssistants().getItems();
		
		return res;
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
		Player other = (Player) obj;
		if (serialID != other.serialID)
			return false;
		return true;
	}
}
