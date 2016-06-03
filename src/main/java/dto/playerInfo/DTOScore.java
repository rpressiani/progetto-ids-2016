package dto.playerInfo;

import dto.DTOObject;

public class DTOScore implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4268826473119591611L;

	private final int level;
	
	public DTOScore(int level){
		this.level=level;
	}

	public int getLevel() {
		return level;
	}
	
	
}
