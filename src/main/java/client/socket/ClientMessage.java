/**
 * 
 */
package client.socket;

import java.io.Serializable;

import client.rmi.ClientViewRemote;
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
	private final DTOObject message;
	private ClientViewRemote clientRMI;
	

	/**
	 * Constructor
	 * @param player
	 * @param message
	 */
	public ClientMessage(Player player, DTOObject message){
		this.player = player;
		this.message = message;
	}
	
	/**
	 * @param clientRMI
	 * @param message
	 */
	public ClientMessage(ClientViewRemote clientRMI, DTOObject message){
		this.clientRMI = clientRMI;
		this.message = message;
	}
	
	/**
	 * @param message
	 */
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
	public DTOObject getMessage() {
		return message;
	}
	
	/**
	 * @return the clientRMI
	 */
	public ClientViewRemote getClientRMI() {
		return clientRMI;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClientMessage [player=" + player + ", message=" + message + "]";
	}

}
