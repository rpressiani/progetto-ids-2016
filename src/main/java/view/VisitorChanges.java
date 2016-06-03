package view;

import dto.changes.DTOChangePlayerStatus;
import dto.playerInfo.DTOAssistants;
import dto.playerInfo.DTOCoins;
import dto.playerInfo.DTONobilityLevel;
import dto.playerInfo.DTOScore;
import model.changes.ChangePlayerStatus;

public class VisitorChanges {
	
	public VisitorChanges(){
		
	}
	
	public DTOChangePlayerStatus visit(ChangePlayerStatus change){
		DTOCoins coins=new DTOCoins(change.getCoins().getItems());
		DTOAssistants assistants=new DTOAssistants(change.getAssistants().getItems());
		DTONobilityLevel nobilityLevel=new DTONobilityLevel(change.getNobilityLevel().getItems());
		DTOScore score=new DTOScore(change.getScore().getItems());
		
		return new DTOChangePlayerStatus(coins, assistants, nobilityLevel, score);
	}
}
