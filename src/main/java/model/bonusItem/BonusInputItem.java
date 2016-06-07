package model.bonusItem;

import model.GameState;
import model.player.Player;
import model.stateMachine.state.CanMainState;
import model.stateMachine.state.CanQuickOrNullState;
import model.stateMachine.state.CanSellState;
import model.stateMachine.state.State;

public abstract class BonusInputItem implements BonusItem {

	@Override
	public void giveBonus(Player player, GameState gameState) {
		State state=player.getState();
		
		if(state instanceof CanMainState){
			((CanMainState) state).setIntpuBonusRequired(true);
		}
		
		if(state instanceof CanQuickOrNullState){
			((CanQuickOrNullState) state).setInputBonusRequired(true);
		}
		
		if(state instanceof CanSellState){
			((CanSellState) state).setInputBonusRequired(true);
		}
	}

}
