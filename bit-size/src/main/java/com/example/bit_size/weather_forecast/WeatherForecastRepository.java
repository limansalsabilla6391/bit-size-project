package com.example.bit_size.weather_forecast;

public interface WeatherForecastRepository {
    default String fetchForecastData(String location) {
        return "Adapter not set";
    }
}
