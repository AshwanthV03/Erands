package com.erands.erands.Controller;

import com.erands.erands.RequestObject.ProductRequestObject;
import com.erands.erands.Service.ProductService.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
    @Autowired
    ProductServiceImpl productServiceImpl;
    @PostMapping(path = "/createProduct")
    public String addProduct(@RequestBody ProductRequestObject productRequestObject){
        return productServiceImpl.addProduct(productRequestObject);
    }
}
