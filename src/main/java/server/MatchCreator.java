package server;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import model.player.Player;
import view.rmi.RMIView;
import view.socket.ServerSocketView;

public class MatchCreator implements Runnable {

	private Map<Player, ServerSocketView> tmpViewSocket;
	private Map<Player, RMIView> tmpViewRMI;
	private Map<Player, Match> playerMatch;
	private Queue<Player> enabledPlayers;
	
	private final int pauseTime = 5000;
	private final int matchReadyPauseTime = 5000;
	private static int counter = 0;
	private Set<Match> runningMatches;
	
	/**
	 * MatchCreator constructor
	 * Creates new matches based on players connected and enabled
	 * 
	 * @param tmpViewSocket		map of players connected via socket
	 * @param tmpViewRMI		map of players connected via RMI
	 * @param playerMatch		map of players that have joined a match with that match as value
	 * @param runningMatches	set of matches running
	 */
	public MatchCreator(Map<Player, ServerSocketView> tmpViewSocket, Map<Player, RMIView> tmpViewRMI,
			Map<Player, Match> playerMatch, Set<Match> runningMatches) {
		if(tmpViewSocket==null){
			throw new NullPointerException("tmpViewSocket can't be null");
		}
		
		this.runningMatches = runningMatches;
		this.tmpViewSocket = tmpViewSocket;
		this.tmpViewRMI = tmpViewRMI;
		this.playerMatch = playerMatch;
		this.enabledPlayers = new LinkedList<Player>();
	}
	
	/**
	 * find the players enabled
	 */
	private void findEnabledPlayers(){
		
		for (Map.Entry<Player, ServerSocketView> entry : tmpViewSocket.entrySet()) {
			if (entry.getValue().isEnabled()) {
				Player player = entry.getKey();
				if (!this.enabledPlayers.contains(player)) {
					this.enabledPlayers.add(player);	
				}
			}
		}
		
		for (Map.Entry<Player, RMIView> entry : tmpViewRMI.entrySet()) {
			if (entry.getKey().isEnabled()) {
				Player player = entry.getKey();
				if (!this.enabledPlayers.contains(player)) {
					this.enabledPlayers.add(player);	
				}
			}
		}
	}
	
	/**
	 * @return the enabledPlayers
	 */
	public Queue<Player> getEnabledPlayers() {
		return enabledPlayers;
	}

	/**
	 * Check every this.pauseTime is there are enough players connected and enabled to start a new match
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.println("[MATCH CREATOR] Start MatchCreator");
		
		while (true) {
			
			try {
				Thread.sleep(this.pauseTime);
			} catch (InterruptedException e1) {
				
				System.out.println("Match creator closed!");
				break;
			}
			
			try {
				
				this.findEnabledPlayers();
				
				StringBuilder log = new StringBuilder();
				log.append("\n[MATCH CREATOR] Trying to create a match... (" + counter++ + ")\n");
				log.append("[MATCH CREATOR] Lobby status: \n");
				log.append("[MATCH CREATOR] There are " + this.enabledPlayers.size() + " players enabled\n");
				int playersInLobby = this.tmpViewSocket.size() + this.tmpViewRMI.size();
				log.append("[MATCH CREATOR] There are " + playersInLobby + " players connected in the lobby\n");
				log.append("[MATCH CREATOR] There are " + this.runningMatches.size() + " matches running\n");
				System.out.println(log);
				
				if (this.enabledPlayers.size() >= 2) {
					
					System.out.println("[MATCH CREATOR] New match starting in " + this.matchReadyPauseTime/1000 + " seconds");
					Thread.sleep(this.matchReadyPauseTime);
					
					this.findEnabledPlayers();

					ArrayList<Player> matchPlayers = new ArrayList<Player>();
					
					for (Player player : this.enabledPlayers) {
						matchPlayers.add(player);
					}
					
					Match match = new Match(matchPlayers, this.tmpViewSocket, this.tmpViewRMI);
					this.runningMatches.add(match);
					
					
					for (Iterator<Player> iterator = matchPlayers.iterator(); iterator.hasNext();) {
						Player playerToRemove =iterator.next();
						playerMatch.put(playerToRemove, match);
						this.enabledPlayers.remove(playerToRemove);
						
						if (tmpViewSocket.containsKey(playerToRemove)) {
							this.tmpViewSocket.remove(playerToRemove, this.tmpViewSocket.get(playerToRemove));
						} else if (tmpViewRMI.containsKey(playerToRemove)){
							this.tmpViewRMI.remove(playerToRemove, this.tmpViewRMI.get(playerToRemove));
						} else {
							throw new IllegalArgumentException("[CRITICAL] Player not found");
						}
						
						System.out.println("STATUS tmpSocket"+this.tmpViewSocket);
						System.out.println("STATUS tmpRMI"+this.tmpViewRMI);
					}
					
					System.out.println("[MATCH CREATOR] New match started with " + matchPlayers.size() + " players");
				}
				
			} catch (IOException | InterruptedException | AlreadyBoundException | NotBoundException e) {
				System.out.println("Match creator closed!");
				break;
			}
			
		}

	}
}
