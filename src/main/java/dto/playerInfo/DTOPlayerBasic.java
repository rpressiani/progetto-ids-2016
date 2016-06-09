package dto.playerInfo;

import dto.DTOObject;
import dto.utilities.DTOColor;

public class DTOPlayerBasic implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1502123848556511187L;
	
	private final int serialID;
	private final String nickname;
	private final DTOColor color;
	
	public DTOPlayerBasic(int serialID, String nickname, DTOColor color) {
		this.serialID = serialID;
		this.nickname = nickname;
		this.color = color;
	}

	/**;
	 * @return the serialID
	 */
	public int getSerialID() {
		return serialID;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @return the color
	 */
	public DTOColor getColor() {
		return color;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + serialID;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DTOPlayerBasic other = (DTOPlayerBasic) obj;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (serialID != other.serialID)
			return false;
		return true;
	}

}
