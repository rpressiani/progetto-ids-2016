package server;

import model.GameState;

public class CheckDisconnections implements Runnable {

	private GameState gameState;
	
	public CheckDisconnections(GameState gameState) {
		this.gameState=gameState;
	}
	
	@Override
	public void run() {
		while(true){
			if(gameState.getPlayers().size()==1){
				gameState.finishMatch();
				break;
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

	}

}
