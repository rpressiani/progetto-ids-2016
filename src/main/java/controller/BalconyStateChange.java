package controller;

import model.council.Balcony;

public class BalconyStateChange extends Change {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8385165612632503637L;
	private Balcony balconyState; 
	
	public BalconyStateChange(Balcony balconyState) {
		this.balconyState = balconyState; 
	}
	public Balcony getBalconyStateChange() {
		return balconyState; 
	}
	@Override
	public String toString() {
		return "BalconyStateChange [balconyState=" + balconyState + "]";
	}
	

}
