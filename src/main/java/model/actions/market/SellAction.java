package model.actions.market;

import java.util.Set;

import model.GameState;
import model.actions.GeneralAction;
import model.bonusable.PermissionCard;
import model.changes.ChangeMsg;
import model.market.Contract;
import model.player.Assistants;
import model.player.Coins;
import model.player.Player;
import model.politicalDeck.PoliticalContainer;

public class SellAction implements GeneralAction {

	private Coins sellCoins, buyCoins;
	private Assistants sellAssistants, buyAssistants;
	private Set<PermissionCard> sellPermissions, buyPermissions;
	private PoliticalContainer sellPoliticals, buyPoliticals;
	
	/**
	 * Constructor
	 */
	public SellAction(){
		
	}
	
	
	/**
	 * Constructor
	 * @param sellCoins
	 * @param sellAssistants
	 * @param sellPermissions
	 * @param sellPoliticals
	 * @param buyCoins
	 * @param buyAssistants
	 * @param buyPermissions
	 * @param buyPoliticals
	 */
	public SellAction(Coins sellCoins, Assistants sellAssistants, Set<PermissionCard> sellPermissions, PoliticalContainer sellPoliticals,
			Coins buyCoins, Assistants buyAssistants, Set<PermissionCard> buyPermissions, PoliticalContainer buyPoliticals){
		this.sellCoins=sellCoins;
		this.sellAssistants=sellAssistants;
		this.sellPermissions=sellPermissions;
		this.sellPoliticals=sellPoliticals;
		
		this.buyCoins=buyCoins;
		this.buyAssistants=buyAssistants;
		this.buyPermissions=buyPermissions;
		this.buyPoliticals=buyPoliticals;
	}
	
	@Override
	public void doAction(Player player, GameState gameState) {
		
		Contract contract=new Contract(player);
		
		contract.sellCoins(sellCoins.getItems());
		contract.sellAssistants(sellAssistants.getItems());
		for(PermissionCard card : sellPermissions){
			contract.sellPermissionCard(card);
		}
		contract.sellPoliticalCards(sellPoliticals);
		
		contract.buyCoins(buyCoins.getItems());
		contract.buyAssistants(buyAssistants.getItems());
		for(PermissionCard card : buyPermissions){
			contract.buyPermissionCard(card);
		}
		contract.buyPoliticalCards(buyPoliticals);
		
		gameState.getMarket().addContract(contract);
		
		gameState.notifyObserver(player, new ChangeMsg("You successfully put a contract in the market"));
		gameState.notifyAllExceptPlayer(player, new ChangeMsg(player.getNickname()+" put a contract in the market"));
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		
		if(sellCoins.getItems()<0 || buyCoins.getItems()<0 || sellAssistants.getItems()<0 || buyAssistants.getItems()<0){
			gameState.notifyObserver(player, new ChangeMsg("You can't put negative quantity of things to sell or buy in the contract"));
			return false;
		}
		
		if(player.getCoins().getItems()<sellCoins.getItems()){
			gameState.notifyObserver(player, new ChangeMsg("You don't have enough coins to make this contract"));
			return false;
		}
		
		if(player.getAssistants().getItems()<sellAssistants.getItems()){
			gameState.notifyObserver(player, new ChangeMsg("You don't have enough assistants to make this contract"));
			return false;
		}
		
		for(PermissionCard c : sellPermissions){
			if(c==null){
				gameState.notifyObserver(player, new ChangeMsg("One or more permission cards you want to sell don't exist or you don't have them"));
				return false;
			}
		}
		
		for(PermissionCard c : buyPermissions){
			if(c==null){
				gameState.notifyObserver(player, new ChangeMsg("One or more permission cards you want to buy don't exist or other players don't have them"));
				return false;
			}
		}
		
		if(this.sellPoliticals.getDeck().get(0).getNumCards() == -1 || this.buyPoliticals.getDeck().get(0).getNumCards() == -1) {
			gameState.notifyObserver(player, new ChangeMsg("Type 'help' to check the correct card proposal structure"));
			return false;
		}
		
		for(int i=0; i<player.getPoliticalHand().getDeck().size(); i++){
			if(player.getPoliticalHand().getDeck().get(i).getNumCards()<this.sellPoliticals.getDeck().get(i).getNumCards()){
				gameState.notifyObserver(player, new ChangeMsg("You don't have enough political cards to make this contract"));
				return false;
			}
		}
		
		return true;
	}

}
