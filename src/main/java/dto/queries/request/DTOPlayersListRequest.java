package dto.queries.request;

import dto.DTOObject;
import dto.queries.DTOQuery;
import dto.queries.VisitorQueries;

public class DTOPlayersListRequest implements DTOQuery {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2734250436121125135L;

	@Override
	public DTOObject accept(VisitorQueries v) {
		return v.visit(this);
	}

}
