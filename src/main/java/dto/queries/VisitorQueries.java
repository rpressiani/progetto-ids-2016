package dto.queries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

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
import dto.queries.request.DTOBalconiesStateRequest;
import dto.queries.request.DTOCurrentPlayerRequest;
import dto.queries.request.DTOFreeCounsellorsRequest;
import dto.queries.request.DTOMapRequest;
import dto.queries.request.DTOMarketStatusRequest;
import dto.queries.request.DTOPermissionAvailableRequest;
import dto.queries.request.DTOPingRequest;
import dto.queries.request.DTOPlayerInfoRequest;
import dto.queries.request.DTOPlayersListRequest;
import dto.queries.respond.DTOBalconiesStateResponse;
import dto.queries.respond.DTOCurrentPlayerResponse;
import dto.queries.respond.DTOFreeCounsellorsResponse;
import dto.queries.respond.DTOMapResponse;
import dto.queries.respond.DTOMarketStatusResponse;
import dto.queries.respond.DTOPermissionAvailableResponse;
import dto.queries.respond.DTOPingResponse;
import dto.queries.respond.DTOPlayerInfoAdvancedResponse;
import dto.queries.respond.DTOPlayerInfoResponse;
import dto.queries.respond.DTOPlayersListResponse;
import dto.queries.respond.DTOProposalOrderResponse;
import dto.queries.respond.DTOScoresResponse;
import dto.utilities.DTOBalcony;
import dto.utilities.DTOColor;
import dto.utilities.DTOPermissionCard;
import dto.utilities.DTOColorCounter;
import jaxb.CFGPoliticalCard;
import model.GameState;
import model.bonusItem.BonusInputItem;
import model.bonusItem.BonusItem;
import model.bonusable.PermissionCard;
import model.council.Counsellor;
import model.council.CounsellorGroup;
import model.map.City;
import model.map.Region;
import model.market.Contract;
import model.market.Marketable;
import model.player.Assistants;
import model.player.Coins;
import model.player.Player;
import model.politicalDeck.PoliticalCard;
import model.politicalDeck.PoliticalContainer;

public class VisitorQueries {
	
	private GameState gameState;
	private Player requestingPlayer;
	
