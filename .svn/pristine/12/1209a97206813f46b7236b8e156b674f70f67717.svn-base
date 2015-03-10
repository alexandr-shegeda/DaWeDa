package com.daweda.services.model;

/**
 * Created by Alexandr_Shegeda on 24.02.2015.
 */
public class Adapter
{
    private String adapterName;
    private String host;
    private String port;

    public Adapter() {
    }

    public Adapter(String adapterName, String host, String port) {
        this.adapterName = adapterName;
        this.host = host;
        this.port = port;
    }

    public String getAdapterName() {
        return adapterName;
    }

    public void setAdapterName(String adapterName) {
        this.adapterName = adapterName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Adapter adapter = (Adapter) o;

        if (!adapterName.equals(adapter.adapterName)) return false;
        if (!host.equals(adapter.host)) return false;
        if (!port.equals(adapter.port)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = adapterName.hashCode();
        result = 31 * result + host.hashCode();
        result = 31 * result + port.hashCode();
        return result;
    }
}
