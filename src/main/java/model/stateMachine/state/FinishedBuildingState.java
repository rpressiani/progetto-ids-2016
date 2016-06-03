package model.stateMachine.state;

import model.player.Player;

public class FinishedBuildingState implements State {

	@Override
	public void printOut(Player player, State state) {
		System.out.println(player.getNickname()+": "+"State6");
	}

}
