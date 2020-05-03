package com.example.IPApp.transformer;

import com.example.IPApp.connector.InfoConnector;
import com.example.IPApp.dto.ConversionDTO;
import com.example.IPApp.dto.InfoDTO;
import com.example.IPApp.error.Error;
import com.example.IPApp.model.InfoResponse;
import com.example.IPApp.utils.GeoHelper;
import com.example.IPApp.utils.InfoHelper;
import org.springframework.stereotype.Component;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class IPTransformer {
    private final InfoConnector infoConnector;
    private final InfoHelper infoHelper;
    private final GeoHelper geoHelper;

    public IPTransformer(InfoConnector infoConnector, InfoHelper infoHelper, GeoHelper geoHelper) {
        this.infoConnector = infoConnector;
        this.infoHelper = infoHelper;
        this.geoHelper = geoHelper;
    }

    public InfoResponse transform(InfoDTO infoDTO) {
        InfoResponse infoResponse = new InfoResponse();
        LocalTime localTime = LocalTime.now(Clock.systemUTC());
        infoResponse.setCurrentTime(localTime.toString());
        infoResponse.setCurrentDate(LocalDate.now().toString());
        String times = infoHelper.concatTimes(localTime, infoDTO.getTimezones());
        infoResponse.setTimes(times);
        infoResponse.setName(infoDTO.getTranslations().getOrDefault("es", Error.UNDEFINED.getMessage()));
        infoResponse.setIsoCode(infoDTO.getAlpha2Code());
        infoResponse.setLanguages(infoHelper.concatLanguages(infoDTO.getLanguages()));
        ConversionDTO conversionDTO = this.infoConnector.getConversion(infoDTO.getCurrencies().get(0).getCode());
        String currencies = infoHelper.concatCurrencies(infoDTO, conversionDTO);
        infoResponse.setCurrencies(currencies);
        infoResponse.setEstimatedDistance(geoHelper.distanceOfBsAsTo(infoDTO.getLatlng()));

        return infoResponse;
    }
}
