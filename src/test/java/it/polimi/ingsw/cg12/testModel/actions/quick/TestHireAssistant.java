package it.polimi.ingsw.cg12.testModel.actions.quick;

/*public class TestHireAssistant {

	@Test
	public void testHireAssistantsWorks() {
		Parser parser = new Parser(); 
		GarbageState garbageState = new GarbageState(parser);
		Player player = new Player();
		player.setNickname("Ciro");
		player.setColor(new Color("blue"));
		Player player2 = new Player();
		player2.setNickname("Ivo");
		player2.setColor(new Color("red"));
		Player player3 = new Player();
		player3.setNickname("Enzo");
		player3.setColor(new Color("black"));
		Player player4 = new Player();
		player4.setNickname("Sergio");
		player4.setColor(new Color("white"));
		PoliticalGarbage garbage = new PoliticalGarbage(parser); 
		PoliticalRealDeck deck = new PoliticalRealDeck(parser, garbage);
		int id=0; 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		for(Player p : players) {
			p.initPlayer(deck, id, parser);
			id++; 
		}
		GameState gameState = new GameState(parser, players); 
		HireAssistant action = new HireAssistant();
		Integer tempCoins = player.getCoins().getItems(); 
		Integer tempAssistants = player.getAssistants().getItems(); 
		action.doAction(player, gameState);
		assertTrue(tempCoins!=player.getCoins().getItems() && tempAssistants!=player.getAssistants().getItems()); 
		
		
	}

}*/
