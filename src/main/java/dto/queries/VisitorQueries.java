package dto.queries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dto.queries.request.DTOProposalOrderRequest;
import dto.queries.request.DTOScoresRequest;
import dto.playerInfo.DTOPlayer;
import dto.playerInfo.DTOScore;
import dto.queries.request.DTOCurrentPlayerRequest;
import dto.queries.request.DTOPingRequest;
import dto.queries.request.DTOPlayerInfoRequest;
import dto.queries.respond.DTOCurrentPlayerResponse;
import dto.queries.respond.DTOPingResponse;
import dto.queries.respond.DTOPlayerInfoResponse;
import dto.queries.respond.DTOProposalOrderResponse;
import dto.queries.respond.DTOScoresResponse;
import jaxb.CFGPoliticalCard;
import model.GameState;
import model.player.Player;

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
	
//	public BuyPermissionCard visit(DTOBuyPermissionCard DTOAction, Player player){
//		Region region=gameState.getMap().getRegions().get(DTOAction.getRegion().getName());
//		ArrayList<Integer> structure=DTOAction.getProposal().getStructure();
//		PoliticalContainer proposal=new PoliticalContainer(gameState.getParser(), structure);
//		
//		return new BuyPermissionCard(region, proposal, DTOAction.getIndex());
//	}
	
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
		
		return new DTOCurrentPlayerResponse(new DTOPlayer(
				this.gameState.getCurrentPlayer().getSerialID(),
				new String(this.gameState.getCurrentPlayer().getNickname())));
	}
	
	public DTOScoresResponse visit(DTOScoresRequest dto){
		if(dto==null){
			throw new NullPointerException("dto can't be null");
		}
		
		Map<DTOPlayer, DTOScore> scores = new HashMap<DTOPlayer, DTOScore>();
		
		for (Player player : this.gameState.getPlayers()) {
			scores.put(
					new DTOPlayer(player.getSerialID(), new String(player.getNickname())),
					new DTOScore(player.getScore().getItems().intValue()));
		}
		
		return new DTOScoresResponse(scores, new DTOPlayer(requestingPlayer.getId(), new String(requestingPlayer.getNickname())));
	}
	
//	public DTOPlayerInfoResponse visit(DTOPlayerInfoRequest dto){
//		if(dto==null){
//			throw new NullPointerException("dto can't be null");
//		}
//		
//		Player player;
//		
//		if (this.gameState.getPlayersHashMap().containsKey(dto.getPlayer())) {
//			player = this.gameState.getPlayersHashMap().get(dto.getPlayer());
//			return new DTOPlayerInfoResponse();
//		} else {
//			return new DTOPlayerInfoResponse();
//		}
//		
//
//	}


}
