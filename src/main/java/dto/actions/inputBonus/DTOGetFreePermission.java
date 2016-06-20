package dto.actions.inputBonus;

import controller.VisitorActions;
import dto.map.DTORegion;
import model.actions.inputBonus.GetFreePermission;
import model.player.Player;

public class DTOGetFreePermission implements DTOInputBonusAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3319606110771202129L;

	private final DTORegion region;
	private final int index;
	
	public DTOGetFreePermission(DTORegion region, int index) {
		this.region=region;
		this.index=index;
	}
	
	public DTORegion getRegion() {
		return region;
	}

	public int getIndex() {
		return index;
	}
	
	@Override
	public GetFreePermission accept(VisitorActions v, Player player) {
		return v.visit(this);
	}

}
