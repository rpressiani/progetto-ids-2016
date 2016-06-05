package dto.queries.request;

import dto.DTOObject;
import dto.queries.DTOQuery;
import dto.queries.VisitorQueries;

public class DTOGetProposalOrder implements DTOQuery {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3734921273021305140L;

	@Override
	public DTOObject accept(VisitorQueries v) {
		return v.visit(this);
	}

}
