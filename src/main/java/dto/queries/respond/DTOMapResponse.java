package dto.queries.respond;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import dto.DTOObject;
import dto.map.DTOCity;
import dto.playerInfo.DTOPlayerBasic;

public class DTOMapResponse implements DTOObject {
	
	
	/*----- CLI QUERY ONLY -----*/
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -3553138959701669253L;
	
	private final String cliDisplay;
	private final Set<DTOCity> builtCities;
	private transient final Map<DTOCity, Set<DTOPlayerBasic>> citiesStatus;
	
	/**
	 * @param cliDisplay
	 * @param builtCities
	 * @param citiesStatus
	 * @throws NullPointerException if one of the parameters is null
	 */
	public DTOMapResponse(String cliDisplay, Set<DTOCity> builtCities, Map<DTOCity, Set<DTOPlayerBasic>> citiesStatus) {
		if(cliDisplay==null) {
			throw new NullPointerException("cliDisplay cannot be null"); 
		}
		if(builtCities==null) {
			throw new NullPointerException("builtCities cannot be null"); 
		}
		if(citiesStatus==null) {
			throw new NullPointerException("citiesStatus cannot be null"); 
		}
		this.cliDisplay = cliDisplay;
		this.builtCities = builtCities;
		this.citiesStatus = citiesStatus;
	}

	/**
	 * @return the builtCities
	 */
	public Set<DTOCity> getBuiltCities() {
		return builtCities;
	}

	/**
	 * @return the citiesStatus
	 */
	public Map<DTOCity, Set<DTOPlayerBasic>> getCitiesStatus() {
		return citiesStatus;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		msg.append("\n[SERVER]\n");
		msg.append(cliDisplay + "\n");
		
		if (builtCities.isEmpty()) {
			msg.append("\n[SERVER] You've not built anywhere yet");
		} else {
			msg.append("\n[SERVER] Cities in which you've built: ");
			for (DTOCity dtoCity : builtCities) {
				msg.append(dtoCity.getName().toUpperCase() + " ");
			}
		}
		
		for (Entry<DTOCity, Set<DTOPlayerBasic>> entry : citiesStatus.entrySet()) {
			msg.append("\n[SERVER] " + entry.getKey().getName().toUpperCase() + ": ");
			for (DTOPlayerBasic player : entry.getValue())
				msg.append(player.getNickname() + " ");
		}
		
		msg.append("\n");
		
		return msg.toString();
	}

	
}
