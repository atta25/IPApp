package com.example.IPApp.service;

import com.example.IPApp.repository.Repository;
import com.example.IPApp.transformer.IPTransformer;
import com.example.IPApp.connector.InfoConnector;
import com.example.IPApp.dto.CountryInfoDTO;
import com.example.IPApp.dto.InfoDTO;
import com.example.IPApp.model.InfoResponse;
import org.springframework.stereotype.Component;

@Component
public class CountryInfoService {
    private final InfoConnector infoConnector;
    private final IPTransformer ipTransformer;
    private final Repository repository;

    public CountryInfoService(InfoConnector infoConnector, IPTransformer ipTransformer, Repository repository) {
        this.infoConnector = infoConnector;
        this.ipTransformer = ipTransformer;
        this.repository = repository;
    }

    public InfoResponse getInfo(String ip) {
        InfoResponse infoResponse = this.buildInfo(ip);
        this.saveInfo(infoResponse);
        this.updateInfoResponse(infoResponse);

        return infoResponse;
    }

    private InfoResponse buildInfo(String ip) {
        CountryInfoDTO countryInfoDTO = this.infoConnector.getCountryInfoId(ip);
        String countryName = countryInfoDTO.getCountryName();
        InfoDTO infoDTO = this.infoConnector.getCountryInfo(countryName);
        return this.ipTransformer.transform(infoDTO);
    }

    private void saveInfo(InfoResponse infoResponse) {
        repository.save(infoResponse);
    }

    private void updateInfoResponse(InfoResponse infoResponse) {
        infoResponse.setMinimalDistance(repository.getMinimalDistance());
        infoResponse.setMaximumDistance(repository.getMaximumDistance());
        infoResponse.setAverageDistance(repository.getAverageDistance());
    }
}
