package dto.queries;

import java.util.ArrayList;

import dto.queries.request.DTOGetProposalOrder;
import dto.queries.respond.DTOProposalOrder;
import jaxb.CFGPoliticalCard;
import model.GameState;

public class VisitorQueries {
	
	private GameState gameState;
	
	/**
	 * 
	 * @param gameState
	 * @throws NullPointerException if gameState==null
	 */
	public VisitorQueries(GameState gameState) {
		if(gameState == null) throw new NullPointerException();
		this.gameState = gameState;
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
	public DTOProposalOrder visit(DTOGetProposalOrder dto){
		if(dto==null){
			throw new NullPointerException("dto can't be null");
		}
		
		ArrayList<String> proposalOrder = new ArrayList<String>();
		
		for (CFGPoliticalCard cfgPoliticalCard : this.gameState.getParser().getCFGRoot().getPoliticalDeck().getPoliticalCard()) {
			proposalOrder.add(cfgPoliticalCard.getColor());
		}
		
		return new DTOProposalOrder(proposalOrder);
	}

}
