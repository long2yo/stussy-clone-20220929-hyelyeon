package com.stussy.stussyclone20220929hyelyeon.controller.api;

import com.stussy.stussyclone20220929hyelyeon.aop.annotation.LogAspect;
import com.stussy.stussyclone20220929hyelyeon.aop.annotation.ValidAspect;
import com.stussy.stussyclone20220929hyelyeon.dto.CMRespDto;
import com.stussy.stussyclone20220929hyelyeon.dto.account.RegisterReqDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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

    @LogAspect
    @ValidAspect
    @PostMapping("/register")//RegisterReqDto - date를 받음
    public ResponseEntity<?> register(@Valid @RequestBody RegisterReqDto registerReqDto, BindingResult bindingResult) {

//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();

        if(bindingResult.hasErrors()) {
            log.error("유효성 검사 오류가 발생");
            Map<String, String> errorMap = new HashMap<String, String>();

            List<List<FieldError>> codeList = new ArrayList<List<FieldError>>();
            codeList.add(new ArrayList<FieldError>());  //Pattern
            codeList.add(new ArrayList<FieldError>());  //NotBlank


            bindingResult.getFieldErrors().forEach(error -> {
                errorMap.put(error.getField(), error.getDefaultMessage());

                if (error.getCode().equals("Pattern")) {
                    codeList.get(0).add(error);
                } else if (error.getCode().equals("NotBlank")) {
                    codeList.get(1).add(error);
                }
            });

            log.info("codeList: {}", codeList);

            codeList.forEach(errorMapList -> {
                errorMapList.forEach(error -> {
                    errorMap.put(error.getField(), error.getDefaultMessage());
                });
                log.info("error: {}", errorMap);

            });

            return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "유효성 검사 실패", errorMap));
        }
            log.info("{}", registerReqDto);

//            stopWatch.stop();
//
//            log.info("메소드 실행시간 >>> {}", stopWatch.getTotalTimeSeconds());

//방법2
//            bindingResult.getFieldErrors().forEach(error -> {
//                log.info("Error: 코드({}), 필드명({}), 메세지({})", error.getCode(), error.getField(), error.getDefaultMessage());
//                if(!error.getCode().equals("NotBlank")) {
//                    errorMap.put(error.getField(), error.getDefaultMessage());
//                }
//            });
//            bindingResult.getFieldErrors().forEach(error -> {
//                log.info("Error: 코드({}), 필드명({}), 메세지({})", error.getCode(), error.getField(), error.getDefaultMessage());
//                if(error.getCode().equals("NotBlank")) {
//                    errorMap.put(error.getField(), error.getDefaultMessage());
//                }
//            });
//
//          return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "유효성 검사 실패", errorMap));
//        }

        log.info("{}", registerReqDto);

        return  ResponseEntity.ok(null);
    }

}
