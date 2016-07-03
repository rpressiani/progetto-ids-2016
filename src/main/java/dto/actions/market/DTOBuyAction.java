package dto.actions.market;

import controller.VisitorActions;
import dto.actions.DTOAction;
import model.actions.market.BuyAction;
import model.player.Player;

public class DTOBuyAction implements DTOAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4077745546664700273L;

	private final int idContract;
	
	/**
	 * @param playerName
	 * @throws NullPointerException if playerName is null
	 */
	public DTOBuyAction(int idContract) {
		if(idContract<=0) {
			throw new IllegalArgumentException("idContract must be >0"); 
		}
		this.idContract=idContract;
	}

	/**
	 * 
	 * @return playerName
	 */
	public int getIdContract() {
		return idContract;
	}
	
	@Override
	public BuyAction accept(VisitorActions v, Player player) {
		return v.visit(this);
	}

}
