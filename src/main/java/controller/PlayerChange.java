package controller;

import player.Player;

public class PlayerChange extends Change {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8559234874023133876L;
	private final Player newPlayer; 
	
	public PlayerChange(Player newPlayer) {
		this.newPlayer = newPlayer; 
	}
	public Player getNewPlayer() {
		return newPlayer; 
	}
	@Override
	public String toString() {
		return "PlayerChange [newPlayer=" + newPlayer + "]";
	}
	
	
	

}
