package com.yweather.api.service;

import com.yweather.dto.CoordinateDTO;
import com.yweather.exception.CityNotFoundException;
import com.yweather.exception.ConnectionException;

public interface GeocoderService {
    /**
     * Get coordinates of city
     * @param city - name of city
     * @return coordinates for places with same name
     */
    CoordinateDTO getCoordinates(String city) throws ConnectionException, CityNotFoundException;
}
