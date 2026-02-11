package com.example.bit_size.weather_forecast_resource;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class WeatherForecastController {

    @GetMapping("/forecast")
    public String getMethodName(@RequestParam String param) {
        return new String("forecasting");
    }
    
}