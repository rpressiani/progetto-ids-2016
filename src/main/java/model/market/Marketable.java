/**
 * 
 */
package model.market;

import model.player.Player;

/**
 * @author Riccardo Pressiani
 *
 */
public interface Marketable {
	
	public void makeExchange(Player fromPlayer, Player toPlayer);

}
