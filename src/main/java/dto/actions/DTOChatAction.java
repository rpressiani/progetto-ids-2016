package dto.actions;

import controller.VisitorActions;
import model.actions.ChatAction;
import model.player.Player;

public class DTOChatAction implements DTOAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6169587799156053431L;

	private final String msg;
	
	public DTOChatAction(String msg) {
		this.msg=msg;
	}
	
	public String getMsg() {
		return msg;
	}
	
	@Override
	public ChatAction accept(VisitorActions v, Player player) {
		return v.visit(this);
	}

}
