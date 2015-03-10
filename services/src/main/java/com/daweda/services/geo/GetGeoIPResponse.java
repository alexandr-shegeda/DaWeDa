package com.daweda.services.geo;

import com.daweda.services.model.geo.GeoIP;

import javax.xml.bind.annotation.*;

/**
* Created by elena on 04.03.15.
*/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getGeoIPResult"
})
@XmlRootElement(name = "GetGeoIPResponse")

public class GetGeoIPResponse {
    @XmlElement(name = "GetGeoIPResult")
    protected GeoIP getGeoIPResult;

    /**
     * Gets the value of the getGeoIPResult property.
     *
     * @return
     *     possible object is
     *     {@link GeoIP }
     *
     */
    public GeoIP getGetGeoIPResult() {
        return getGeoIPResult;
    }

    /**
     * Sets the value of the getGeoIPResult property.
     *
     * @param value
     *     allowed object is
     *     {@link GeoIP }
     *
     */
    public void setGetGeoIPResult(GeoIP value) {
        this.getGeoIPResult = value;
    }
}
