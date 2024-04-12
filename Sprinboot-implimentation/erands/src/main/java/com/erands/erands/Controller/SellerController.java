package com.erands.erands.Controller;

import com.erands.erands.Model.Seller;
import com.erands.erands.Service.SellerService.SellerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/seller")
public class SellerController {

    @Autowired
    SellerServiceImpl sellerServiceImpl;
    @PostMapping(path = "/create")
    public String CreateSeller(@RequestBody Seller seller){

        return sellerServiceImpl.createSeller(seller);
    }
    @GetMapping("/getSellers")
    public List<Seller> allSellers(){
        return sellerServiceImpl.getAllSellers();
    }

    @GetMapping("/getSellerProducts/{id}")
    public List<Seller> sellerProducts(@PathVariable Long id){
        return sellerServiceImpl.getSellersProducts(id);
    }
}
