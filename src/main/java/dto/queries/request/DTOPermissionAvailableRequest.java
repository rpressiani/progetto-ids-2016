package dto.queries.request;

import dto.DTOObject;
import dto.queries.DTOQuery;
import dto.queries.VisitorQueries;

public class DTOPermissionAvailableRequest implements DTOQuery {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4002503767529302892L;

	@Override
	public DTOObject accept(VisitorQueries v) {
		return v.visit(this);
	}


}
