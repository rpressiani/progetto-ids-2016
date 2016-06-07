package dto.playerInfo;

import dto.DTOObject;

public class DTONobilityLevel implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8147591181134225814L;

	private final int level;
	
	/**
	 * @param level
	 * @throws IllegalArgumentException if level<0
	 */
	public DTONobilityLevel(int level) {
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
