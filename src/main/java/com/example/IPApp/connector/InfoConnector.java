package com.example.IPApp.connector;

import com.example.IPApp.dto.ConversionDTO;
import com.example.IPApp.dto.CountryInfoDTO;
import com.example.IPApp.dto.InfoDTO;
import com.example.IPApp.error.Error;
import com.example.IPApp.exception.InfoException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import java.util.Arrays;
import java.util.List;

@Component
public class InfoConnector extends AbstractInfoConnector {
    public CountryInfoDTO getCountryInfoId(String ip) {
        final String uri = String.format("https://api.ip2country.info/ip?%s", ip);
        return makeRequest(uri, CountryInfoDTO.class);
    }

    public InfoDTO getCountryInfo(String countryName) {
        final String uri = String.format("https://restcountries.eu/rest/v2/name/%s?fullText=true", countryName);

        InfoDTO[] result = makeRequest(uri, InfoDTO[].class);

        if (result == null || result.length != 1) {
            throw new InfoException(Error.INCONSISTENT_DATA.getMessage());
        }

        List<InfoDTO> list = Arrays.asList(result);

        return CollectionUtils.firstElement(list);
    }

    public ConversionDTO getConversion(String base) {
        final String API_KEY_FIXER_IO = "49ac090af00db05a3536f420d0c96c53";
        final String uri = String.format("http://data.fixer.io/api/latest?access_key=%s&base=%s", API_KEY_FIXER_IO, base);

         return makeRequest(uri, ConversionDTO.class);
    }
}
