package controller.changes;

import model.player.Player;
import model.sharedObjects.PermissionDeck;

public class PermissionCardChange extends Change {

	/**
	 * 
	 */
	private static final long serialVersionUID = -
			5096998898235097064L;
	private static Player player; 
	private PermissionDeck permissionHand; 
	
	public PermissionCardChange(Player player, PermissionDeck permissionHand) {
		PermissionDeck tmp = (PermissionDeck) player.getPermissionHand(); 
		this.permissionHand = permissionHand; 
		permissionHand = tmp; 
	}
	public PermissionDeck getNewPermissionHand() {
		return permissionHand; 
	}
	@Override
	public String toString() {
		return "PermissionCardChange [permissionHand=" + permissionHand + "]";
	}
	

}
