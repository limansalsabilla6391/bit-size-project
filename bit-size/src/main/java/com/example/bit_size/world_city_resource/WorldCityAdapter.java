package com.example.bit_size.world_city_resource;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.example.bit_size.world_city.WorldCity;
import com.example.bit_size.world_city.WorldCityRepository;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import jakarta.annotation.PostConstruct;

@Component
public class WorldCityAdapter implements WorldCityRepository {
    private List<WorldCity> citiesData;

    @PostConstruct
    public void init() {
        citiesData = loadCitiesData();
    }
    
    @Override
    public Optional<String[]> fetchCityLocation(String cityName) {

        return citiesData
            .stream()
            .filter(city -> city.getCity().equalsIgnoreCase(cityName))
            .map(city -> new String[]{city.getLat(), city.getLng()})
            .findFirst();
    }

    private List<WorldCity> loadCitiesData() {
        try {

            ClassPathResource resource = new ClassPathResource("worldcities.csv");
            CsvMapper csvMapper = new CsvMapper();
            CsvSchema schema = CsvSchema.emptySchema().withHeader();

            MappingIterator<WorldCity> iterator = csvMapper
                .readerFor(WorldCity.class)
                .with(schema)
                .readValues(resource.getInputStream());

            return iterator.readAll();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load city data");
        }
    }
}