	/**
	 * 
	 * @param gameState
	 * @throws NullPointerException if gameState==null
	 */
	public VisitorQueries(GameState gameState, Player requestingPlayer) {
		if(gameState == null) 
			throw new NullPointerException("gameState cannot be null");
		if(requestingPlayer==null) {
			throw new NullPointerException("requestingPlayer cannot be null"); 
		}
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
				Map<String, Integer> bonuses = new HashMap<String, Integer>();
				for (BonusItem item : card.getBonuses()){
					if (!bonuses.containsKey(item.getClass().getName())) {
						if (item instanceof BonusInputItem) {
							bonuses.put(item.getClass().getName(), 1);
						} else {
							bonuses.put(item.getClass().getName(), item.getQuantity());
						}
					} else {
						if (item instanceof BonusInputItem) {
							bonuses.put(item.getClass().getName(), bonuses.get(item.getClass().getName()).intValue()+1);
						} else {
							bonuses.put(item.getClass().getName(), bonuses.get(item.getClass().getName()).intValue()+item.getQuantity());
						}
					}
				}
				permissionCards.add(new DTOPermissionCard(card.getIdCard(), card.isUsed(), cities, bonuses));
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
	
	public DTOBalconiesStateResponse visit(DTOBalconiesStateRequest dto){
		
		Map<String, DTOBalcony> balconies = new HashMap<String, DTOBalcony>();
		
		
		ArrayList<DTOColor> balcony;
		
		for (Entry<String, Region> entry  : this.gameState.getMap().getRegions().entrySet()) {
			balcony = new ArrayList<DTOColor>();
			for (Counsellor counsellor : entry.getValue().getBalcony().getBalcony()) {
				balcony.add(new DTOColor(new String(counsellor.getColor().getStringID())));
			}
			
			balconies.put(entry.getKey(), new DTOBalcony(balcony));
		}
		
		balcony = new ArrayList<DTOColor>();
		for (Counsellor counsellor : this.gameState.getKingBalcony().getBalcony()) {
			balcony.add(new DTOColor(new String(counsellor.getColor().getStringID())));
		}
		balconies.put("king", new DTOBalcony(balcony));
		
		return new DTOBalconiesStateResponse(balconies);
	}
	
	public DTOPermissionAvailableResponse visit(DTOPermissionAvailableRequest dto){
		Map<String, Set<DTOPermissionCard>> permissionPerRegion = new HashMap<String, Set<DTOPermissionCard>>();
		Set<DTOPermissionCard> cards;
		
		for (Entry<String, Region> entry  : this.gameState.getMap().getRegions().entrySet()) {
			cards = new HashSet<DTOPermissionCard>();
			for (PermissionCard card : entry.getValue().getPermissionDeck().getVisibleCards()) {
				Set<DTOCity> cities = new HashSet<DTOCity>();
				for (City city : card.getPossibleCities()) {
					cities.add(new DTOCity(city.getName()));
				}
				Map<String, Integer> bonuses = new HashMap<String, Integer>();
				for (BonusItem item : card.getBonuses()){
					if (!bonuses.containsKey(item.getClass().getName())) {
						if (item instanceof BonusInputItem) {
							bonuses.put(item.getClass().getName(), 1);
						} else {
							bonuses.put(item.getClass().getName(), item.getQuantity());
						}
					} else {
						if (item instanceof BonusInputItem) {
							bonuses.put(item.getClass().getName(), bonuses.get(item.getClass().getName()).intValue()+1);
						} else {
							bonuses.put(item.getClass().getName(), bonuses.get(item.getClass().getName()).intValue()+item.getQuantity());
						}
					}
				}
				cards.add(new DTOPermissionCard(card.getIdCard(), card.isUsed(), cities, bonuses));
			}
			
			permissionPerRegion.put(entry.getKey(), cards);
		}
		
		
		return new DTOPermissionAvailableResponse(permissionPerRegion);
	}
	
	public DTOMapResponse visit(DTOMapRequest dto){
		
		Set<DTOCity> builtCities = new HashSet<DTOCity>();
		
		for (City city : this.requestingPlayer.getBuiltCities()) {
			builtCities.add(new DTOCity(new String(city.getName())));
		}
		
		Map<DTOCity, Set<DTOPlayerBasic>> citiesStatus = new HashMap<DTOCity, Set<DTOPlayerBasic>>();
		
		for (Entry<String, City> entry : this.gameState.getMap().getAllCitiesHashMap().entrySet()) {
			Set<DTOPlayerBasic> playersInCity = new HashSet<DTOPlayerBasic>();
			for (Player player : this.gameState.getPlayers()) {
				if (player.getBuiltCities().contains(entry.getValue())) {
					playersInCity.add(new DTOPlayerBasic(player.getSerialID(), new String(player.getNickname()),
							new DTOColor(new String(player.getColor().getStringID()))));
				}
			}
			citiesStatus.put(new DTOCity(new String(entry.getKey())), playersInCity);
		}
		
		return new DTOMapResponse(new String(this.gameState.getMap().getCliDisplay()), builtCities, citiesStatus);
	}
	
	public DTOMarketStatusResponse visit(DTOMarketStatusRequest dto){
		Map<String, DTOContract> contracts = new HashMap<String, DTOContract>();
		for (Contract contract : this.gameState.getMarket().getContractSet()) {
			DTOContract dtoContract = new DTOContract(contract.getSeller().getNickname());
			Set<DTOPermissionCard> sellPermissions = new HashSet<DTOPermissionCard>();
			for (Marketable item : contract.getSellBag()) {
				if (item instanceof Coins) {
					dtoContract.setSellCoins(new DTOCoins(((Coins) item).getItems().intValue()));
				}
				if (item instanceof Assistants) {
					dtoContract.setSellAssistants(new DTOAssistants(((Assistants) item).getItems().intValue()));
				}
				if (item instanceof PermissionCard) {
					Set<DTOCity> cities = new HashSet<>();
					for (City city : ((PermissionCard) item).getPossibleCities()) {
						cities.add(new DTOCity(city.getName()));
					}
					Map<String, Integer> bonuses = new HashMap<String, Integer>();
					for (BonusItem bonusItem : ((PermissionCard)item).getBonuses()){
						if (!bonuses.containsKey(item.getClass().getName())) {
							if (item instanceof BonusInputItem) {
								bonuses.put(item.getClass().getName(), 1);
							} else {
								bonuses.put(item.getClass().getName(), bonusItem.getQuantity());
							}
						} else {
							if (item instanceof BonusInputItem) {
								bonuses.put(item.getClass().getName(), bonuses.get(item.getClass().getName()).intValue()+1);
							} else {
								bonuses.put(item.getClass().getName(), bonuses.get(item.getClass().getName()).intValue()+bonusItem.getQuantity());
							}
						}
					}
					sellPermissions.add(new DTOPermissionCard(((PermissionCard) item).getIdCard(),
							((PermissionCard) item).isUsed(), cities, bonuses));
				}
				if (item instanceof PoliticalContainer) {
					ArrayList<Integer> structure = new ArrayList<Integer>();
					for (PoliticalCard card : ((PoliticalContainer) item).getDeck()) {
						structure.add(card.getNumCards());
					}
					
					Map<DTOColor, Integer> sellPoliticals = new HashMap<DTOColor, Integer>();

					for (int i = 0; i < this.gameState.getPoliticalDeck().getDeck().size(); i++) {
						sellPoliticals.put(new DTOColor(new String(this.gameState.getPoliticalDeck().getDeck().get(i).getColor())),
								structure.get(i));
					}
					
					DTOColorCounter politicalCards = new DTOColorCounter(sellPoliticals);
					dtoContract.setSellPoliticals(politicalCards);
				}
				dtoContract.setSellPermissions(sellPermissions);
			}
			Set<DTOPermissionCard> buyPermissions = new HashSet<DTOPermissionCard>();
			for (Marketable item : contract.getBuyBag()) {
				if (item instanceof Coins) {
					dtoContract.setBuyCoins(new DTOCoins(((Coins) item).getItems().intValue()));
				}
				if (item instanceof Assistants) {
					dtoContract.setBuyAssistants(new DTOAssistants(((Assistants) item).getItems().intValue()));
				}
				if (item instanceof PermissionCard) {
					Set<DTOCity> cities = new HashSet<>();
					for (City city : ((PermissionCard) item).getPossibleCities()) {
						cities.add(new DTOCity(city.getName()));
					}
					Map<String, Integer> bonuses = new HashMap<String, Integer>();
					for (BonusItem bonusItem : ((PermissionCard)item).getBonuses()){
						if (!bonuses.containsKey(item.getClass().getName())) {
							if (item instanceof BonusInputItem) {
								bonuses.put(item.getClass().getName(), 1);
							} else {
								bonuses.put(item.getClass().getName(), bonusItem.getQuantity());
							}
						} else {
							if (item instanceof BonusInputItem) {
								bonuses.put(item.getClass().getName(), bonuses.get(item.getClass().getName()).intValue()+1);
							} else {
								bonuses.put(item.getClass().getName(), bonuses.get(item.getClass().getName()).intValue()+bonusItem.getQuantity());
							}
						}
					}
					buyPermissions.add(new DTOPermissionCard(((PermissionCard) item).getIdCard(),
							((PermissionCard) item).isUsed(), cities, bonuses));
				}
				if (item instanceof PoliticalContainer) {
					ArrayList<Integer> structure = new ArrayList<Integer>();
					for (PoliticalCard card : ((PoliticalContainer) item).getDeck()) {
						structure.add(card.getNumCards());
					}
					
					Map<DTOColor, Integer> buyPoliticals = new HashMap<DTOColor, Integer>();

					for (int i = 0; i < this.gameState.getPoliticalDeck().getDeck().size(); i++) {
						buyPoliticals.put(new DTOColor(new String(this.gameState.getPoliticalDeck().getDeck().get(i).getColor())),
								structure.get(i));
					}
					
					DTOColorCounter politicalCards = new DTOColorCounter(buyPoliticals);
					dtoContract.setSellPoliticals(politicalCards);
				}
				dtoContract.setBuyPermissions(buyPermissions);
			}
		}
		return new DTOMarketStatusResponse(contracts);
	}

}
