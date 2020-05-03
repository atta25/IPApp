package com.example.IPApp.dto;

import java.util.Map;

public class ConversionDTO {
    private Map<String, String> rates;

    public ConversionDTO() { }

    public Map<String, String> getRates() {
        return rates;
    }

    public void setRates(Map<String, String> rates) {
        this.rates = rates;
    }
}
