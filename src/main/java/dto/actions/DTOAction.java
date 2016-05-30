package dto.actions;

import controller.VisitorActions;
import dto.DTOObject;

public interface DTOAction extends DTOObject {
	void accept(VisitorActions v);
}
