package dto.queries.respond;

import java.util.Map;
import java.util.Map.Entry;

import dto.DTOObject;
import dto.playerInfo.DTOPlayer;
import dto.playerInfo.DTOScore;

public class DTOScoresResponse implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5714959351747251213L;
	
	private final Map<DTOPlayer, DTOScore> scores;
	private final DTOPlayer requestingPlayer;
	
	public DTOScoresResponse(Map<DTOPlayer, DTOScore> scores, DTOPlayer requestingPlayer) {
		this.scores = scores;
		this.requestingPlayer = requestingPlayer;
	}

	/**
	 * @return the scores
	 */
	public Map<DTOPlayer, DTOScore> getScores() {
		return scores;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder scores = new StringBuilder();
		scores.append("\n[SERVER] PLAYERS SCORE:\n");
		
		for (Entry<DTOPlayer, DTOScore> entry : this.scores.entrySet()) {
			if (entry.getKey().equals(this.requestingPlayer)) {
				scores.append("[SERVER] " + entry.getKey().getNickname().toUpperCase() + ": " + entry.getValue().getLevel() + "\n");
			} else {
				scores.append("[SERVER] " + entry.getKey().getNickname() + ": " + entry.getValue().getLevel() + "\n");
			}	
		}
		
		return scores.toString();
	}
	
	

}
