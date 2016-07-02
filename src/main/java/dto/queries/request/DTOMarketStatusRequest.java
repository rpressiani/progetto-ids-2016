package dto.queries.request;

import dto.DTOObject;
import dto.queries.DTOQuery;
import dto.queries.VisitorQueries;

public class DTOMarketStatusRequest implements DTOQuery {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2104319926523578601L;

	@Override
	public DTOObject accept(VisitorQueries v) {
		return v.visit(this);
	}

}
