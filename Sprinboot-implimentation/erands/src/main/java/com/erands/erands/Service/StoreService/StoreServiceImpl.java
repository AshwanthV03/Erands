package com.erands.erands.Service.StoreService;

import com.erands.erands.Model.Products;
import com.erands.erands.Model.Seller;
import com.erands.erands.Model.Store;
import com.erands.erands.Repository.ProductRepository;
import com.erands.erands.Repository.SellerRepository;
import com.erands.erands.Repository.StoreRepository;
import com.erands.erands.RequestObject.StoreRequestObject;
import com.erands.erands.Service.ProductService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class StoreServiceImpl implements StoreService{
    @Autowired
    private SellerRepository sellerRepository; // Correct repository
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public String createStore(StoreRequestObject storeRequestObject) throws Exception {
        Store store = new Store();
        store.setStoreName(storeRequestObject.getStoreName());

        Optional<Seller> seller = sellerRepository.findById(storeRequestObject.getSeller_id()); // Correct repository method

        if (seller.isPresent()) {
            store.setSeller(seller.get()); // Get the Seller from Optional
        }else throw new Exception("Seller does not Exist !");
        System.out.println(storeRequestObject);
        try{
            storeRepository.save(store);
        }catch (Exception exception){
            return exception.toString();
        }
        return "Store created";
    }

    @Override
    public String deleteStoreById(Long id) {
        Optional<Store> store= findStoreById(id);
        if(!store.isPresent()) throw new RuntimeException("Store with"+ id + "does not exist");
        storeRepository.deleteById(id);

        return "Store with id:  "+id+" deleted sucessfully";
    }

    @Override
    public String updateStoreById(Long id, Store updatedStoreInfo) {
        Optional<Store> optionalStore = findStoreById(id);

        if (optionalStore.isPresent()) {
            Store existingStore = optionalStore.get();

            existingStore.setStoreName(updatedStoreInfo.getStoreName());
            existingStore.setAddress(updatedStoreInfo.getAddress());
            existingStore.setSeller(updatedStoreInfo.getSeller());

            storeRepository.save(existingStore);

            return "Store with id: " + id + " updated successfully";
        } else {
            throw new RuntimeException("Store with id: " + id + " does not exist");
        }
    }


    @Override
    public Optional<Store> findStoreById(Long id) {
        Optional<Store>store = storeRepository.findById(id);
        if(!store.isPresent()) throw new RuntimeException("Store with id: "+ id + " does not exist");
        return store;
    }
    @Override
    public Products findStoreProductById(Long id) {
        Optional<Products>product = Optional.ofNullable(storeRepository.FindStoreProductById(id));
        if(!product.isPresent()) throw new RuntimeException("Store with id: "+ id + " does not exist");
        return product.get();
    }

    @Override
    public List<Products> storeProducts(Long id) {
       List<Products> products =  storeRepository.findProductsByStoreId(id);
        return products;
    }

    @Override
    public String updateStoreProductsById(Long id,Products products){
        Optional<Products> existingProduct = Optional.ofNullable(findStoreProductById(id));
        if (!existingProduct.isPresent())return  new RuntimeException("Product with id:  "+ id + " does not exist").toString();
        existingProduct.get().setTitle(products.getTitle());
        existingProduct.get().setImage(products.getImage());
        existingProduct.get().setPrice(products.getPrice());
        existingProduct.get().setDescription(products.getDescription());

        try{
            productRepository.save(existingProduct.get());
        }catch (Exception e){
            return e.toString();
        }


        return "Updated Product with Id: "+id ;
    }

}
