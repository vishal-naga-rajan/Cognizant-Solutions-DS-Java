package com.cognizant.spring_learn_country_lookup.controller;

import com.cognizant.spring_learn_country_lookup.model.country;
import com.cognizant.spring_learn_country_lookup.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    @GetMapping("/country/{code}")
    public country getCountry(@PathVariable String code) {
        LOGGER.info("START getCountry()");
        country result = countryService.getCountry(code);
        LOGGER.info("END getCountry()");
        return result;
    }
}
