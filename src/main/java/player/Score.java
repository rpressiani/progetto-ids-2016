package player;

/**
 * @author Riccardo Pressiani
 *
 */
public class Score extends SimpleItem {
	
	/**
	 * Constructor
	 * Call SimpleItem constructor
	 */
	public Score(){
		super();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Score [items=" + items + "]";
	}

}
