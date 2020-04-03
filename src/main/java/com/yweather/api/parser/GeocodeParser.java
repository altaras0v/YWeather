package com.yweather.api.parser;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import com.yweather.dto.CoordinateDTO;
import com.yweather.exception.CityNotFoundException;
import com.yweather.exception.ConnectionException;
import net.minidev.json.JSONArray;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GeocodeParser {

	public CoordinateDTO parseCoordinate(StringBuffer geocode) throws CityNotFoundException, ConnectionException {
		JSONArray city;
		try {
			city = JsonPath.read(geocode.toString(), "$.results[*].locations[*].adminArea5");
		} catch (PathNotFoundException e) {
			throw new ConnectionException();
		}
		CoordinateDTO coordinates = new CoordinateDTO();
		if (!city.get(0).equals("")) {
			List<LinkedHashMap> geographicalCoordinates =
                    JsonPath.read(geocode.toString(), "$.results[*].locations[*].displayLatLng");
			Set<Map.Entry<String, Double>> mapSet = geographicalCoordinates.get(0).entrySet();

			coordinates.setLatitude((new ArrayList<>(mapSet)).get(0).getValue());
			coordinates.setLongitude((new ArrayList<>(mapSet)).get(1).getValue());
			coordinates.setName(city.get(0).toString());
		}
		else {
			throw new CityNotFoundException("City is not found");
		}
		return coordinates;
	}
}
