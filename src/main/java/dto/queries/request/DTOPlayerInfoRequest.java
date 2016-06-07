package dto.queries.request;

import dto.DTOObject;
import dto.queries.DTOQuery;
import dto.queries.VisitorQueries;

public class DTOPlayerInfoRequest implements DTOQuery {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1532588855264896715L;
	
	private final String player;
	
	public DTOPlayerInfoRequest(String player) {
		this.player = player;
	}
	
	public DTOPlayerInfoRequest() {
		this.player = "me";
	}

	@Override
	public DTOObject accept(VisitorQueries v) {
		return v.visit(this);
	}

	/**
	 * @return the player
	 */
	public String getPlayer() {
		return player;
	}

}
