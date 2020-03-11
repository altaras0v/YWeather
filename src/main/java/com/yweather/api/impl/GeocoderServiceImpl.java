package com.yweather.api.impl;

import com.yweather.api.service.GeocoderService;
import com.yweather.dto.CoordinateDTO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GeocoderServiceImpl implements GeocoderService {
    @Override
    public List<CoordinateDTO> getCoordinates(String city) {
        URL obj = new URL("https://api.weather.yandex.ru/v1/forecast?lat=55.75396&lon=37.62039");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        int responseCode = con.getResponseCode();
        log.info("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result

            System.out.println(response.toString());
        } else {
            log.info("GET request not worked");
        }}
        return null;
    }
}
