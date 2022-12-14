package com.stussy.stussyclone20220929hyelyeon.handler;

import com.stussy.stussyclone20220929hyelyeon.dto.CMRespDto;
import com.stussy.stussyclone20220929hyelyeon.exception.CustomValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RestControllerAdvice
public class RestControllerExceptionHandler {

    //CustomValidationException의 예외 객체를 낚아챔 - @RestControllerAdvice
    @ExceptionHandler(CustomValidationException.class)
    public ResponseEntity<?> validationErrorException(CustomValidationException e) {
        return ResponseEntity
                .badRequest()
                .body(new CMRespDto<>(-1, e.getMessage(), e.getErrorMap()));
    }

}
