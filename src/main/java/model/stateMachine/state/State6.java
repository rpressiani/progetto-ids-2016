package model.stateMachine.state;

import model.player.Player;

public class State6 implements State {

	@Override
	public void printOut(Player player, State state) {
		System.out.println(player.getNickname()+": "+"State6");
	}

}
