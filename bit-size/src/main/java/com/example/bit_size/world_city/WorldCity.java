package com.example.bit_size.world_city;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorldCity {
    private String city;
    private String city_ascii;
    private String lat;
    private String lng;
    private String country;
    private String iso2;
    private String iso3;
    private String admin_name;
    private String capital;
    private String population;
    private String id;
}
