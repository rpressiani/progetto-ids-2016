package server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import model.player.Player;
import view.socket.ServerSocketView;

public class MatchCreator implements Runnable {
	
	private Map<Player, ServerSocketView> tmpViewSocket;
	private Queue<Player> enabledPlayers;
	
	private final int pauseTime = 5000;
	private final int matchReadyPauseTime = 20000;
	private static int counter = 0;
	private Set<Match> runningMatches;
	
	/**
	 * 
	 * @param tmpViewSocket
	 */
	public MatchCreator(Map<Player, ServerSocketView> tmpViewSocket) {
		if(tmpViewSocket==null){
			throw new NullPointerException("tmpViewSocket can't be null");
		}
		
		this.runningMatches = new HashSet<Match>();
		this.tmpViewSocket = tmpViewSocket;
		this.enabledPlayers = new LinkedList<Player>();
	}
	
	/**
	 * find the players enabled
	 */
	private void findEnabledPlayers(){
		
		for (Map.Entry<Player, ServerSocketView> entry : tmpViewSocket.entrySet()) {
			if (entry.getValue().isEnabled()) {
				Player player = entry.getValue().getPlayer();
				if (!this.enabledPlayers.contains(player)) {
					this.enabledPlayers.add(player);	
				}
			}
		}
	}

	@Override
	public void run() {
		System.out.println("[MATCH CREATOR] Start MatchCreator");
		
		while (true) {
			
			try {
				Thread.sleep(this.pauseTime);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			StringBuilder log = new StringBuilder();
			log.append("\n[MATCH CREATOR] Trying to create a match... (" + counter++ + ")\n");
			log.append("[MATCH CREATOR] Lobby status: \n");
			log.append("[MATCH CREATOR] There are " + this.enabledPlayers.size() + " players enabled\n");
			log.append("[MATCH CREATOR] There are " + this.tmpViewSocket.size() + " players connected in the lobby\n");
			log.append("[MATCH CREATOR] There are " + this.runningMatches.size() + " matches running\n");
//			System.out.println(log);
			
			try {
				
				this.findEnabledPlayers();
				
				if (this.enabledPlayers.size() >= 2) {
					
					System.out.println("[MATCH CREATOR] New match starting in " + this.matchReadyPauseTime/1000 + " seconds");
					Thread.sleep(this.matchReadyPauseTime);
					
					this.findEnabledPlayers();

					ArrayList<Player> matchPlayers = new ArrayList<Player>();
					
					for (Player player : this.enabledPlayers) {
						matchPlayers.add(player);
					}
					
					this.runningMatches.add(new Match(matchPlayers, this.tmpViewSocket));
					
					for (Iterator<Player> iterator = matchPlayers.iterator(); iterator.hasNext();) {
						Player playerToRemove =iterator.next();
						this.enabledPlayers.remove(playerToRemove);
						
						if (tmpViewSocket.containsKey(playerToRemove)) {
							this.tmpViewSocket.remove(playerToRemove, this.tmpViewSocket.get(playerToRemove));
						}
					}
					
					System.out.println("[MATCH CREATOR] New match started with " + matchPlayers.size() + " players");
				}
				
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
}
