package model.changes;

import dto.changes.DTOChange;
import view.VisitorChanges;

public interface Change {
	
	public DTOChange accept(VisitorChanges v);
}
