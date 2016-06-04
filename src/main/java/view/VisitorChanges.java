package view;

import dto.changes.DTOChangeSubstitutePermissionCards;
import dto.changes.DTOChangeMsg;
import dto.changes.DTOChangeHireAssistants;
import dto.changes.DTOChangePlayerStatus;
import dto.playerInfo.DTOAssistants;
import dto.playerInfo.DTOCoins;
import dto.playerInfo.DTONobilityLevel;
import dto.playerInfo.DTOScore;
import model.changes.ChangeSubstitutePermissionCards;
import model.changes.ChangeMsg;
import model.changes.ChangeHireAssistants;
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
	
	public DTOChangeMsg visit(ChangeMsg change){
		return new DTOChangeMsg(change.getMsg());
	}
	
	public DTOChangeHireAssistants visit(ChangeHireAssistants change){
		DTOAssistants assistants=new DTOAssistants(change.getAssistants().getItems());
		DTOCoins coins=new DTOCoins(change.getCoins().getItems());
		
		return new DTOChangeHireAssistants(assistants, coins);
	}
	
	public DTOChangeSubstitutePermissionCards visit(ChangeSubstitutePermissionCards change){
		DTOAssistants assistants=new DTOAssistants(change.getAssistants().getItems());
		String nameRegion=change.getNameRegion();
		
		return new DTOChangeSubstitutePermissionCards(assistants, nameRegion);
	}
}
