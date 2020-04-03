package com.yweather.api.service;

import com.yweather.dto.CoordinateDTO;
import com.yweather.dto.FullWeatherDTO;

public interface WeatherService {

	/**
	 * Get weather and other information for place from yandex api
	 *
	 * @param coordinateDTO - places coordinate
	 * @return full weather information about place
	 */
	FullWeatherDTO getFullInfoByCoordinates(CoordinateDTO coordinateDTO);
}
