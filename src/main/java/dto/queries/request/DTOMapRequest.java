package dto.queries.request;

import dto.DTOObject;
import dto.queries.DTOQuery;
import dto.queries.VisitorQueries;

public class DTOMapRequest implements DTOQuery {

	/**
	 * 
	 */
	private static final long serialVersionUID = 291546193769641157L;

	@Override
	public DTOObject accept(VisitorQueries v) {
		return v.visit(this);
	}

}
