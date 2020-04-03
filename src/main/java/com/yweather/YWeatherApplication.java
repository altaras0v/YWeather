package com.yweather;


import com.yweather.api.service.GeocoderService;
import com.yweather.dto.CoordinateDTO;
import com.yweather.exception.CityNotFoundException;
import com.yweather.exception.ConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Controller
public class YWeatherApplication {

	@Autowired
	private GeocoderService geocoderService;

	public static void main(String[] args) {
		SpringApplication.run(YWeatherApplication.class, args);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	String home() throws ConnectionException, CityNotFoundException {
		//B32424242
		CoordinateDTO coordinateDTO = geocoderService.getCoordinates("Moscow");
		return "main";
	}

}
