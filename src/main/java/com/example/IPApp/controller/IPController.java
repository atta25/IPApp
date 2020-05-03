package com.example.IPApp.controller;

import com.example.IPApp.error.Error;
import com.example.IPApp.exception.InfoException;
import com.example.IPApp.model.InfoResponse;
import com.example.IPApp.repository.Repository;
import com.example.IPApp.service.CountryInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IPController {
    private final CountryInfoService countryInfoService;

    public IPController(CountryInfoService countryInfoService, Repository repository) {
        this.countryInfoService = countryInfoService;
    }

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/{ip}")
    public String getInfo(@PathVariable("ip") String ip, Model model) {
        InfoResponse info = countryInfoService.getInfo(ip);
        model.addAttribute("info", info);
        return "info";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception exception, Model model) {
        String message = (exception instanceof InfoException) ? exception.getMessage() : Error.GENERIC_ERROR.getMessage();
        model.addAttribute("message", message);
        return "error";
    }
}

