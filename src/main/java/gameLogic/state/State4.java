package gameLogic.state;

import player.Player;

public class State4 implements State {
	
	@Override
	public void printOut(Player player, State state){
		System.out.println(player.getNickname()+": "+"State4");
	}
}
