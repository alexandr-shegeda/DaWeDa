package com.daweda.services.model.lightstreamer;

import java.util.Map;

/**
 * Created by Alexandr Shegeda on 05.03.2015.
 */
public class LSMessage
{
    private String description;
    private String sTime;
    private String eTime;
    private String minPrice;
    private String maxPrice;

    public LSMessage()
    {
        this.description = "-";
        this.sTime =  "-";
        this.eTime = "-";
        this.minPrice =  "-";
        this.maxPrice =  "-";
    }

    public LSMessage(Map<String,String> message)
    {
        this.description = (message.get("description")== null) ? "-" : message.get("description");
        this.sTime =  (message.get("sTime")== null) ? "-" : message.get("sTime");
        this.eTime = (message.get("eTime")== null) ? "-" : message.get("eTime");
        this.minPrice =  (message.get("minPrice")== null) ? "-" : message.get("minPrice");
        this.maxPrice =  (message.get("maxPrice")== null) ? "-" : message.get("maxPrice");
    }

    public LSMessage(String description, String sTime, String eTime, String minPrice, String maxPrice) {
        this.description = description;
        this.sTime = sTime;
        this.eTime = eTime;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getsTime() {
        return sTime;
    }

    public void setsTime(String sTime) {
        this.sTime = sTime;
    }

    public String geteTime() {
        return eTime;
    }

    public void seteTime(String eTime) {
        this.eTime = eTime;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public void setMessage(Map<String,String> message)
    {
        this.description = (message.get("description")==null) ? "-" : message.get("description");
        this.sTime =  (message.get("sTime")==null) ? "-" : message.get("sTime");
        this.eTime = (message.get("eTime")==null) ? "-" : message.get("eTime");
        this.minPrice =  (message.get("minPrice")==null) ? "-" : message.get("minPrice");
        this.maxPrice =  (message.get("maxPrice")==null) ? "-" : message.get("maxPrice");
    }

    @Override
    public String toString() {
        return  description + "|" + sTime + "|" + eTime + "|" + minPrice + "|" + maxPrice;
    }
}
