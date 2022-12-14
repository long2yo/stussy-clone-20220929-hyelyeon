package com.stussy.stussyclone20220929hyelyeon.controller.admin.api;

import com.stussy.stussyclone20220929hyelyeon.aop.annotation.LogAspect;
import com.stussy.stussyclone20220929hyelyeon.aop.annotation.ValidAspect;
import com.stussy.stussyclone20220929hyelyeon.dto.CMRespDto;
import com.stussy.stussyclone20220929hyelyeon.dto.admin.ProductAdditionReqDto;
import com.stussy.stussyclone20220929hyelyeon.dto.validation.ValidationSequence;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/admin")
@RestController
public class ProductApi {

    @ValidAspect
    @LogAspect
    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@Validated(ValidationSequence.class) ProductAdditionReqDto productAdditionReqDto, BindingResult bindingResult) {

        return ResponseEntity.created(null).body(new CMRespDto<>(1, "Successfully", null));
    }
}
