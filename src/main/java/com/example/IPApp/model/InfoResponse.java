package com.example.IPApp.model;

public class InfoResponse {
    private String currentDate;
    private String currentTime;
    private String name;
    private String isoCode;
    private String currencies;
    private String times;
    private String languages;
    private Integer estimatedDistance;
    private Integer minimalDistance;
    private Integer maximumDistance;
    private Integer averageDistance;

    public InfoResponse() { }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String countryISOCode) {
        this.isoCode = countryISOCode;
    }

    public String getCurrencies() {
        return currencies;
    }

    public void setCurrencies(String currencies) {
        this.currencies = currencies;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public Integer getEstimatedDistance() {
        return estimatedDistance;
    }

    public void setEstimatedDistance(Integer estimatedDistance) {
        this.estimatedDistance = estimatedDistance;
    }

    public Integer getMinimalDistance() {
        return minimalDistance;
    }

    public void setMinimalDistance(Integer minimalDistance) {
        this.minimalDistance = minimalDistance;
    }

    public Integer getMaximumDistance() {
        return maximumDistance;
    }

    public void setMaximumDistance(Integer maximumDistance) {
        this.maximumDistance = maximumDistance;
    }

    public Integer getAverageDistance() {
        return averageDistance;
    }

    public void setAverageDistance(Integer averageDistance) {
        this.averageDistance = averageDistance;
    }
}
