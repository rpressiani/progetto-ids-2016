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
	
	public void makeExchange(Marketable m, Player fromPlayer, Player toPlayer);

}
