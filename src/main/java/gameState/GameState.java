package gameState;

import java.util.Set;

import council.Balcony;
import council.CounsellorGroup;
import council.GarbageState;
import map.Map;
import map.Region;
import politicalDeck.PoliticalGarbage;
import politicalDeck.PoliticalRealDeck;
import sharedObjects.Nobility;

public class GameState {
	private Map map;
	private Set<Region> regions;
	private Nobility nobility;
	private PoliticalRealDeck politicalDeck;
	private PoliticalGarbage garbage;
	private Balcony balcony;
	private CounsellorGroup counsellorGroup;
	private GarbageState counsellorGarbage;
	
	/**
	 * @return the map
	 */
	public Map getMap() {
		return map;
	}
	
	/**
	 * @return the regions
	 */
	public Set<Region> getRegions() {
		return regions;
	}
	
	/**
	 * @return the nobility
	 */
	public Nobility getNobility() {
		return nobility;
	}
	
	/**
	 * @return the politicalDeck
	 */
	public PoliticalRealDeck getPoliticalDeck() {
		return politicalDeck;
	}
	
	/**
	 * @return the garbage
	 */
	public PoliticalGarbage getGarbage() {
		return garbage;
	}
	
	/**
	 * @return the balcony
	 */
	public Balcony getBalcony() {
		return balcony;
	}
	
	/**
	 * @return the counsellorGroup
	 */
	public CounsellorGroup getCounsellorGroup() {
		return counsellorGroup;
	}
	
	/**
	 * @return the counsellorGarbage
	 */
	public GarbageState getCounsellorGarbage() {
		return counsellorGarbage;
	}
	
	
}
