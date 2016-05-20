/**
 * 
 */
package parser;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import jaxb.CFGBonus;
import jaxb.CFGCouncil;
import jaxb.CFGPoliticalDeck;
import jaxb.CFGRoot;
import model.bonusItem.BonusAssistants;
import model.bonusItem.BonusCoins;
import model.bonusItem.BonusItem;
import model.bonusItem.BonusNobility;
import model.bonusItem.BonusScore;

/**
 * @author Riccardo Pressiani
 *
 */
public class Parser {
	
	private File file;
	private JAXBContext jaxbContext;
	private Unmarshaller jabxUnmarshaller;
	private CFGRoot cfgRoot; 
	
	public Parser(){
		try {
			this.file = new File("src/main/resources/co4_config.xml");
			this.jaxbContext = JAXBContext.newInstance(CFGRoot.class);
			this.jabxUnmarshaller = jaxbContext.createUnmarshaller();
			this.cfgRoot = (CFGRoot) this.jabxUnmarshaller.unmarshal(file);
		}
		catch (JAXBException e){
			e.printStackTrace();
		}
	}
	
	public Parser(File file){
		try {
			this.file = file;
			this.jaxbContext = JAXBContext.newInstance(CFGRoot.class);
			this.jabxUnmarshaller = jaxbContext.createUnmarshaller();
			this.cfgRoot = (CFGRoot) this.jabxUnmarshaller.unmarshal(file);
		}
		catch (JAXBException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * @return the cfgRoot
	 */
	public CFGRoot getCFGRoot() {
		return cfgRoot;
	}

	public CFGCouncil getCFGCouncil(){
		return cfgRoot.getCouncil();
	}
	
	public CFGPoliticalDeck getCFGPoliticalDeck(){
		return cfgRoot.getPoliticalDeck();
	}
	
	public ArrayList<BonusItem> getBonusesFromParser(List<CFGBonus> cfgBonuses){
		ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>();
		
		for (Iterator<CFGBonus> iteratorBonuses = cfgBonuses.iterator(); iteratorBonuses.hasNext();) {
			CFGBonus bonus = iteratorBonuses.next();
			BonusItem bonusItem;
			switch (bonus.getBonusItem()) {
			case "coins":
				bonusItem = new BonusCoins(bonus.getQuantity().intValue());
				bonuses.add(bonusItem);
				break;
			case "assistants":
				bonusItem = new BonusAssistants(bonus.getQuantity().intValue());
				bonuses.add(bonusItem);
			case "score":
				bonusItem = new BonusScore(bonus.getQuantity().intValue());
				bonuses.add(bonusItem);
			case "nobility":
				bonusItem = new BonusNobility(bonus.getQuantity().intValue());
			case "politicalCard":
//				To be implemented
				break;
			case "additionalAction":
//				To be implemented
				break;
			case "againPermission":
//				To be implemented
				break;
			case "freePermission":
//				To be implemented
				break;
			case "token":
//				To be implemented
				break;
			default:
				break;
			}
		}
		return bonuses;
	}

}
