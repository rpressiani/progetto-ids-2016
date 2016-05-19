package controller;

import player.Player;

public class CurrentPlayerChange extends Change {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8559234874023133876L;
	private final Player newCurrentPlayer; 
	
	public CurrentPlayerChange(Player newCurrentPlayer) {
		this.newCurrentPlayer = newCurrentPlayer; 
	}
	@Override
	public String toString() {
		return "PlayerChange [newCurrentPlayer=" + newCurrentPlayer + "]";
	}
	
	

}
