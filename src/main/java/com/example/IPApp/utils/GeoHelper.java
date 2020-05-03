package com.example.IPApp.utils;

import com.example.IPApp.error.Error;
import com.example.IPApp.exception.InfoException;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class GeoHelper {
    private final static double LAT_ARG = -34;
    private final static double LONG_ARG = -64;

    public Integer distanceOfBsAsTo(List<Double> coordinates) {
        this.validateCoordinates(coordinates);
        double lat2 = coordinates.get(0);
        double lng2 = coordinates.get(1);
        double radioEarth = 6371;
        double dLat = Math.toRadians(lat2 - LAT_ARG);
        double dLng = Math.toRadians(lng2 - LONG_ARG);
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                                          * Math.cos(Math.toRadians(LAT_ARG))
                                          * Math.cos(Math.toRadians(lat2));
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
        double distance = radioEarth * va2;

        return (int) distance;
    }

    private void validateCoordinates(List<Double> coordinates) {
        if (coordinates == null || coordinates.size() != 2) {
            throw new InfoException(Error.INCONSISTENT_DATA.getMessage());
        }
    }
}
