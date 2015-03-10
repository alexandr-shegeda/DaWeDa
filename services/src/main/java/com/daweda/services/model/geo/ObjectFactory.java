package com.daweda.services.model.geo;

import com.daweda.services.geo.GetGeoIPContext;
import com.daweda.services.geo.GetGeoIPContextResponse;
import com.daweda.services.geo.GetGeoIPResponse;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
* Created by elena on 04.03.15.
*/
@XmlRegistry
public class ObjectFactory {
    private final static QName _GeoIP_QNAME = new QName("http://www.webservicex.net/", "GeoIP");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.webservicex
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link com.daweda.services.geo.GetGeoIPContext }
     *
     */
    public GetGeoIPContext createGetGeoIPContext() {
        return new GetGeoIPContext();
    }

    /**
     * Create an instance of {@link com.daweda.services.geo.GetGeoIPResponse }
     *
     */
    public GetGeoIPResponse createGetGeoIPResponse() {
        return new GetGeoIPResponse();
    }

    /**
     * Create an instance of {@link GeoIP }
     *
     */
    public GeoIP createGeoIP() {
        return new GeoIP();
    }

    /**
     * Create an instance of {@link GetGeoIP }
     *
     */
    public GetGeoIP createGetGeoIP() {
        return new GetGeoIP();
    }

    /**
     * Create an instance of {@link com.daweda.services.geo.GetGeoIPContextResponse }
     *
     */
    public GetGeoIPContextResponse createGetGeoIPContextResponse() {
        return new GetGeoIPContextResponse();
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link GeoIP }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.webservicex.net/", name = "GeoIP")
    public JAXBElement<GeoIP> createGeoIP(GeoIP value) {
        return new JAXBElement<GeoIP>(_GeoIP_QNAME, GeoIP.class, null, value);
    }

}
