/**
 * 
 */
package dto;

import model.GameState;

/**
 * @author Riccardo Pressiani
 *
 */
public interface DTOAction extends DTOObject{
	
	public void perform(GameState game);

}
