package dto.queries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import dto.queries.request.DTOProposalOrderRequest;
import dto.queries.request.DTOScoresRequest;
import dto.map.DTOCity;
import dto.playerInfo.DTOAssistants;
import dto.playerInfo.DTOCoins;
import dto.playerInfo.DTONobilityLevel;
import dto.playerInfo.DTOPlayer;
import dto.playerInfo.DTOPlayerAdvanced;
import dto.playerInfo.DTOPlayerBasic;
import dto.playerInfo.DTOScore;
import dto.queries.request.DTOCurrentPlayerRequest;
import dto.queries.request.DTOFreeCounsellorsRequest;
import dto.queries.request.DTOPingRequest;
import dto.queries.request.DTOPlayerInfoRequest;
import dto.queries.request.DTOPlayersListRequest;
import dto.queries.respond.DTOCurrentPlayerResponse;
import dto.queries.respond.DTOFreeCounsellorsResponse;
import dto.queries.respond.DTOPingResponse;
import dto.queries.respond.DTOPlayerInfoAdvancedResponse;
import dto.queries.respond.DTOPlayerInfoResponse;
import dto.queries.respond.DTOPlayersListResponse;
import dto.queries.respond.DTOProposalOrderResponse;
import dto.queries.respond.DTOScoresResponse;
import dto.utilities.DTOColor;
import dto.utilities.DTOPermissionCard;
import dto.utilities.DTOColorCounter;
import jaxb.CFGPoliticalCard;
import model.GameState;
import model.bonusable.PermissionCard;
import model.council.CounsellorGroup;
import model.map.City;
import model.player.Player;
import model.politicalDeck.PoliticalCard;

public class VisitorQueries {
	
	private GameState gameState;
	private Player requestingPlayer;
	
	/**
	 * 
	 * @param gameState
	 * @throws NullPointerException if gameState==null
	 */
	public VisitorQueries(GameState gameState, Player requestingPlayer) {
		if(gameState == null) throw new NullPointerException();
		this.gameState = gameState;
		this.requestingPlayer = requestingPlayer;
	}
	
	/**
	 * 
	 * @param dto
	 * @return the order of colours in politicalDeck
	 * @throws NullPointerException if dto==null
	 */
	public DTOProposalOrderResponse visit(DTOProposalOrderRequest dto){
		if(dto==null){
			throw new NullPointerException("dto can't be null");
		}
		
		ArrayList<String> proposalOrder = new ArrayList<String>();
		
		for (CFGPoliticalCard cfgPoliticalCard : this.gameState.getParser().getCFGRoot().getPoliticalDeck().getPoliticalCard()) {
			proposalOrder.add(cfgPoliticalCard.getColor());
		}
		
		return new DTOProposalOrderResponse(proposalOrder);
	}
	
	public DTOPingResponse visit(DTOPingRequest dto){
		if(dto==null){
			throw new NullPointerException("dto can't be null");
		}
		
		return new DTOPingResponse();
	}
	
	public DTOCurrentPlayerResponse visit(DTOCurrentPlayerRequest dto){
		if(dto==null){
			throw new NullPointerException("dto can't be null");
		}
		
		return new DTOCurrentPlayerResponse(new DTOPlayerBasic(
				this.gameState.getCurrentPlayer().getSerialID(),
				new String(this.gameState.getCurrentPlayer().getNickname()),
				new DTOColor(this.gameState.getCurrentPlayer().getColor().getStringID())));
	}
	
	public DTOScoresResponse visit(DTOScoresRequest dto){
		if(dto==null){
			throw new NullPointerException("dto can't be null");
		}
		
		Map<DTOPlayerBasic, DTOScore> scores = new HashMap<DTOPlayerBasic, DTOScore>();
		
		for (Player player : this.gameState.getPlayers()) {
			scores.put(
					new DTOPlayerBasic(player.getSerialID(), new String(player.getNickname()), new DTOColor(player.getColor().getStringID())),
					new DTOScore(player.getScore().getItems().intValue()));
		}
		
		return new DTOScoresResponse(
				scores,
				new DTOPlayerBasic(
						requestingPlayer.getId(),
						new String(requestingPlayer.getNickname()),
						new DTOColor(requestingPlayer.getColor().getStringID())));
	}
	
