package com.stussy.stussyclone20220929hyelyeon.controller.api;

import com.stussy.stussyclone20220929hyelyeon.aop.annotation.LogAspect;
import com.stussy.stussyclone20220929hyelyeon.aop.annotation.ValidAspect;
import com.stussy.stussyclone20220929hyelyeon.dto.CMRespDto;
import com.stussy.stussyclone20220929hyelyeon.dto.account.RegisterReqDto;
import com.stussy.stussyclone20220929hyelyeon.dto.validation.ValidationSequence;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/api/account")
@RestController
public class AccountApi {

    @LogAspect//로그찍기
    @ValidAspect
    @PostMapping("/register")//RegisterReqDto - date를 받음
    public ResponseEntity<?> register(@Validated(ValidationSequence.class) @RequestBody RegisterReqDto registerReqDto, BindingResult bindingResult) {

////        StopWatch stopWatch = new StopWatch();
////        stopWatch.start();

//            log.info("{}", registerReqDto);
//
////            stopWatch.stop();
////
////            log.info("메소드 실행시간 >>> {}", stopWatch.getTotalTimeSeconds());
//
////방법2
////            bindingResult.getFieldErrors().forEach(error -> {
////                log.info("Error: 코드({}), 필드명({}), 메세지({})", error.getCode(), error.getField(), error.getDefaultMessage());
////                if(!error.getCode().equals("NotBlank")) {
////                    errorMap.put(error.getField(), error.getDefaultMessage());
////                }
////            });
////            bindingResult.getFieldErrors().forEach(error -> {
////                log.info("Error: 코드({}), 필드명({}), 메세지({})", error.getCode(), error.getField(), error.getDefaultMessage());
////                if(error.getCode().equals("NotBlank")) {
////                    errorMap.put(error.getField(), error.getDefaultMessage());
////                }
////            });
////
////          return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "유효성 검사 실패", errorMap));
////        }

//        log.info("{}", registerReqDto); 로그찍기

        return  ResponseEntity.ok(null);
    }

}
