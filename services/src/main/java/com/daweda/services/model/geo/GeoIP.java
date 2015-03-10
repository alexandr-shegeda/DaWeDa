package com.daweda.services.model.geo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
* Created by elena on 04.03.15.
*/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeoIP", propOrder = {
        "returnCode",
        "ip",
        "returnCodeDetails",
        "countryName",
        "countryCode"
})
public class GeoIP {
    @XmlElement(name = "ReturnCode")
    protected int returnCode;
    @XmlElement(name = "IP")
    protected String ip;
    @XmlElement(name = "ReturnCodeDetails")
    protected String returnCodeDetails;
    @XmlElement(name = "CountryName")
    protected String countryName;
    @XmlElement(name = "CountryCode")
    protected String countryCode;

    /**
     * Gets the value of the returnCode property.
     *
     */
    public int getReturnCode() {
        return returnCode;
    }

    /**
     * Sets the value of the returnCode property.
     *
     */
    public void setReturnCode(int value) {
        this.returnCode = value;
    }

    /**
     * Gets the value of the ip property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIP() {
        return ip;
    }

    /**
     * Sets the value of the ip property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIP(String value) {
        this.ip = value;
    }

    /**
     * Gets the value of the returnCodeDetails property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getReturnCodeDetails() {
        return returnCodeDetails;
    }

    /**
     * Sets the value of the returnCodeDetails property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setReturnCodeDetails(String value) {
        this.returnCodeDetails = value;
    }

    /**
     * Gets the value of the countryName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Sets the value of the countryName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCountryName(String value) {
        this.countryName = value;
    }

    /**
     * Gets the value of the countryCode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

}
