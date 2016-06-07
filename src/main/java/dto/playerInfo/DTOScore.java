package dto.playerInfo;

import dto.DTOObject;

public class DTOScore implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4268826473119591611L;

	private final int level;
	
	/**
	 * @param level
	 * @throws IllegalArgumentException if level<0
	 */
	public DTOScore(int level) {
		if(level<0) {
			throw new IllegalArgumentException("level must be >=0"); 
		}
		this.level=level;
	}

	/**
	 * 
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.valueOf(this.getLevel());
	}
	
}
