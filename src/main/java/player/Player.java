package player;

import politicalDeck.Color;
import politicalDeck.Hand;

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
	

}
