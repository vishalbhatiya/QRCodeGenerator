package com.example.qr_Code_generator;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

@RestController
public class QRCodeGenController {

    @PostMapping(value = "/zxing/qrcode",produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage>zxingQRCode(@RequestBody String barcode)throws Exception{
        return successResponse(CodeGenerator.generatedQRCode(barcode));

    }

    private ResponseEntity<BufferedImage> successResponse(BufferedImage image) {
        return new ResponseEntity<>(image, HttpStatus.OK);
    }

    @Bean
    public HttpMessageConverter<BufferedImage>createImageHttpMessageConvertor(){
        return new BufferedImageHttpMessageConverter();
    }
}
