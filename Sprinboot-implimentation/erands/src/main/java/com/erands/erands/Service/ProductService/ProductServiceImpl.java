package com.erands.erands.Service.ProductService;

import com.erands.erands.Model.Products;
import com.erands.erands.Model.Store;
import com.erands.erands.Repository.ProductRepository;
import com.erands.erands.Repository.StoreRepository;
import com.erands.erands.RequestObject.ProductRequestObject;
import com.erands.erands.Service.StoreService.StoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;
    @Autowired
    StoreServiceImpl storeServiceImpl;

    @Override
    public String addProduct(ProductRequestObject productRequestObject) {
        Products product = new Products();
        try {
            Optional<Store> store = storeServiceImpl.findStoreById(productRequestObject.getStoreId());
            if (!store.isPresent()) throw new RuntimeException("Invalid entry! Store not found.");

            product.setTitle(productRequestObject.getTitle());
            product.setDescription(productRequestObject.getDescription());
            product.setImage(productRequestObject.getImage());
            product.setPrice(productRequestObject.getPrice());

            store.get().getProducts().add(product);  // Add the product to the store's products
            productRepository.save(product);

            return "Product added successfully";
        } catch (Exception e) {
            return e.toString();
        }

    }

    @Override
    public String deleteProductById(Long id) {
        return null;
    }

    @Override
    public String updateProductById(Long id) {
        return null;
    }

    @Override
    public Products findProductById(Long id) {
        return null;
    }
}
