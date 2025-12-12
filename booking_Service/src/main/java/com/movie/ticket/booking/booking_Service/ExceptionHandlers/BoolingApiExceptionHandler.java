package com.movie.ticket.booking.booking_Service.ExceptionHandlers;

import com.movie.ticket.booking.booking_Service.dtos.ResponseDTo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

import static org.springframework.validation.BindingResultUtils.getBindingResult;

@RestControllerAdvice
@Slf4j
public class BoolingApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTo>  methodArgumentNotValidException(MethodArgumentNotValidException excetion){
        log.info("Entered into bookingApiHandler class with the exceptio "+excetion.getMessage());
       List<ObjectError > errors =  excetion.getBindingResult().getAllErrors();
        ResponseDTo responseDTo = ResponseDTo.builder().errorMessage(errors.get(0).getDefaultMessage()).build();
        return new ResponseEntity<ResponseDTo>(responseDTo, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseDTo> runtimeException(RuntimeException runtimeException){

        return new ResponseEntity<ResponseDTo>(
                ResponseDTo.builder().errorDescription(runtimeException.getMessage())
                        .build(),HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
