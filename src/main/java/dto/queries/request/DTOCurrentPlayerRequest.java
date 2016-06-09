package dto.queries.request;

import dto.DTOObject;
import dto.queries.DTOQuery;
import dto.queries.VisitorQueries;

public class DTOCurrentPlayerRequest implements DTOQuery {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1257453618056565327L;
	
	@Override
	public DTOObject accept(VisitorQueries v) {
		return v.visit(this);
	}

}
