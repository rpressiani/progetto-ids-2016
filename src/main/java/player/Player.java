package player;

import politicalDeck.Hand;
import utilities.Color;

/**
 * @author Riccardo Pressiani
 *
 */
public class Player {
	
	private String nickname;
	private Coins coins;
	private Nobility nobility;
	private Score score;
	private Assistants assistants;
	private Color color;
	private Hand hand;
	
//	Waiting for permission card to be implemented
//	private Set<PermissionCard> permissionCards;
	
	/**
	 * Constructor
	 * Set nickname, color, hand and create the other objects.
	 * 
	 * @param nickname	nickname chosen by the player
	 * @param color		color chosen by the player
	 */
	public Player(String nickname, Color color) {
		this.nickname = nickname;
		this.color = color;
		
		this.hand = new Hand();
		this.coins = new Coins();
		this.nobility = new Nobility();
		this.score = new Score();
		this.assistants = new Assistants();
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
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
	public Nobility getNobility() {
		return nobility;
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
	 * @return the hand
	 */
	public Hand getHand() {
		return hand;
	}

}
