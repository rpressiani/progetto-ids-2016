package model.bonusItem;

import model.GameState;
import model.changes.ChangeMsg;
import model.player.Player;

public class BonusToken implements BonusInputItem {

	private int tokenToChoose;
	
	public BonusToken(int tokenToChoose){
		this.tokenToChoose=tokenToChoose;
	}

	@Override
	public void giveBonus(Player player, GameState gameState) {
		player.getBonusInputs().add(this);
		gameState.notifyObserver(player, new ChangeMsg("Congratulations, you can get bonuses of "+tokenToChoose+" token among cities you have built an emporium in"));
	}
	
	public int getTokenToChoose() {
		return tokenToChoose;
	}

}
