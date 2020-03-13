package com.yweather.exception;

import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ConnectionException extends IOException {

    public ConnectionException(){}

    public ConnectionException(String message){super(message);}
}
