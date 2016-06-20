package model.bonusItem;

import model.GameState;
import model.changes.ChangeMsg;
import model.player.Player;

public class BonusAgainPermission implements BonusInputItem {

	@Override
	public void giveBonus(Player player, GameState gameState) {
		player.getBonusInputs().add(this);
		gameState.notifyObserver(player, new ChangeMsg("Congratulations, you can get bonuses of a permission card you already have"));
	}
}
