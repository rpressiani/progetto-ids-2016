package model.stateMachine;

import java.util.ArrayList;

import model.GameState;
import model.actions.GeneralAction;
import model.actions.NullAction;
import model.actions.main.BuyPermissionCard;
import model.actions.main.MainAction;
import model.actions.market.BuyAction;
import model.actions.market.SellAction;
import model.actions.quick.HireAssistant;
import model.actions.quick.QuickAction;
import model.player.Player;
import model.stateMachine.state.State1;
import parser.Parser;
import utilities.Color;

public class ClientLogic {

	public static void main(String[] args) {
		//Parser parser = new Parser();

		ArrayList<Player> players=new ArrayList<Player>();
		
		GeneralAction action1= new BuyPermissionCard();
		GeneralAction action2= new HireAssistant();
		GeneralAction action3= new NullAction();
		GeneralAction action4= new SellAction();
		GeneralAction action5= new BuyAction();
		
		Player player1=new Player("player1", new Color("Rosso"));
		Player player2=new Player("player2", new Color("Rosso"));
		Player player3=new Player("player3", new Color("Rosso"));
		Player player4=new Player("player4", new Color("Rosso"));
		
		player1.setState(new State1());
		player2.setState(new State1());
		player3.setState(new State1());
		player4.setState(new State1());

		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);
		
		//GameState gameState= new GameState(parser, players);
		GameState gameState= new GameState(players);
		
		player1.move(action1, gameState);
		
		player2.move(action1, gameState);
		
		player1.move(action3, gameState);
	
		player1.move(action1, gameState);
		
		player2.move(action1, gameState);
		
		player2.move(action2, gameState);
		
		player3.move(action1, gameState);
		
		player3.move(action2, gameState);
		
		player2.move(action2, gameState);
		
		player4.move(action2, gameState);
		
		player4.move(action1, gameState);
		
		System.out.println("MARKET STARTED");
		
		player1.move(action4, gameState);
	
		player2.move(action4, gameState);
		
		player3.move(action4, gameState);
		
		player4.move(action4, gameState);

		System.out.println("ALL SOLD ITEMS");

		player1.move(action5, gameState);
		
		player2.move(action5, gameState);
		
		player3.move(action5, gameState);
		
		player4.move(action5, gameState);
		
		System.out.println("MARKET FINISHED");
		
	}

}
