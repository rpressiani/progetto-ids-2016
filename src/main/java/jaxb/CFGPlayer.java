//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.21 at 06:29:24 PM CEST 
//


package jaxb;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CFGPlayer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CFGPlayer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="coins" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="assistants" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFGPlayer", propOrder = {
    "id",
    "coins",
    "assistants"
})
public class CFGPlayer {

    @XmlElement(required = true)
    protected BigInteger id;
    @XmlElement(required = true)
    protected BigInteger coins;
    @XmlElement(required = true)
    protected BigInteger assistants;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setId(BigInteger value) {
        this.id = value;
    }

    /**
     * Gets the value of the coins property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCoins() {
        return coins;
    }

    /**
     * Sets the value of the coins property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCoins(BigInteger value) {
        this.coins = value;
    }

    /**
     * Gets the value of the assistants property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAssistants() {
        return assistants;
    }

    /**
     * Sets the value of the assistants property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAssistants(BigInteger value) {
        this.assistants = value;
    }

}
