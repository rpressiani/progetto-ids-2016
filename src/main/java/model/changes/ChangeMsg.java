package model.changes;

import dto.changes.DTOChangeMsg;
import model.player.Player;
import view.VisitorChanges;

public class ChangeMsg implements Change {

	private String msg;
	
	public ChangeMsg(String msg){
		this.msg=msg;
	}
	
	@Override
	public DTOChangeMsg accept(VisitorChanges v, Player player) {
		return v.visit(this);
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

}
