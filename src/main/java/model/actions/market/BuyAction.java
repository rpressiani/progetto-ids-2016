package model.actions.market;

import model.GameState;
import model.actions.GeneralAction;
import model.bonusable.PermissionCard;
import model.changes.ChangeMsg;
import model.changes.ChangePlayerStatus;
import model.market.Contract;
import model.market.Marketable;
import model.player.Assistants;
import model.player.Coins;
import model.player.Player;
import model.politicalDeck.PoliticalContainer;

public class BuyAction implements GeneralAction {

	private Contract contract;
	
	/**
	 * Constructor
	 * @param contract
	 */
	public BuyAction(Contract contract) {
		this.contract=contract;
	}
	
	@Override
	public void doAction(Player player, GameState gameState) {
		gameState.getMarket().acceptContract(contract, player);
		gameState.notifyObserver(contract.getSeller(), new ChangeMsg(player.getNickname()+" accepted your contract"));
		gameState.notifyAllExceptPlayer(contract.getSeller(), new ChangeMsg(player.getNickname()+" accepted a contract from "+contract.getSeller().getNickname()));
		gameState.notifyObserver(player, new ChangePlayerStatus(player));
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {

		if(player.equals(contract.getSeller())){
			gameState.notifyObserver(player, new ChangeMsg("You can't buy your own contract"));
			return false;
		}
		
		if(contract==null){
			gameState.notifyObserver(player, new ChangeMsg(player.getNickname()+", the player you want to buy from has no contracts in the market or someone already accepted his contract"));
			return false;
		}
		
		Coins coins=null;
		for(Marketable m : contract.getBuyBag()){
			if(m instanceof Coins){
				coins=(Coins) m;
			}
		}
		if(coins==null) throw new NullPointerException();
		else {
			if(player.getCoins().getItems()<coins.getItems()){
				gameState.notifyObserver(player, new ChangeMsg("You don't have enough coins to accept this contract"));
				return false;
			}
		}
		
		Assistants assistants = null;
		for(Marketable m : contract.getBuyBag()){
			if(m instanceof Assistants){
				assistants=(Assistants) m;
			}
		}
		if(assistants==null) throw new NullPointerException();
		else{	
			if(player.getAssistants().getItems()<assistants.getItems()){
				gameState.notifyObserver(player, new ChangeMsg("You don't have enough assistants to accept this contract"));
				return false;
			}
		}
		
		PoliticalContainer proposal=null;
		for(Marketable m : contract.getBuyBag()){
			if(m instanceof PoliticalContainer){
				proposal=(PoliticalContainer) m;
			}
		}
		if(proposal==null) throw new NullPointerException();
		else{
			for(int i=0; i<player.getPoliticalHand().getDeck().size(); i++){
				if(player.getPoliticalHand().getDeck().get(i).getNumCards()<proposal.getDeck().get(i).getNumCards()){
					gameState.notifyObserver(player, new ChangeMsg("You don't have enough political cards to accept this contract"));
					return false;
				}
			}
		}
		
		for(Marketable m : contract.getBuyBag()){
			if(m instanceof PermissionCard){
				PermissionCard card=(PermissionCard) m;
				
				if(!player.getPermissionHand().contains(card)){
					gameState.notifyObserver(player, new ChangeMsg("You don't have enough permission cards to accept this contract"));
					return false;
				}
			}
				
		}

		return true;
	}

}
