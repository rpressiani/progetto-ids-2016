package model.stateMachine;

import java.util.ArrayList;

import model.GameState;
import model.actions.BuyAction;
import model.actions.BuyPermissionCard;
import model.actions.GeneralAction;
import model.actions.HireAssistant;
import model.actions.MainAction;
import model.actions.NullAction;
import model.actions.QuickAction;
import model.actions.SellAction;
import model.player.Player;
import model.stateMachine.state.State1;
import parser.Parser;

public class ClientLogic {

	public static void main(String[] args) {
		Parser parser = new Parser();

		ArrayList<Player> players=new ArrayList<Player>();
		
		GeneralAction action1= new BuyPermissionCard();
		GeneralAction action2= new HireAssistant();
		GeneralAction action3= new NullAction();
		GeneralAction action4= new SellAction();
		GeneralAction action5= new BuyAction();
		
		Player player1=new Player("player1", null);
		Player player2=new Player("player2", null);
		Player player3=new Player("player3", null);
		Player player4=new Player("player4", null);
		
		player1.setState(new State1());
		player2.setState(new State1());
		player3.setState(new State1());
		player4.setState(new State1());

		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);
		
		GameState gameState= new GameState(parser, players);

		player1.printState();
		
		player1.move(action1, gameState);
		player1.printState();
		
		player2.move(action1, gameState);
		player2.printState();
		
		player1.move(action3, gameState);
		player1.printState();
		
		System.out.println("Current player: " + gameState.getCurrentPlayer().getNickname());
		
		player1.move(action1, gameState);
		player1.printState();
		
		/*player2.move(action1, gameState);
		player2.printState();
		
		System.out.println("Current player: " + gameState.getCurrentPlayer().getNickname());
		
		player3.move(action1, gameState);
		player3.printState();
		
		player3.move(action2, gameState);
		player3.printState();
		
		System.out.println("Current player: " + gameState.getCurrentPlayer().getNickname());*/
	}

}
