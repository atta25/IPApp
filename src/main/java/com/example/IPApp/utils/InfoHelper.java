package com.example.IPApp.utils;

import com.example.IPApp.dto.ConversionDTO;
import com.example.IPApp.dto.InfoDTO;
import com.example.IPApp.dto.LanguageDTO;
import org.springframework.stereotype.Component;
import java.time.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class InfoHelper {
    public String concatTimes(LocalTime localTime, List<String> timeZones) {
        List<String> result = timeZones.stream().map(tz -> buildTime(tz, localTime)).collect(Collectors.toList());
        return String.join(" or ", result);
    }

    private static String buildTime(String timeZone, LocalTime tz) {
        if (timeZone.equals("UTC")) {
            return String.format("%s (%s)", tz.toString(), timeZone);
        } else if (timeZone.contains("+")) {
            String i = timeZone.substring(4,9);
            List<String> elements = Arrays.asList(i.split(":"));
            int h = Integer.parseInt(elements.get(0));
            int m = Integer.parseInt(elements.get(1));
            LocalTime lth = tz.plusHours(h);
            LocalTime result = lth.plusMinutes(m);
            return String.format("%s (%s)", result.toString(), timeZone);
        } else {
            String i = timeZone.substring(4,9);
            List<String> elements = Arrays.asList(i.split(":"));
            int h = Integer.parseInt(elements.get(0));
            int m = Integer.parseInt(elements.get(1));
            LocalTime lth = tz.minusHours(h);
            LocalTime result = lth.minusMinutes(m);
            return String.format("%s (%s)", result.toString(), timeZone);
        }
    }

    public String concatLanguages(List<LanguageDTO> languages) {
        List<String> languageNames = languages.stream().map(LanguageDTO::getName).collect(Collectors.toList());
        return String.join(", ", languageNames);
    }

    public String concatCurrencies(InfoDTO infoDTO, ConversionDTO conversion) {
        String code = infoDTO.getCurrencies().get(0).getCode();
        String amountUSD = conversion.getRates().get("USD");
        return (amountUSD != null) ? String.format("%s (1 %s = %s U$S)", code, code, amountUSD) : code;
    }
}
