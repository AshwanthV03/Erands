package com.erands.erands.Controller;

import com.erands.erands.Model.Products;
import com.erands.erands.RequestObject.StoreRequestObject;
import com.erands.erands.Service.StoreService.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/store")
public class StoreConroller {
    @Autowired
    StoreService storeService;
    @PostMapping("/createStore")
    public String createStore(@RequestBody StoreRequestObject storeRequestObject) throws Exception {
        System.out.println(storeRequestObject);
        return storeService.createStore(storeRequestObject);
    }
    @GetMapping(path = "/getStoreProduct/{id}")
    public List<Products> getAllStoreProducts(@PathVariable Long id){

        return storeService.storeProducts(id);
    }
    @GetMapping(path = "/getStoreProductById/{id}")
    public Products getStoreProductById(@PathVariable Long id){
        return storeService.findStoreProductById(id);
    }
    @PostMapping(path = "/updateStoreProductById/{id}")
    public String updateStoreProductById(@PathVariable Long id , @RequestBody Products products){
        return  storeService.updateStoreProductsById(id,products);
    }
}
