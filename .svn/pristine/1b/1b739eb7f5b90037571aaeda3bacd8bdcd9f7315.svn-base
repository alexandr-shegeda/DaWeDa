package com.daweda.services.model.geo;

import com.daweda.services.geo.*;

/**
* Created by elena on 04.03.15.
*/
public class Country {
    /**
     * @param ipAddress - user IP address
     * @return user location
     */
    public static String getCountry(String ipAddress){
        GeoIPService ipService = new GeoIPService();
        GeoIPServiceSoap geoIPServiceSoap = ipService.getGeoIPServiceSoap();
        GeoIP geoIP = geoIPServiceSoap.getGeoIP(ipAddress);

        return "Code: " + geoIP.getCountryCode() + "; Name: " + geoIP.getCountryName();
    }
}
