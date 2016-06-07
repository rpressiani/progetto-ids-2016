package view;

import dto.changes.DTOChangeSubstitutePermissionCards;
import dto.map.DTOCity;
import dto.map.DTORegion;
import dto.changes.DTOChangeMsg;
import dto.changes.DTOChangeBuildEmporiumWithCard;
import dto.changes.DTOChangeBuildEmporiumWithKing;
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
import dto.utilities.DTOPermissionCard;
import model.changes.ChangeSubstitutePermissionCards;
import model.changes.ChangeMsg;
import model.changes.ChangeBuildEmporiumWithCard;
import model.changes.ChangeBuildEmporiumWithKing;
import model.changes.ChangeBuyPermissionCard;
import model.changes.ChangeElectCounsellor;
import model.changes.ChangeElectCounsellorWithAssistant;
import model.changes.ChangeHireAssistants;
import model.changes.ChangePlayerStatus;

public class VisitorChanges {
	
	/**
	 * @param change
	 * @return a DTOChangePlayerStatus
	 * @throws NullPointerException if change is null
	 */
	public DTOChangePlayerStatus visit(ChangePlayerStatus change) {
		if(change==null) {
			throw new NullPointerException("change cannot be null"); 
		}
		
		DTOCoins coins=new DTOCoins(change.getCoins().getItems());
		DTOAssistants assistants=new DTOAssistants(change.getAssistants().getItems());
		DTONobilityLevel nobilityLevel=new DTONobilityLevel(change.getNobilityLevel().getItems());
		DTOScore score=new DTOScore(change.getScore().getItems());
		
		return new DTOChangePlayerStatus(coins, assistants, nobilityLevel, score);
	}
	
	/**
	 * 
	 * @param change
	 * @return a DTOChangeMsg
	 * @throws NullPointerException if change is null
	 */
	public DTOChangeMsg visit(ChangeMsg change){
		if(change==null){
			throw new NullPointerException("change can't be null");
		}
		
		return new DTOChangeMsg(change.getMsg());
	}
	
	/**
	 * 
	 * @param change
	 * @return a DTOChangeHireAssistants
	 * @throws NullPointerException if change is null
	 */
	public DTOChangeHireAssistants visit(ChangeHireAssistants change){
		if(change==null){
			throw new NullPointerException("change can't be null");
		}
		
		DTOAssistants assistants=new DTOAssistants(change.getAssistants().getItems());
		DTOCoins coins=new DTOCoins(change.getCoins().getItems());
		
		return new DTOChangeHireAssistants(assistants, coins);
	}
	
	/**
	 * 
	 * @param change
	 * @return a DTOChangeSubstitutePermissionCards
	 * @throws NullPointerException if change is null
	 */
	public DTOChangeSubstitutePermissionCards visit(ChangeSubstitutePermissionCards change){
		if(change==null){
			throw new NullPointerException("change can't be null");
		}
		
		DTOAssistants assistants=new DTOAssistants(change.getAssistants().getItems());
		DTORegion region=new DTORegion(change.getRegion().getName());
		
		return new DTOChangeSubstitutePermissionCards(assistants, region);
	}
	
	/**
	 * 
	 * @param change
	 * @return a DTOChangeElectCounsellorWithAssistant
	 * @throws NullPointerException if change is null
	 */
	public DTOChangeElectCounsellorWithAssistant visit(ChangeElectCounsellorWithAssistant change){
		if(change==null){
			throw new NullPointerException("change can't be null");
		}
		
		DTOAssistants assistants=new DTOAssistants(change.getAssistants().getItems());
		DTOColor color=new DTOColor(change.getColor().getStringID());
		DTORegion region=new DTORegion(change.getRegion().getName());
		
		return new DTOChangeElectCounsellorWithAssistant(assistants, color, region);
	}
	
	/**
	 * 
	 * @param change
	 * @return a DTOChangeElectCounsellor
	 * @throws NullPointerException if change is null
	 */
	public DTOChangeElectCounsellor visit(ChangeElectCounsellor change){
		if(change==null){
			throw new NullPointerException("change can't be null");
		}
		
		DTOCoins coins=new DTOCoins(change.getCoins().getItems());
		DTOColor color=new DTOColor(change.getColor().getStringID());
		DTORegion region=new DTORegion(change.getRegion().getName());
		
		return new DTOChangeElectCounsellor(coins, color, region);
	}
	
	/**
	 * 
	 * @param change
	 * @return a DTOChangeBuyPermissionCard
	 * @throws NullPointerException if change is null
	 */
	public DTOChangeBuyPermissionCard visit(ChangeBuyPermissionCard change){
		if(change==null){
			throw new NullPointerException("change can't be null");
		}
		
		DTOCoins coins=new DTOCoins(change.getCoins().getItems());
		DTORegion region=new DTORegion(change.getRegion().getName());
		
		return new DTOChangeBuyPermissionCard(coins, region);
	}
	
	/**
	 * 
	 * @param change
	 * @return a DTOChangeBuildEmporiumWithCard
	 * @throws NullPointerException if change is null
	 */
	public DTOChangeBuildEmporiumWithCard visit(ChangeBuildEmporiumWithCard change){
		if(change==null){
			throw new NullPointerException("change can't be null");
		}
		
		DTOAssistants assistants=new DTOAssistants(change.getAssistants().getItems());
		DTOCity city=new DTOCity(change.getCity().getName());
		DTOPermissionCard card=new DTOPermissionCard(change.getCard().getIdCard());
		
		return new DTOChangeBuildEmporiumWithCard(assistants, city, card);
	}
	
	/**
	 * 
	 * @param change
	 * @return a DTOChangeBuildEmporiumWithKing
	 * @throws NullPointerException if change is null
	 */
	public DTOChangeBuildEmporiumWithKing visit(ChangeBuildEmporiumWithKing change){
		if(change==null){
			throw new NullPointerException("change can't be null");
		}
		
		DTOCoins coins=new DTOCoins(change.getCoins().getItems());
		DTOAssistants assistants=new DTOAssistants(change.getAssistants().getItems());
		DTOCity city=new DTOCity(change.getCity().getName());
		
		return new DTOChangeBuildEmporiumWithKing(assistants, coins, city);
	}
}
