package com.erands.erands.Service.SellerService;

import com.erands.erands.Model.Products;
import com.erands.erands.Model.Seller;
import com.erands.erands.Repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    SellerRepository sellerRepository;
    @Override
    public String createSeller(Seller seller) {
        Seller newSeller = new Seller();
        newSeller.setName(seller.getName());
        newSeller.setEmail(seller.getEmail());
        newSeller.setPhoneNumber(seller.getPhoneNumber());
        newSeller.setCreatedAt(LocalDateTime.now());
        sellerRepository.save(newSeller);

        return "Seller Saved";
    }

    @Override
    public Seller findSellerById(Long id) {
        Optional<Seller> seller = sellerRepository.findById(id);
        if (!seller.isPresent()) throw new RuntimeException("Seller Does not Exist");

        return seller.get();
    }

    @Override
    public List<Seller> getSellersProducts(Long sellerId) {
        List<Seller> sellerProducts =sellerRepository.sellerProducts(sellerId);
        return sellerProducts;
    }

    @Override
    public List<Seller> getAllSellers() {
        List<Seller> allSellers = sellerRepository.findAll();
        return allSellers;
    }
}
