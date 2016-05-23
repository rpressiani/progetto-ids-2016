/**
 * 
 */
package model.query;

import java.io.Serializable;

import model.GameState;
import model.player.Player;

/**
 * @author Riccardo Pressiani
 * @param <O>
 *
 */
public abstract class Query<O> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3051367294284780248L;
	
	public abstract O perform(Player player, GameState game);

}
