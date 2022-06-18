package com.fedormulashkin.changeusd.entity;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;

import java.util.*;

public class Exchange {
    private String disclaimer;
    private String license;
    private long timestamp;
    private String base;
    private HashMap<String, Double> rates;

    public Exchange() {
    }

    public Exchange(String disclaimer, String license, long timestamp, String base, HashMap<String, Double> rates) {
        this.disclaimer = disclaimer;
        this.license = license;
        this.timestamp = timestamp;
        this.base = base;
        this.rates = rates;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public HashMap<String, Double> getRates() {
        return rates;
    }

    public void setRates(HashMap<String, Double> rates) {
        this.rates = rates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exchange exchange = (Exchange) o;

        if (getTimestamp() != exchange.getTimestamp()) return false;
        if (getDisclaimer() != null ? !getDisclaimer().equals(exchange.getDisclaimer()) : exchange.getDisclaimer() != null)
            return false;
        if (getLicense() != null ? !getLicense().equals(exchange.getLicense()) : exchange.getLicense() != null)
            return false;
        if (getBase() != null ? !getBase().equals(exchange.getBase()) : exchange.getBase() != null) return false;
        return getRates() != null ? getRates().equals(exchange.getRates()) : exchange.getRates() == null;
    }

    @Override
    public int hashCode() {
        int result = getDisclaimer() != null ? getDisclaimer().hashCode() : 0;
        result = 31 * result + (getLicense() != null ? getLicense().hashCode() : 0);
        result = 31 * result + (int) (getTimestamp() ^ (getTimestamp() >>> 32));
        result = 31 * result + (getBase() != null ? getBase().hashCode() : 0);
        result = 31 * result + (getRates() != null ? getRates().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Exchange{" +
                "disclaimer='" + disclaimer + '\'' +
                ", license='" + license + '\'' +
                ", timestamp=" + timestamp +
                ", base='" + base + '\'' +
                ", rates=" + rates +
                '}';
    }
}
