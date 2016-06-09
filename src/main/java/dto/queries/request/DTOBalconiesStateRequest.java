package dto.queries.request;

import dto.DTOObject;
import dto.queries.DTOQuery;
import dto.queries.VisitorQueries;

public class DTOBalconiesStateRequest implements DTOQuery {

	/**
	 * 
	 */
	private static final long serialVersionUID = -830735292021594022L;

	@Override
	public DTOObject accept(VisitorQueries v) {
		return v.visit(this);
	}

}
