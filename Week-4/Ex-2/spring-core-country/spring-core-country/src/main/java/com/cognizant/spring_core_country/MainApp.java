package com.cognizant.spring_core_country;

import com.cognizant.spring_core_country.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) {
        LOGGER.info("START");
        displayCountry();
        LOGGER.info("END");
    }

    public static void displayCountry() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);
        LOGGER.debug("Country : {}", country);
    }
}
