package dto.queries;

import dto.DTOObject;

public interface DTOQuery extends DTOObject {
	
	public DTOObject accept(VisitorQueries v);

}
