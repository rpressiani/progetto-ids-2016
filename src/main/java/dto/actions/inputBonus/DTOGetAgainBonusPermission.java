package dto.actions.inputBonus;

import controller.VisitorActions;
import dto.utilities.DTOPermissionCardSelection;
import model.actions.inputBonus.GetAgainBonusPermission;
import model.player.Player;

public class DTOGetAgainBonusPermission implements DTOInputBonusAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8410251988246068343L;

	private final DTOPermissionCardSelection card;
	
	public DTOGetAgainBonusPermission(DTOPermissionCardSelection card) {
		if(card==null) {
			throw new NullPointerException("card cannot be null"); 
		}
		this.card=card;
	}

	public DTOPermissionCardSelection getCard() {
		return card;
	}
	
	@Override
	public GetAgainBonusPermission accept(VisitorActions v, Player player) {
		
		return v.visit(this, player);
	}

}
