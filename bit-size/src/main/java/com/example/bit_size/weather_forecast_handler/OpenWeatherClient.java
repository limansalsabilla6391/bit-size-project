package com.example.bit_size.weather_forecast_handler;

import java.net.URI;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OpenWeatherClient {
    public String fetchWeatherData(String lat, String lon) {
        WebClient openWeatherWebClient = WebClient.create();

        return openWeatherWebClient.get()
        .uri(URI.create("https://api.openweathermap.org/data/3.0/onecall?lat=" + lat + "&lon=" + lon + "&appid=appid"))
        .retrieve()
        .bodyToMono(String.class)
        .block();
    }
}
