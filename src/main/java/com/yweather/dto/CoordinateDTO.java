package com.yweather.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CoordinateDTO {
    private String name;
    private double latitude;
    private double longitude;
}
