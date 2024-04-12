package com.erands.erands.Service.ProductService;

import com.erands.erands.Model.Products;
import com.erands.erands.RequestObject.ProductRequestObject;
import org.springframework.stereotype.Service;

public interface ProductService {
    public String addProduct(ProductRequestObject productRequestObject);
    public String deleteProductById(Long id);
    public String updateProductById(Long id);
    public Products findProductById(Long id);
}
