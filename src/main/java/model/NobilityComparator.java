package model;

import java.util.Comparator;

import model.player.Player;

public class NobilityComparator implements Comparator<Player> {
	
	/**
	 * 
	 * @param p1 player
	 * @param p2 player
	 * @return 1 if p2Nobility is greater than p1Nobility, -1 the opposite, 0 if same nobility
	 */
	@Override
	public int compare(Player p1, Player p2) {
		if(p1==null || p2==null) throw new NullPointerException("players can't be null");
		
		return p2.getNobilityLevel().getItems().compareTo(p1.getNobilityLevel().getItems());
	}


}
