package dto.queries.request;

import dto.DTOObject;
import dto.queries.DTOQuery;
import dto.queries.VisitorQueries;

public class DTOScoresRequest implements DTOQuery {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1386453953371632145L;

	@Override
	public DTOObject accept(VisitorQueries v) {
		return v.visit(this);
	}

}
