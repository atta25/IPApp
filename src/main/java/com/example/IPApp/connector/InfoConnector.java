package com.example.IPApp.connector;

import com.example.IPApp.dto.ConversionDTO;
import com.example.IPApp.dto.CountryInfoDTO;
import com.example.IPApp.dto.InfoDTO;
import com.example.IPApp.error.Error;
import com.example.IPApp.exception.InfoException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;

@Component
public class InfoConnector {
    public CountryInfoDTO getCountryInfoId(String ip) {
        final String uri = String.format("https://api.ip2country.info/ip?%s", ip);
        return makeRequest(uri, CountryInfoDTO.class);
    }

    public InfoDTO getInfo(String countryName) {
        final String uri = String.format("https://restcountries.eu/rest/v2/name/%s?fullText=true", countryName);

        InfoDTO[] result = makeRequest(uri, InfoDTO[].class);

        if (result == null || result.length != 1) {
            throw new InfoException(Error.INCONSISTENT_DATA.getMessage());
        }

        return CollectionUtils.firstElement(Arrays.asList(result));
    }

    public ConversionDTO getConversion(String base) {
        final String API_KEY_FIXER_IO = "49ac090af00db05a3536f420d0c96c53";
        final String uri = String.format("http://data.fixer.io/api/latest?access_key=%s&base=%s", API_KEY_FIXER_IO, base);

         return makeRequest(uri, ConversionDTO.class);
    }

    private <T> T makeRequest(String uri, Class<T> clazz) {
        RestTemplate restTemplate = new RestTemplate();
        T result;
        try {
            result = restTemplate.getForObject(uri, clazz);
        } catch (Exception e) {
            throw new InfoException(Error.SERVICE_ERROR.getMessage());
        }

        return result;
    }
}
