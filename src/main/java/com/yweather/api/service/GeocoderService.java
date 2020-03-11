package com.yweather.api.service;

import com.yweather.dto.CoordinateDTO;
import java.util.List;

public interface GeocoderService {
    /**
     * Get coordinates of city
     * @param city - name of city
     * @return all coordinates for places with same name
     */
    List<CoordinateDTO> getCoordinates(String city);
}
