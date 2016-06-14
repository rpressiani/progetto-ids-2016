package model;

import model.player.Player;

public class NobilityComparator implements Comparable<Player> {
	
	/**
	 * 
	 * @param p1 player
	 * @param p2 player
	 * @return 1 if p1Nobility is greater than p2Nobility, -1 the opposite, 0 if same nobility, 
	 */
	public int compareTo(Player p1, Player p2) {
		if(p1==null || p2==null) throw new NullPointerException("players can't be null");
		
		return p1.getNobilityLevel().getItems().compareTo(p2.getNobilityLevel().getItems());
	}

	@Override
	public int compareTo(Player o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
