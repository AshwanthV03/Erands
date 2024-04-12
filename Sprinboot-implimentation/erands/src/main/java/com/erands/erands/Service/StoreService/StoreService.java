package com.erands.erands.Service.StoreService;

import com.erands.erands.Model.Products;
import com.erands.erands.Model.Store;
import com.erands.erands.RequestObject.StoreRequestObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface StoreService {
    public String  createStore(StoreRequestObject storeRequestObject) throws Exception;
    public String deleteStoreById(Long id);
    public String updateStoreById(Long id,Store changeStore);
    public Optional<Store> findStoreById(Long id);
    public List<Products> storeProducts(Long id);
    public Products findStoreProductById(Long id);
    public String updateStoreProductsById(Long id , Products products);
}