	public DTOPlayerInfoResponse visit(DTOPlayerInfoRequest dto){
		if(dto==null){
			throw new NullPointerException("dto can't be null");
		}
		
		Player player;
		
		if (dto.getPlayer().equals("me")) {
			player = this.requestingPlayer;
			
			Map<DTOColor, Integer> structure = new HashMap<DTOColor, Integer>();

			for (PoliticalCard card : player.getPoliticalHand().getDeck()) {
				structure.put(new DTOColor(new String(card.getColor())), card.getNumCards());
			}
			DTOColorCounter politicalCards = new DTOColorCounter(structure);
			
			ArrayList<DTOPermissionCard> permissionCards = new ArrayList<DTOPermissionCard>();
			
			for (PermissionCard card : player.getPermissionHand()) {
				Set<DTOCity> cities = new HashSet<DTOCity>();
				for (City city : card.getPossibleCities()) {
					cities.add(new DTOCity(city.getName()));
				}
				permissionCards.add(new DTOPermissionCard(card.getIdCard(), card.isUsed(), cities));
			}
			
			ArrayList<DTOCity> builtCities = new ArrayList<DTOCity>();
			
			for (City city : player.getBuiltCities()) {
				builtCities.add(new DTOCity(city.getName()));
			}
			
			return new DTOPlayerInfoAdvancedResponse(new DTOPlayerAdvanced(player.getSerialID(), new String(player.getNickname()),
					new DTOColor(new String(player.getColor().getStringID())),
					new DTOCoins(player.getCoins().getItems().intValue()),
					new DTOAssistants(player.getAssistants().getItems().intValue()),
					new DTONobilityLevel(player.getNobilityLevel().getItems().intValue()),
					new DTOScore(player.getScore().getItems().intValue()),
					politicalCards, permissionCards, builtCities));
			
		} else {
			
			if (this.gameState.getPlayersHashMap().containsKey(dto.getPlayer())) {
				player = this.gameState.getPlayersHashMap().get(dto.getPlayer());

				return new DTOPlayerInfoResponse(new DTOPlayer(player.getSerialID(), new String(player.getNickname()),
						new DTOColor(new String(player.getColor().getStringID())),
						new DTOCoins(player.getCoins().getItems().intValue()),
						new DTOAssistants(player.getAssistants().getItems().intValue()),
						new DTONobilityLevel(player.getNobilityLevel().getItems().intValue()),
						new DTOScore(player.getScore().getItems().intValue())));
			} else {
				return new DTOPlayerInfoResponse();
			}
			
		}

		

	}

	public DTOPlayersListResponse visit(DTOPlayersListRequest dto){
		ArrayList<DTOPlayerBasic> players = new ArrayList<DTOPlayerBasic>();
		for (Player player : this.gameState.getPlayers()) {
			players.add(new DTOPlayerBasic(player.getId(), new String(player.getNickname()),
					new DTOColor(new String(player.getColor().getStringID()))));
		}
		
		return new DTOPlayersListResponse(players);
	}
	
	public DTOFreeCounsellorsResponse visit(DTOFreeCounsellorsRequest dto){
		
		Map<DTOColor, Integer> structure = new HashMap<DTOColor, Integer>();
		
		for (CounsellorGroup group : this.gameState.getCounsellorGarbage().getState()) {
			structure.put(new DTOColor(new String(group.getColor().getStringID())), group.getCounter().intValue());
		}
		
		DTOColorCounter garbageStatus = new DTOColorCounter(structure);
		
		return new DTOFreeCounsellorsResponse(garbageStatus);
	}

}
