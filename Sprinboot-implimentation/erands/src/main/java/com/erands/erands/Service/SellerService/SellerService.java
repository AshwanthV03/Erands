package com.erands.erands.Service.SellerService;

import com.erands.erands.Model.Products;
import com.erands.erands.Model.Seller;

import java.util.ArrayList;
import java.util.List;

public interface SellerService {
    public String createSeller(Seller seller);
    public Seller findSellerById(Long id);
    public List< Seller> getSellersProducts(Long sellerId);
    public List<Seller> getAllSellers();
}
