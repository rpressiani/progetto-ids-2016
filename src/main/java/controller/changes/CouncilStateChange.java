package controller.changes;

import model.council.CouncilState;

public class CouncilStateChange extends Change {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5492028656455894540L;
	private CouncilState councilState; 
	
	public CouncilStateChange(CouncilState councilState) {
		this.councilState = councilState; 
	}
	public CouncilState getCouncilStateChange() {
		return councilState; 
	}
	@Override
	public String toString() {
		return "CouncilStateChange [councilState=" + councilState + "]";
	}
	

}
