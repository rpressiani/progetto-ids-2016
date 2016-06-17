package model.bonusItem;

import model.GameState;
import model.player.Player;

public interface BonusInputItem extends BonusItem {

	@Override
	public default void giveBonus(Player player, GameState gameState) {
		player.getBonusInputs().add(this);
	}

}
