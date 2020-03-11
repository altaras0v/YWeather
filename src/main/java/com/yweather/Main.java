package com.yweather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.springframework.http.HttpHeaders.USER_AGENT;


public class Main {

	public static void main(String[] args) throws IOException {
		//URL obj = new URL("https://api.weather.yandex.ru/v1/forecast?lat=55.75396&lon=37.62039");
		URL obj = new URL("https://geocode-maps.yandex.ru/1.x/?apikey=89a21dc5-0815-4fd4-8cc4-29fa97d4ad99&geocode=Москва");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		//con.setRequestMethod("GET");
		//con.setRequestProperty("User-Agent", USER_AGENT);
		//con.addRequestProperty("X-Yandex-API-Key", "bcbbd70a-2121-4f6d-904b-072917e351e6");
		//con.setRequestProperty();
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
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
			System.out.println("GET request not worked");
		}}

}
