package model.stateMachine;

import model.GameState;
import model.changes.ChangeMsg;
import model.player.Player;

public class FinishedBuildingState implements State {
	
	@Override
	public void checkTurn(Player player, GameState gameState){
		player.getView().stopTimer();
		gameState.nextPlayer(player);
		gameState.getCurrentPlayer().getView().startTimer();
		gameState.notifyObserver(new ChangeMsg("Now it's time for "+gameState.getCurrentPlayer().getNickname()+" to play"));
	}
}
