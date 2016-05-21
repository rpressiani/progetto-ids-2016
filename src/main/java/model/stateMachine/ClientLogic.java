package model.stateMachine;

import java.util.ArrayList;

import model.GameState;
import model.actions.BuyPermissionCard;
import model.actions.HireAssistant;
import model.actions.MainAction;
//import model.actions.NullAction;
import model.actions.QuickAction;
import model.player.Player;
import model.sharedObjects.Nobility;
import model.stateMachine.state.State1;
import parser.Parser;

public class ClientLogic {

	public static void main(String[] args) {
		Parser parser = new Parser();

		ArrayList<Player> players=new ArrayList<Player>();
		
		MainAction action1= new BuyPermissionCard();
		QuickAction action2= new HireAssistant();
//		NullAction action3 = new NullAction();
		
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
		
//		gameState.setPlayers(players);
		gameState.setCurrentPlayer(player1);

		player1.getState().printOut(player1, player1.getState());
		
		player1.move(action1, gameState);
		player1.getState().printOut(player1, player1.getState());
		
		player2.move(action1, gameState);
		player2.getState().printOut(player2, player2.getState());
		
		player1.move(action2, gameState);
		player1.getState().printOut(player1, player1.getState());
		
		player1.getState().checkTurn(player1, gameState);
		System.out.println("Current player: " + gameState.getCurrentPlayer().getNickname());
		
		player2.move(action1, gameState);
		player2.getState().printOut(player2, player2.getState());
	}

	

}
