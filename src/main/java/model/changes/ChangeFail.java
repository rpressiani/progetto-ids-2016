package model.changes;

import dto.changes.DTOChange;
import model.player.Player;
import view.VisitorChanges;

public class ChangeFail implements Change {

	private String msg;
	
	public ChangeFail(String msg){
		this.msg=msg;
	}
	
	@Override
	public DTOChange accept(VisitorChanges v, Player player) {
		return v.visit(this);
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

}
