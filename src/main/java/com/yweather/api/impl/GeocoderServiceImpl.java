package com.yweather.api.impl;

import com.yweather.api.parser.GeocodeParser;
import com.yweather.api.service.GeocoderService;
import com.yweather.dto.CoordinateDTO;
import com.yweather.exception.CityNotFoundException;
import com.yweather.exception.ConnectionException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GeocoderServiceImpl implements GeocoderService {

    private static String GEOCODER_URL_NAME = "http://www.mapquestapi.com/geocoding/v1/address?key=";
    private static String GEOCODER_URL_LOCATION = "&location=";

    @Value("${key.geocoder}")
    private String geocoderKey;


    @Override
    public List<CoordinateDTO> getCoordinates(String city) throws ConnectionException {
        URL obj;
        try {
            obj = new URL(GEOCODER_URL_NAME + geocoderKey + GEOCODER_URL_LOCATION + city);

            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            int responseCode = con.getResponseCode();
            log.info("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result

                GeocodeParser geocodeParser = new GeocodeParser();
                CoordinateDTO coordinates;
                try {
                    coordinates = geocodeParser.parseCoordinate(response);
                } catch (CityNotFoundException e) {
                    e.printStackTrace();
                }

                System.out.println(response.toString());
            } else {
                log.info("GET request not worked");
            }
        } catch (IOException e) {
            throw new ConnectionException("");
        }
        return null;
    }
}
