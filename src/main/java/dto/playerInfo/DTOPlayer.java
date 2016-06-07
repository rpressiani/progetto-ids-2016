package dto.playerInfo;

import dto.DTOObject;

public class DTOPlayer implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1502123848556511187L;
	
	private final int serialID;
	private final String nickname;
	
	public DTOPlayer(int serialID, String nickname) {
		this.serialID = serialID;
		this.nickname = nickname;
	}

	/**
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

}
