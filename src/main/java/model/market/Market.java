/**
 * 
 */
package model.market;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import model.player.Player;

/**
 * @author Riccardo Pressiani
 *
 */
public class Market {
	
	private Set<Contract> contractSet;
	
	public Market(){
		this.contractSet = new HashSet<Contract>();
	}
	
	/**
	 * @param contract
	 * adds a contract to contractSet
	 */
	public void addContract(Contract contract){
		contractSet.add(contract);
	}
	
	/**
	 * @param contract
	 * @param buyer
	 */
	public void acceptContract(Contract contract, Player buyer){
		Iterator<Marketable> sellBagItr = contract.getSellBag().iterator();
		while(sellBagItr.hasNext()){
			sellBagItr.next().makeExchange(contract.getSeller(), buyer);
		}
		Iterator<Marketable> buyBagItr = contract.getBuyBag().iterator();
		while(buyBagItr.hasNext()){
			buyBagItr.next().makeExchange(buyer, contract.getSeller());
		}
	}

}
