package com.example.IPApp.connector;

import com.example.IPApp.error.Error;
import com.example.IPApp.exception.InfoException;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractInfoConnector {
    protected <T> T makeRequest(String uri, Class<T> clazz) {
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
