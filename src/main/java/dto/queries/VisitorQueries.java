package dto.queries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dto.queries.request.DTOProposalOrderRequest;
import dto.queries.request.DTOScoresRequest;
import dto.playerInfo.DTOAssistants;
import dto.playerInfo.DTOCoins;
import dto.playerInfo.DTONobilityLevel;
import dto.playerInfo.DTOPlayer;
import dto.playerInfo.DTOPlayerAdvanced;
import dto.playerInfo.DTOPlayerBasic;
import dto.playerInfo.DTOScore;
import dto.queries.request.DTOCurrentPlayerRequest;
import dto.queries.request.DTOPingRequest;
import dto.queries.request.DTOPlayerInfoRequest;
import dto.queries.respond.DTOCurrentPlayerResponse;
import dto.queries.respond.DTOPingResponse;
import dto.queries.respond.DTOPlayerInfoAdvancedResponse;
import dto.queries.respond.DTOPlayerInfoResponse;
import dto.queries.respond.DTOProposalOrderResponse;
import dto.queries.respond.DTOScoresResponse;
import dto.utilities.DTOColor;
import dto.utilities.DTOPoliticalHand;
import jaxb.CFGPoliticalCard;
import model.GameState;
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

			for (PoliticalCard card : this.requestingPlayer.getPoliticalHand().getDeck()) {
				structure.put(new DTOColor(new String(card.getColor())), card.getNumCards());
			}
			DTOPoliticalHand politicalCards = new DTOPoliticalHand(structure);
			
			return new DTOPlayerInfoAdvancedResponse(new DTOPlayerAdvanced(player.getSerialID(), new String(player.getNickname()),
					new DTOColor(new String(player.getColor().getStringID())),
					new DTOCoins(player.getCoins().getItems().intValue()),
					new DTOAssistants(player.getAssistants().getItems().intValue()),
					new DTONobilityLevel(player.getNobilityLevel().getItems().intValue()),
					new DTOScore(player.getScore().getItems().intValue()),
					politicalCards));
			
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


}
