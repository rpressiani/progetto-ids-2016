//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.10 at 07:42:36 PM CEST 
//


package jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CFGCity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CFGCity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nameLong" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ancestry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="links" type="{urn:co4}CFGLinks"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFGCity", propOrder = {
    "name",
    "nameLong",
    "ancestry",
    "links"
})
public class CFGCity {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String nameLong;
    protected String ancestry;
    @XmlElement(required = true)
    protected CFGLinks links;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the nameLong property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameLong() {
        return nameLong;
    }

    /**
     * Sets the value of the nameLong property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameLong(String value) {
        this.nameLong = value;
    }

    /**
     * Gets the value of the ancestry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAncestry() {
        return ancestry;
    }

    /**
     * Sets the value of the ancestry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAncestry(String value) {
        this.ancestry = value;
    }

    /**
     * Gets the value of the links property.
     * 
     * @return
     *     possible object is
     *     {@link CFGLinks }
     *     
     */
    public CFGLinks getLinks() {
        return links;
    }

    /**
     * Sets the value of the links property.
     * 
     * @param value
     *     allowed object is
     *     {@link CFGLinks }
     *     
     */
    public void setLinks(CFGLinks value) {
        this.links = value;
    }

}
