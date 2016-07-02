package gui;

import model.GameState;

public class MainGameController {

	private GameState gameState; 
	
	public MainGameController(GameState gameState) {
		this.gameState = gameState; 
	}
	public GameState getGameState() {
		return gameState; 
	}
}
