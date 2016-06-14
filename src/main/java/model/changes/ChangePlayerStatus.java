package model.changes;

import dto.changes.DTOChangePlayerStatus;
import model.player.Player;
import view.VisitorChanges;

public class ChangePlayerStatus implements Change {

	private Player player;

	public ChangePlayerStatus(Player player) {
		if(player==null) {
			throw new NullPointerException("player cannot be null"); 
		}
		
		this.player = player;
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	@Override
	public DTOChangePlayerStatus accept(VisitorChanges v) {
		return v.visit(this);
	}

}
