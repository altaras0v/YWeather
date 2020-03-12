package com.yweather.exception;

import java.io.IOException;

public class CityNotFoundException extends IOException {
    public CityNotFoundException() {
    }

    public CityNotFoundException(String message) {
        super(message);
    }
}
