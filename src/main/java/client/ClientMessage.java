/**
 * 
 */
package client;

import java.io.Serializable;

import model.player.Player;

/**
 * @author Riccardo Pressiani
 *
 */
public class ClientMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8197501378692211337L;
	
	private Player player;
	private String nickname;
	private Object message;
	
	public ClientMessage(Player player, Object message){
		this.player = player;
		this.message = message;
		this.nickname = null;
	}
	
	public ClientMessage(String nickname, Object message){
		this.player = null;
		this.message = message;
		this.nickname = nickname;
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @return the message
	 */
	public Object getMessage() {
		return message;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClientMessage [player=" + player + ", nickname=" + nickname + ", message=" + message + "]";
	}

}
