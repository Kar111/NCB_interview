package com.example.ncb_tasks.Countries;

import lombok.Data;

import java.util.List;
import java.util.Map;


@Data
public class CountryDTO {
    Name name;
    Long population;
    List<String> continents;
    Map<String, String> languages;
}
