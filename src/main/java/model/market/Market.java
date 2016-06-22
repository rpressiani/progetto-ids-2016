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
	 * @return the set of contracts
	 */
	public Set<Contract> getContractSet() {
		return contractSet; 
	}
	/**
	 * @param contract
	 * adds a contract to contractSet
	 * @throws NullPointerException is contract is null
	 */
	public void addContract(Contract contract){
		if(contract==null) {
			throw new NullPointerException("cannot have a null contract"); 
		}
		contractSet.add(contract);
	}
	
	/**
	 * @param contract
	 * @param buyer
	 * @throws NullPointerException if contract or player is null
	 */
	public void acceptContract(Contract contract, Player buyer){
		if(contract==null) {
			throw new NullPointerException("contract cannot be null, if created"); 
		}
		if(buyer==null) {
			throw new NullPointerException("buyer cannot be null"); 
		}
		
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
