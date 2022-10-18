package com.stussy.stussyclone20220929hyelyeon.service.admin;

import com.stussy.stussyclone20220929hyelyeon.dto.admin.ProductAdditionReqDto;

public interface ProductService {
    public boolean addProduct(ProductAdditionReqDto productAdditionReqDto) throws Exception;
}
