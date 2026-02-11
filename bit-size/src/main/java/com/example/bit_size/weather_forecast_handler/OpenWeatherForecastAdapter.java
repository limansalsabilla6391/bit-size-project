package com.example.bit_size.weather_forecast_handler;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.example.bit_size.weather_forecast.WeatherForecastRepository;
import com.example.bit_size.world_city.WorldCityRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Profile("open-weather")
public class OpenWeatherForecastAdapter implements WeatherForecastRepository {
    private WorldCityRepository worldCityRepository;
    
    @Override
    public String fetchForecastData(String location) {
        String[] latLong = worldCityRepository
            .fetchCityLocation(location)
            .orElse(new String[]{"0", "0"});
        return "open weather adapter";
    }
}
