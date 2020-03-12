package com.yweather;


import com.yweather.api.service.GeocoderService;
import com.yweather.exception.ConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController
public class YWeatherApplication {

    @Autowired
    private GeocoderService geocoderService;

    @RequestMapping("/")
    String home() throws ConnectionException {
        geocoderService.getCoordinates("B32424242");
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(YWeatherApplication.class, args);
    }

}
