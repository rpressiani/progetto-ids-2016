package model;

import java.util.Comparator;

import model.player.Player;

public class ScoreComparator implements Comparator<Player> {

	/**
	 * 
	 * @param p1 player
	 * @param p2 player
	 * @return 1 if p2Score is greater than p1Score, -1 the opposite, 0 if same score
	 */
	@Override
	public int compare(Player p1, Player p2) {
		if(p1==null || p2==null) throw new NullPointerException("players can't be null");
		
		return p2.getScore().getItems().compareTo(p1.getScore().getItems());
	}

}
