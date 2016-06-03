package model.changes;

import dto.changes.DTOChangePlayerStatus;
import model.player.Assistants;
import model.player.Coins;
import model.player.NobilityLevel;
import model.player.Player;
import model.player.Score;
import view.VisitorChanges;

public class ChangePlayerStatus implements Change {

	private Coins coins;
	private Assistants assistants;
	private NobilityLevel nobilityLevel;
	private Score score;

	public ChangePlayerStatus(Player player){
		this.coins=player.getCoins();
		this.assistants=player.getAssistants();
		this.nobilityLevel=player.getNobilityLevel();
		this.score=player.getScore();
	}
	
	@Override
	public DTOChangePlayerStatus accept(VisitorChanges v, Player player) {
		return v.visit(this);
	}

	/**
	 * @return the coins
	 */
	public Coins getCoins() {
		return coins;
	}

	/**
	 * @return the assistants
	 */
	public Assistants getAssistants() {
		return assistants;
	}

	/**
	 * @return the nobilityLevel
	 */
	public NobilityLevel getNobilityLevel() {
		return nobilityLevel;
	}

	/**
	 * @return the score
	 */
	public Score getScore() {
		return score;
	}
}
