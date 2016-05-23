package controller;

import model.player.NobilityLevel;

public class NobilityLevelChange extends ItemChange {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4194003023779453811L;
	private static NobilityLevel newNobilityLevel; 
	
	public NobilityLevelChange() {
		super(newNobilityLevel); 
	}	

}
