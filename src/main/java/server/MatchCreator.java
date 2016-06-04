package server;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import javax.print.DocFlavor.STRING;

import controller.Controller;
import model.GameState;
import model.player.Player;
import parser.Parser;
import view.ServerSocketView;

public class MatchCreator implements Runnable {
	
	private Map<Player, ServerSocketView> tmpViewSocket;
	private Queue<Player> players;
	
	private GameState gameState; 
	private Controller controller;
	private Parser parser;
	
	private final int pauseTime = 5000;
	private static int counter = 0;
	
	public MatchCreator(Map<Player, ServerSocketView> tmpViewSocket) {
		 this.tmpViewSocket = tmpViewSocket;
		 this.players = new LinkedList<Player>();
		 this.parser = new Parser();
		
	}

	@Override
	public void run() {
		System.out.println("[MATCH CREATOR] Start MatchCreator");
		
		while (true) {
			StringBuilder log = new StringBuilder();
			log.append("\n[MATCH CREATOR] Trying to create a match... (" + counter++ + ")\n");
			log.append("[MATCH CREATOR] Lobby status: ");
			log.append("[MATCH CREATOR] There are " + this.players.size() + " players enabled\n");
			log.append("[MATCH CREATOR] There are " + this.tmpViewSocket.size() + " players connected\n");
			System.out.println(log);
			
			try {
				
				Thread.sleep(this.pauseTime);
				
//				System.out.println(this.players.size());
//				System.out.println(this.tmpViewSocket.size());
//				System.out.println(players);
				for (Map.Entry<Player, ServerSocketView> entry : tmpViewSocket.entrySet()) {
					if (entry.getValue().isEnabled()) {
						Player player = entry.getValue().getPlayer();
						if (!this.players.contains(player)) {
							this.players.add(player);	
						}
					}
				}
				
				if (this.players.size() >= 2) {
//					System.out.println(">=2");
					
					int k = 0;
					ArrayList<Player> matchPlayers = new ArrayList<Player>();
					
					for (Player player : this.players) {
						matchPlayers.add(player);
					}
					
					
					this.gameState = new GameState(this.parser, matchPlayers);
					this.controller = new Controller(this.gameState);
					
					System.out.println(this.gameState.getCounsellorGarbage().toString());
					
					for (Map.Entry<Player, ServerSocketView> entry : tmpViewSocket.entrySet()) {
						if (entry.getValue().isEnabled()) {
							entry.getValue().getPlayer().initPlayer(this.gameState.getPoliticalDeck(), k, this.parser);
							k++;
							entry.getValue().initServerSocketView(this.gameState);
							this.gameState.registerObserver(entry.getValue());
							entry.getValue().registerObserver(this.controller);
						}
					}
					
					for (Iterator<Player> iterator = matchPlayers.iterator(); iterator.hasNext();) {
						Player playerToRemove =iterator.next();
						this.players.remove(playerToRemove);
//						System.out.println("r1: " + r1);
//						System.out.println("players: "+players.size());
						
						if (tmpViewSocket.containsKey(playerToRemove)) {
							this.tmpViewSocket.remove(playerToRemove, this.tmpViewSocket.get(playerToRemove));
//							System.out.println("r2: " + r2);
//							System.out.println("tmpMap: "+ this.tmpViewSocket.size());
						}
						
					}
					
					k = 0;
					System.out.println("[MATCH CREATOR] New match started with " + matchPlayers.size() + " players");
				}
				
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
