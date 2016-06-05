package view;

import dto.changes.DTOChangeSubstitutePermissionCards;
import dto.map.DTORegion;
import dto.changes.DTOChangeMsg;
import dto.changes.DTOChangeBuyPermissionCard;
import dto.changes.DTOChangeElectCounsellor;
import dto.changes.DTOChangeElectCounsellorWithAssistant;
import dto.changes.DTOChangeHireAssistants;
import dto.changes.DTOChangePlayerStatus;
import dto.playerInfo.DTOAssistants;
import dto.playerInfo.DTOCoins;
import dto.playerInfo.DTONobilityLevel;
import dto.playerInfo.DTOScore;
import dto.utilities.DTOColor;
import model.changes.ChangeSubstitutePermissionCards;
import model.changes.ChangeMsg;
import model.changes.ChangeBuyPermissionCard;
import model.changes.ChangeElectCounsellor;
import model.changes.ChangeElectCounsellorWithAssistant;
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
		DTORegion region=new DTORegion(change.getRegion().getName());
		
		return new DTOChangeSubstitutePermissionCards(assistants, region);
	}
	
	public DTOChangeElectCounsellorWithAssistant visit(ChangeElectCounsellorWithAssistant change){
		DTOAssistants assistants=new DTOAssistants(change.getAssistants().getItems());
		DTOColor color=new DTOColor(change.getColor().getStringID());
		DTORegion region=new DTORegion(change.getRegion().getName());
		
		return new DTOChangeElectCounsellorWithAssistant(assistants, color, region);
	}
	
	public DTOChangeElectCounsellor visit(ChangeElectCounsellor change){
		DTOCoins coins=new DTOCoins(change.getCoins().getItems());
		DTOColor color=new DTOColor(change.getColor().getStringID());
		DTORegion region=new DTORegion(change.getRegion().getName());
		
		return new DTOChangeElectCounsellor(coins, color, region);
	}
	
	public DTOChangeBuyPermissionCard visit(ChangeBuyPermissionCard change){
		DTOCoins coins=new DTOCoins(change.getCoins().getItems());
		DTORegion region=new DTORegion(change.getRegion().getName());
		
		return new DTOChangeBuyPermissionCard(coins, region);
	}
}
