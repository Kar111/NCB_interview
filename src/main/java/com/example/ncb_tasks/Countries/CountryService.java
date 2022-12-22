package com.example.ncb_tasks.Countries;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CountryService {

    private final String CountryUrl = "https://restcountries.com/v3.1/all ";
    private final RestTemplate restTemplate;

    public CountryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void  printCountriesPerContinent() {
        List<CountryDTO>  response = restTemplate.exchange(CountryUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<CountryDTO>>() {} ).getBody();

        Map<List<String>, List<CountryDTO>> grouped_countries = response.stream()
                .filter(c -> c.getLanguages() != null)
                .filter(c -> c.getLanguages().size() > 1)
                .collect(Collectors.groupingBy(CountryDTO::getContinents));

        Map<List<String>, List<CountryDTO>> result = grouped_countries.entrySet().stream().
                collect(Collectors.toMap(Map.Entry::getKey,
                        e -> e.getValue().stream()
                                .sorted(Comparator.comparingLong(CountryDTO::getPopulation))
                                .limit(10).collect(Collectors.toList())));

        result.forEach((continent, countries) -> {
                System.out.println(continent.get(0));
                countries.forEach(System.out::println);
                System.out.println();
        });
    }
}
