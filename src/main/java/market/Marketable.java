/**
 * 
 */
package market;

import player.Player;

/**
 * @author Riccardo Pressiani
 *
 */
public interface Marketable {
	
	public void makeExchange(Player fromPlayer, Player toPlayer);
	public boolean verifyAdd(Player player);

}
