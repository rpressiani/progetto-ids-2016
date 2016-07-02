package dto.actions.market;

import java.util.Set;

import controller.VisitorActions;
import dto.actions.DTOAction;
import dto.playerInfo.DTOAssistants;
import dto.playerInfo.DTOCoins;
import dto.utilities.DTOPermissionCardSelection;
import dto.utilities.DTOPoliticalContainer;
import model.actions.market.SellAction;
import model.player.Player;

public class DTOSellAction implements DTOAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7083999479569360792L;
	
	private final DTOCoins sellCoins, buyCoins;
	private final DTOAssistants sellAssistants, buyAssistants;
	private final Set<DTOPermissionCardSelection> sellPermissions, buyPermissions;
	private final DTOPoliticalContainer sellPoliticals, buyPoliticals;

	/**
	 * @param sellCoins
	 * @param sellAssistants
	 * @param sellPermissions
	 * @param sellPoliticals
	 * @param buyCoins
	 * @param buyAssistants
	 * @param buyPermissions
	 * @param buyPoliticals
	 * @throws IllegalArgumentException if one of the int parameters is <0
	 * @throws NullPointerException if one of the other parameters is null
	 */
	public DTOSellAction(DTOCoins sellCoins, DTOAssistants sellAssistants, Set<DTOPermissionCardSelection> sellPermissions, DTOPoliticalContainer sellPoliticals,
			DTOCoins buyCoins, DTOAssistants buyAssistants, Set<DTOPermissionCardSelection> buyPermissions, DTOPoliticalContainer buyPoliticals) {
		if(sellCoins.getQuantity()<0 || sellAssistants.getQuantity()<0 || buyCoins.getQuantity()<0 || buyAssistants.getQuantity()<0) {
			throw new IllegalArgumentException("int parameters must all be >=0"); 
		}
		if(sellPermissions==null || sellPoliticals==null || buyPermissions==null || buyPoliticals==null) {
			throw new NullPointerException("the other parameters cannot be null"); 
		}
		this.sellCoins=sellCoins;
		this.sellAssistants=sellAssistants;
		this.sellPermissions=sellPermissions;
		this.sellPoliticals=sellPoliticals;
		
		this.buyCoins=buyCoins;
		this.buyAssistants=buyAssistants;
		this.buyPermissions=buyPermissions;
		this.buyPoliticals=buyPoliticals;
	}

	/**
	 * 
	 * @return buyCoins
	 */
	public DTOCoins getBuyCoins() {
		return buyCoins;
	}

	/**
	 * 
	 * @return sellCoins
	 */
	public DTOCoins getSellCoins() {
		return sellCoins;
	}

	/**
	 * 
	 * @return buyAssistants
	 */
	public DTOAssistants getBuyAssistants() {
		return buyAssistants;
	}

	/**
	 * 
	 * @return sellAssistants
	 */
	public DTOAssistants getSellAssistants() {
		return sellAssistants;
	}

	/**
	 * 
	 * @return sellPermissions
	 */
	public Set<DTOPermissionCardSelection> getSellPermissions() {
		return sellPermissions;
	}

	/**
	 * 
	 * @return buyPermissions
	 */
	public Set<DTOPermissionCardSelection> getBuyPermissions() {
		return buyPermissions;
	}

	/**
	 * 
	 * @return buyPoliticals
	 */
	public DTOPoliticalContainer getBuyPoliticals() {
		return buyPoliticals;
	}

	/**
	 * 
	 * @return sellPoliticals
	 */
	public DTOPoliticalContainer getSellPoliticals() {
		return sellPoliticals;
	}

	@Override
	public SellAction accept(VisitorActions v, Player player) {
		return v.visit(this, player);
	}
}
