package dto.queries.request;

import dto.DTOObject;
import dto.queries.DTOQuery;
import dto.queries.VisitorQueries;

public class DTOFreeCounsellorsRequest implements DTOQuery {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4195640952983237847L;

	@Override
	public DTOObject accept(VisitorQueries v) {
		return v.visit(this);
	}

}
