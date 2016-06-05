package dto.utilities;

import dto.DTOObject;

public class DTOSetup implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8337883506451860778L;
	
	private final String nickname;
	private final DTOColor color;
	
	/**
	 * @param nickname
	 * @param color
	 * @throws NullPointerException if nickname or color are null
	 */
	public DTOSetup(String nickname, DTOColor color) {
		if(nickname==null) {
			throw new NullPointerException("nickname cannot be null"); 
		}
		if(color==null) {
			throw new NullPointerException("color cannot be null"); 
		}
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
