package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import model.changes.ChangeMsg;
import model.player.Player;
import view.rmi.RMIView;
import view.socket.ServerSocketView;

public class Server {
	
	private final static int PORT = 29999; //load from file!
	private final static int RMI_PORT = 29998;
	private final String NAME = "co4";
	
	private static Map<Player, ServerSocketView> tmpViewSocket = new HashMap<Player, ServerSocketView>();
	private static Map<Player, RMIView> tmpViewRMI = new HashMap<Player, RMIView>();
	private static Map<Player, Match> playerMatch = new HashMap<Player, Match>();
	
	private ExecutorService matchExecutor;
	
	private static Set<Match> runningMatches = new HashSet<Match>();
	
	private boolean running = false;

	private ServerSocket serverSocket;
	
	private static MatchCreator matchCreator;
	
	/**
	 * start the socket
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void startSocket() throws IOException, ClassNotFoundException {
		ExecutorService viewExecutor = Executors.newCachedThreadPool(); 
		
		this.serverSocket = new ServerSocket(PORT); 
		System.out.println("SERVER SOCKET READY ON PORT: " + PORT);
		
		while(this.isRunning()) {
			try {
				Socket socket = serverSocket.accept();
				ServerSocketView view = new ServerSocketView(socket, this);
				viewExecutor.submit(view);
				tmpViewSocket.put(view.getPlayer(), view);
			} catch (SocketException e) {
				System.out.println("ServerSocket closed!");
			}
			
			System.out.println("NEW CLIENT_SOCKET ACCEPTED");
		}
	}
	
	/**
	 * Starts RMI server and allows RMI connections
	 * 
	 * @throws RemoteException
	 * @throws AlreadyBoundException
	 */
	private void startRMI() throws RemoteException, AlreadyBoundException{
		Registry registry = LocateRegistry.createRegistry(RMI_PORT);
		System.out.println("Constructing the RMI registry");
		RMIServer serverRMI=new RMIServer(tmpViewRMI, this);
		System.out.println("RMIVIEW SERVER: " + serverRMI);
		RMIServerInterface serverView=(RMIServerInterface) UnicastRemoteObject.exportObject(serverRMI, 0);
		System.out.println("Binding the server implementation to the registry");
		registry.bind(NAME, serverView);
	}
	
	/**
	 * Close and disconnect the server. MatchExecutor and serverSocket are now closed.
	 * 
	 * @throws IOException
	 */
	protected void closeServer() throws IOException{
		this.setRunning(false);
		this.matchExecutor.shutdownNow();
		this.serverSocket.close();
		System.out.println("\n !!! SERVER DISCONNECTED !!!\n");
	}
	
	/**
	 * Disconnect a player connected via RMI
	 * 
	 * @param player	player that has to be disconnected
	 */
	public void disconnectRMI(Player player){
		if (tmpViewRMI.containsKey(player)) {
			tmpViewRMI.remove(player);
			matchCreator.getEnabledPlayers().remove(player);
		}
		if (playerMatch.containsKey(player)) {
			
			if(playerMatch.get(player).getGameState().getPlayers().size()!=1){
				playerMatch.get(player).getGameState().nextPlayer(player);
			}
			
			ArrayList<Player> players = playerMatch.get(player).getGameState().getPlayers();
			int i;
			for (i = 0; i < players.size(); i++) {
				if (players.get(i).equals(player)) {
					break;
				}
			}
			players.remove(i);
			
			playerMatch.get(player).getGameState().getPlayersHashMap().remove(player);
			
			playerMatch.get(player).getGameState().getPlayersDisconnected().add(player);
			
			playerMatch.get(player).getPlayersRMI().get(player).unregisterObserver(player, playerMatch.get(player).getController());
			
			playerMatch.get(player).getGameState().unregisterObserver(player, playerMatch.get(player).getPlayersRMI().get(player));
			
			playerMatch.get(player).getGameState().notifyObserver(new ChangeMsg(player.getNickname()+ " has disconnected, hope you won't miss him/her too much!"));
			playerMatch.get(player).getGameState().notifyObserver(new ChangeMsg("Now it's time for " +playerMatch.get(player).getGameState().getCurrentPlayer().getNickname()+ " to play"));
			
			playerMatch.remove(player);
			
		}
		
		
	}
	

	/**
	 * Disconnect a player connected via socket
	 * 
	 * @param player	player that has to be disconnected
	 */
	public void disconnectSocket(Player player){
		if (tmpViewSocket.containsKey(player)) {
			tmpViewSocket.remove(player);
			matchCreator.getEnabledPlayers().remove(player);
		}
		if (playerMatch.containsKey(player)) {
			
			playerMatch.get(player).getGameState().nextPlayer(player);
			
			ArrayList<Player> players = playerMatch.get(player).getGameState().getPlayers();
			int i;
			for (i = 0; i < players.size(); i++) {
				if (players.get(i).equals(player)) {
					break;
				}
			}
			players.remove(i);
			
			playerMatch.get(player).getGameState().getPlayersHashMap().remove(player);
			
			playerMatch.get(player).getGameState().getPlayersDisconnected().add(player);
			
			playerMatch.get(player).getPlayersSocket().get(player).unregisterObserver(player, playerMatch.get(player).getController());
			
			playerMatch.get(player).getGameState().unregisterObserver(player, playerMatch.get(player).getPlayersSocket().get(player));

			playerMatch.get(player).getGameState().notifyObserver(new ChangeMsg(player.getNickname() + " has disconnected, hope you won't miss him/her too much!"));
			playerMatch.get(player).getGameState().notifyObserver(new ChangeMsg("Now it's time for " +playerMatch.get(player).getGameState().getCurrentPlayer().getNickname()+ " to play"));
			
			playerMatch.remove(player);
			
		}
	}
	
	/**
	 * @return the running
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * @param running the running to set
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}
	
	/**
	 * @return the runningMatches
	 */
	public static Set<Match> getRunningMatches() {
		return runningMatches;
	}

	/**
	 * Starts the server and the matchCreator
	 * 
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws AlreadyBoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, AlreadyBoundException {
		Server server = new Server();
		
		server.setRunning(true);
		
		matchCreator = new MatchCreator(tmpViewSocket, tmpViewRMI, playerMatch, runningMatches);
		ServerCloser closer = new ServerCloser(server);
		server.matchExecutor = Executors.newCachedThreadPool();
		server.matchExecutor.submit(matchCreator);
		server.matchExecutor.submit(closer);

		
		System.out.println("STARTING RMI");
		server.startRMI();
		
		System.out.println("STARTING SOCKET");
		server.startSocket();
	
	}

}