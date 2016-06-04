package dto.utilities;

import dto.DTOObject;

public class DTOSetup implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8337883506451860778L;
	
	private final String nickname;
	private final DTOColor color;
	
	public DTOSetup(String nickname, DTOColor color) {
		this.nickname = nickname;
		this.color = color;
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
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DTOSetup [nickname=" + nickname + ", color=" + color + "]";
	}

}
