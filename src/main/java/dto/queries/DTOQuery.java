package dto.queries;

import dto.DTOObject;

public interface DTOQuery extends DTOObject {
	
	/**
	 * 
	 * @param v
	 * @return the DTOObject visited by visitor
	 */
	public DTOObject accept(VisitorQueries v);

}
