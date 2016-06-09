package dto.queries.request;

import dto.DTOObject;
import dto.queries.DTOQuery;
import dto.queries.VisitorQueries;

public class DTOPingRequest implements DTOQuery {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8733914274145859278L;

	@Override
	public DTOObject accept(VisitorQueries v) {
		return v.visit(this);
	}

}
