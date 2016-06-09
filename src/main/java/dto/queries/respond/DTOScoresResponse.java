package dto.queries.respond;

import java.util.Map;
import java.util.Map.Entry;

import dto.DTOObject;
import dto.playerInfo.DTOPlayerBasic;
import dto.playerInfo.DTOScore;

public class DTOScoresResponse implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5714959351747251213L;
	
	private final Map<DTOPlayerBasic, DTOScore> scores;
	private final DTOPlayerBasic requestingPlayer;
	
	public DTOScoresResponse(Map<DTOPlayerBasic, DTOScore> scores, DTOPlayerBasic requestingPlayer) {
		this.scores = scores;
		this.requestingPlayer = requestingPlayer;
	}

	/**
	 * @return the scores
	 */
	public Map<DTOPlayerBasic, DTOScore> getScores() {
		return scores;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder scores = new StringBuilder();
		scores.append("\n[SERVER] PLAYERS SCORE:\n");
		
		for (Entry<DTOPlayerBasic, DTOScore> entry : this.scores.entrySet()) {
			if (entry.getKey().equals(this.requestingPlayer)) {
				scores.append("[SERVER] " + entry.getKey().getNickname().toUpperCase() + ": " + entry.getValue().getLevel() + "\n");
			} else {
				scores.append("[SERVER] " + entry.getKey().getNickname() + ": " + entry.getValue().getLevel() + "\n");
			}	
		}
		
		return scores.toString();
	}
	
	

}
