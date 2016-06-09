/**
 * 
 */
package client;

import java.io.Serializable;

import dto.DTOObject;
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
	
	private transient Player player;
	private DTOObject message;
	
	public ClientMessage(Player player, DTOObject message){
		this.player = player;
		this.message = message;
	}
	
	public ClientMessage(DTOObject message){
		this.message = message;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClientMessage [player=" + player + ", message=" + message + "]";
	}

}
