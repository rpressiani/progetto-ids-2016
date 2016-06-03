package model.changes;

import dto.changes.DTOChange;
import model.player.Player;
import view.VisitorChanges;

public interface Change {
	
	public DTOChange accept(VisitorChanges v, Player player);
}
