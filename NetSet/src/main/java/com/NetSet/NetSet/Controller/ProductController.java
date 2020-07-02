package com.NetSet.NetSet.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.NetSet.NetSet.Repository.ProductPictureRepository;
import com.NetSet.NetSet.Repository.ProductRepository;
import com.NetSet.NetSet.model.ProductPicture;
import com.NetSet.NetSet.model.Products;


@RestController
@RequestMapping(value = "/netset")
public class ProductController {

	@Autowired
    ProductRepository productRepository;

    @GetMapping(value = "/all")
    public List<Products> getAll() {
    	System.out.println("I am IN");
        return productRepository.findAll();
    }

    @PostMapping(value = "/load")
    public List<Products> persist(@RequestBody final Products products) {
    	System.out.println("I am IN  load");
    	productRepository.save(products);
        return productRepository.findAll();
    }
    
    @Autowired
    ProductPictureRepository productPictureRepository;
    @PostMapping(value = "/upload")
    public String PictureUpload(@RequestBody final MultipartFile file) throws IOException {
    	System.out.println("I am IN  upload");
    	String filename = StringUtils.cleanPath(file.getOriginalFilename());
    	ProductPicture productPicture = new ProductPicture(file.getContentType(), filename , file.getBytes() );
    	productPictureRepository.save(productPicture);
    	return "ok";
    }
}
