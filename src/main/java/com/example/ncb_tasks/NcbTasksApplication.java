package com.example.ncb_tasks;

import com.example.ncb_tasks.Countries.CountryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class NcbTasksApplication {
    public static void main(String[] args) {

        ApplicationContext apc = SpringApplication.run(NcbTasksApplication.class, args);
        CountryService countryService = new CountryService(apc.getBean(RestTemplate.class));
        countryService.printCountriesPerContinent();
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
