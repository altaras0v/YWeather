package com.yweather.api.impl;

import com.yweather.api.service.WeatherService;
import com.yweather.dto.CoordinateDTO;
import com.yweather.dto.FullWeatherDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WeatherServiceImpl implements WeatherService {
	@Override
	public FullWeatherDTO getFullInfoByCoordinates(CoordinateDTO coordinateDTO) {
		return null;
	}
}
