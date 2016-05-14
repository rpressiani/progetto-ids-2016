//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.14 at 03:51:06 PM CEST 
//


package jaxb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jaxb package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Root_QNAME = new QName("urn:co4", "root");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jaxb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CFGRoot }
     * 
     */
    public CFGRoot createCFGRoot() {
        return new CFGRoot();
    }

    /**
     * Create an instance of {@link CFGPlayers }
     * 
     */
    public CFGPlayers createCFGPlayers() {
        return new CFGPlayers();
    }

    /**
     * Create an instance of {@link CFGPoliticalDeck }
     * 
     */
    public CFGPoliticalDeck createCFGPoliticalDeck() {
        return new CFGPoliticalDeck();
    }

    /**
     * Create an instance of {@link CFGPermissionDeck }
     * 
     */
    public CFGPermissionDeck createCFGPermissionDeck() {
        return new CFGPermissionDeck();
    }

    /**
     * Create an instance of {@link CFGCities }
     * 
     */
    public CFGCities createCFGCities() {
        return new CFGCities();
    }

    /**
     * Create an instance of {@link CFGBonuses }
     * 
     */
    public CFGBonuses createCFGBonuses() {
        return new CFGBonuses();
    }

    /**
     * Create an instance of {@link CFGCities4Map }
     * 
     */
    public CFGCities4Map createCFGCities4Map() {
        return new CFGCities4Map();
    }

    /**
     * Create an instance of {@link CFGMap }
     * 
     */
    public CFGMap createCFGMap() {
        return new CFGMap();
    }

    /**
     * Create an instance of {@link CFGPoliticalCard }
     * 
     */
    public CFGPoliticalCard createCFGPoliticalCard() {
        return new CFGPoliticalCard();
    }

    /**
     * Create an instance of {@link CFGPermissionDecks }
     * 
     */
    public CFGPermissionDecks createCFGPermissionDecks() {
        return new CFGPermissionDecks();
    }

    /**
     * Create an instance of {@link CFGCouncil }
     * 
     */
    public CFGCouncil createCFGCouncil() {
        return new CFGCouncil();
    }

    /**
     * Create an instance of {@link CFGCity }
     * 
     */
    public CFGCity createCFGCity() {
        return new CFGCity();
    }

    /**
     * Create an instance of {@link CFGPermissionCard }
     * 
     */
    public CFGPermissionCard createCFGPermissionCard() {
        return new CFGPermissionCard();
    }

    /**
     * Create an instance of {@link CFGBonus }
     * 
     */
    public CFGBonus createCFGBonus() {
        return new CFGBonus();
    }

    /**
     * Create an instance of {@link CFGRegion }
     * 
     */
    public CFGRegion createCFGRegion() {
        return new CFGRegion();
    }

    /**
     * Create an instance of {@link CFGPlayer }
     * 
     */
    public CFGPlayer createCFGPlayer() {
        return new CFGPlayer();
    }

    /**
     * Create an instance of {@link CFGKingBonuses }
     * 
     */
    public CFGKingBonuses createCFGKingBonuses() {
        return new CFGKingBonuses();
    }

    /**
     * Create an instance of {@link CFGPermissionCards }
     * 
     */
    public CFGPermissionCards createCFGPermissionCards() {
        return new CFGPermissionCards();
    }

    /**
     * Create an instance of {@link CFGLinks }
     * 
     */
    public CFGLinks createCFGLinks() {
        return new CFGLinks();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CFGRoot }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:co4", name = "root")
    public JAXBElement<CFGRoot> createRoot(CFGRoot value) {
        return new JAXBElement<CFGRoot>(_Root_QNAME, CFGRoot.class, null, value);
    }

}
