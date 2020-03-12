package com.yweather.exception.handler;

import java.io.IOException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
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
     * @param e - exception that caught
     * @return ResponseEntity with exception
     */
    @ExceptionHandler(IOException.class)
    public ResponseEntity<Object> handleStorageConflict(Object e, NativeWebRequest request) {
        log.info(e.toString());
    /*    ExceptionResponseDTO exceptionResponseDTO = ExceptionResponseDTO.builder()
                .message(e.getMessage())
                .timestamp(new Date().getTime())
                .build();*/
       /* HttpServletRequest nativeRequest = request.getNativeRequest(HttpServletRequest.class);
        if (nativeRequest != null) {
            exceptionResponseDTO.setPath(nativeRequest.getRequestURI());
        }*/
        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }

}
