package dto.actions.inputBonus;

import java.util.Set;

import controller.VisitorActions;
import dto.map.DTOCity;
import model.actions.inputBonus.GetFreeToken;
import model.player.Player;

public class DTOGetFreeToken implements DTOInputBonusAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4603850478081468105L;

	private final Set<DTOCity> cities;
	
	public DTOGetFreeToken(Set<DTOCity> cities) {
		if(cities==null) {
			throw new NullPointerException("cities cannot be null"); 
		}
		this.cities=cities;
	}
	
	public Set<DTOCity> getCities() {
		return cities;
	}
	
	@Override
	public GetFreeToken accept(VisitorActions v, Player player) {
		return v.visit(this, player);
	}

}
