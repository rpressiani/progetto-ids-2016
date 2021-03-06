package model.player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import utilities.Color;
import view.View;
import model.GameState;
import model.actions.ChatAction;
import model.actions.GeneralAction;
import model.actions.NullAction;
import model.actions.QuitAction;
import model.actions.inputBonus.InputBonusAction;
import model.actions.main.MainAction;
import model.actions.market.BuyAction;
import model.actions.market.SellAction;
import model.actions.quick.QuickAction;
import model.bonusItem.BonusInputItem;
import model.bonusable.PermissionCard;
import model.map.City;
import model.politicalDeck.PoliticalCard;
import model.politicalDeck.PoliticalHand;
import model.politicalDeck.PoliticalRealDeck;
import model.stateMachine.StartState;
import model.stateMachine.State;
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
	private boolean bonusChosed;
	private String nickname;
	private Coins coins;
	private NobilityLevel nobilityLevel;
	private Score score;
	private Assistants assistants;
	private Color color;
	private PoliticalHand politicalHand;
	private Set<PermissionCard> permissionHand;
	private Set<City> builtCities; 
	private ArrayList<BonusInputItem> bonusInputs;
	private State state;
	private View view;
	
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
		this.permissionHand = new HashSet<PermissionCard>();
		this.bonusInputs = new ArrayList<BonusInputItem>();
		this.bonusChosed=false;
	}
	
	/**
	 * @param view the view to set
	 */
	public void setView(View view) {
		this.view = view;
	}

	/**
	 * @return the view
	 */
	public View getView() {
		return view;
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
			throw new NullPointerException("parser and deck cannot be null"); 
		}
		this.id = id;	//as a player register to a match this ID attribute has to increment, basically it'll represent the order
						//of the players in a match
		this.politicalHand = new PoliticalHand(deck);
		this.coins = new Coins(parser.getCFGRoot().getPlayers().getPlayer().get(0).getCoins().intValue()+this.id);
		this.assistants = new Assistants(parser.getCFGRoot().getPlayers().getPlayer().get(0).getAssistants().intValue()+this.id);
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
		
		if(action instanceof InputBonusAction){
			this.getState().transition(this, (InputBonusAction)action, gameState);
		}
		
		if(action instanceof QuitAction){
			this.getState().transition(this, (QuitAction)action, gameState);
		}
		
		if(action instanceof ChatAction){
			this.getState().transition(this, (ChatAction)action, gameState);
		}
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

	/**
	 * @return the bonusInputs
	 */
	public ArrayList<BonusInputItem> getBonusInputs() {
		return bonusInputs;
	}
	
	public boolean isBonusChosed() {
		return bonusChosed;
	}

	public void setBonusChosed(boolean bonusChosed) {
		this.bonusChosed = bonusChosed;
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
