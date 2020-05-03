package com.example.IPApp.dto;

import java.util.List;
import java.util.Map;

public class InfoDTO {
    private String alpha2Code;
    private List<LanguageDTO> languages;
    private List<CurrencyDTO> currencies;
    private List<String> timezones;
    private Map<String, String> translations;
    private List<Double> latlng;

    public InfoDTO() { }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public List<LanguageDTO> getLanguages() {
        return languages;
    }

    public void setLanguages(List<LanguageDTO> languages) {
        this.languages = languages;
    }

    public List<CurrencyDTO> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<CurrencyDTO> currencies) {
        this.currencies = currencies;
    }

    public List<String> getTimezones() {
        return timezones;
    }

    public void setTimezones(List<String> timezones) {
        this.timezones = timezones;
    }

    public Map<String, String> getTranslations() {
        return translations;
    }

    public void setTranslations(Map<String, String> translations) {
        this.translations = translations;
    }

    public List<Double> getLatlng() {
        return latlng;
    }

    public void setLatlng(List<Double> latlng) { this.latlng = latlng; }
}
