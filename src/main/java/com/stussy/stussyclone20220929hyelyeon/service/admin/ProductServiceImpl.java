package com.stussy.stussyclone20220929hyelyeon.service.admin;


import com.stussy.stussyclone20220929hyelyeon.domain.ProductImgFile;
import com.stussy.stussyclone20220929hyelyeon.dto.admin.ProductAdditionReqDto;

import com.stussy.stussyclone20220929hyelyeon.dto.admin.ProductAdditionReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    @Value("${file.path}")
    private String filePath;

    private final ProductRepository productRepository;

    @Override
    public boolean addProduct(ProductAdditionReqDto productAdditionReqDto) throws Exception {
        List<MultipartFile> files = productAdditionReqDto.getFiles();
        List<ProductImgFile> productImgFiles = null;

        productRepository.save();

        if(files != null) {
           productImgFiles = getProductImgFiles(files);
        }



        return false;
    }

    private List<ProductImgFile> getProductImgFiles(List<MultipartFile> files) throws Exception {
        List<ProductImgFile> productImgFiles = new ArrayList<ProductImgFile>();

        files.forEach(file -> {
            String originName = file.getOriginalFilename();
            String extension = originName.substring(originName.lastIndexOf("."));
            String temp_name = UUID.randomUUID().toString() + extension;

            Path uploadPath = Paths.get(filePath + "/product" + temp_name);

            File f = new File(filePath + "/product");
            if (!f.exists()) {
                f.mkdir();
            }

            try {
                Files.write(uploadPath, file.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            ProductImgFile productImgFile = ProductImgFile.builder()
                    .product_id(0)
                    .origin_name(originName)
                    .temp_name(temp_name)
                    .build();

            productImgFiles.add(productImgFile);
        });

        return productImgFiles;
    }
}
