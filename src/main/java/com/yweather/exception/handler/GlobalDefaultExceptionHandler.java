package com.yweather.exception.handler;

import com.yweather.exception.CustomErrorResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;

@Slf4j
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    /**
     * Send entity with exception to view
     *
     * @param ex - exception that caught
     * @return ResponseEntity with exception
     */
    @ExceptionHandler({IOException.class, RuntimeException.class})
    public ResponseEntity<Object> handleStorageConflict(Exception ex, NativeWebRequest request) {
        log.info(ex.toString());
        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());
        errors.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
