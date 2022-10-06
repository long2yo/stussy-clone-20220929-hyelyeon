package com.stussy.stussyclone20220929hyelyeon.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

//예외 객체 생성
@Getter
public class CustomValidationException extends RuntimeException{

    private Map<String, String> errorMap;

    public CustomValidationException(String message, Map<String, String> errorMap){
        super(message);
        this.errorMap = errorMap;
    }



}
