package dto.playerInfo;

import dto.DTOObject;

public class DTONobilityLevel implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8147591181134225814L;

	private final int level;
	
	public DTONobilityLevel(int level){
		this.level=level;
	}

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
