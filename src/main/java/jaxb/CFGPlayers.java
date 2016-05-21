//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.21 at 12:27:19 PM CEST 
//


package jaxb;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CFGPlayers complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CFGPlayers">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nInitPoliticalCards" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="player" type="{urn:co4}CFGPlayer" maxOccurs="unbounded" minOccurs="2"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFGPlayers", propOrder = {
    "nInitPoliticalCards",
    "player"
})
public class CFGPlayers {

    @XmlElement(required = true)
    protected BigInteger nInitPoliticalCards;
    @XmlElement(required = true)
    protected List<CFGPlayer> player;

    /**
     * Gets the value of the nInitPoliticalCards property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNInitPoliticalCards() {
        return nInitPoliticalCards;
    }

    /**
     * Sets the value of the nInitPoliticalCards property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNInitPoliticalCards(BigInteger value) {
        this.nInitPoliticalCards = value;
    }

    /**
     * Gets the value of the player property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the player property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlayer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CFGPlayer }
     * 
     * 
     */
    public List<CFGPlayer> getPlayer() {
        if (player == null) {
            player = new ArrayList<CFGPlayer>();
        }
        return this.player;
    }

}
