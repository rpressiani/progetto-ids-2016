package model.changes;

import dto.changes.DTOChangeMsg;
import view.VisitorChanges;

public class ChangeMsg implements Change {

	private String msg;
	
	/**
	 * @param msg
	 * @throws NullPointerException if msg is null
	 */
	public ChangeMsg(String msg) {
		if(msg==null) {
			throw new NullPointerException("msg cannot be null"); 
		}
		this.msg=msg;
	}
	
	@Override
	public DTOChangeMsg accept(VisitorChanges v) {
		return v.visit(this);
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

}
