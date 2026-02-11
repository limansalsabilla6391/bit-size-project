package com.example.bit_size.world_city;

import java.util.Optional;

public interface WorldCityRepository {
    default Optional<String[]> fetchCityLocation(String cityName) {
        return Optional.empty();
    }
}
