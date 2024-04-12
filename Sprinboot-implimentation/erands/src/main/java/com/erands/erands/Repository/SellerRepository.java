package com.erands.erands.Repository;

import com.erands.erands.Model.Products;
import com.erands.erands.Model.Seller;
import com.erands.erands.RequestObject.SellerProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {

    @Query("SELECT s FROM Seller s " +
            "JOIN s.store st " +
            "JOIN st.products p " +
            "WHERE s.id = :sellerId")
    List<Seller> sellerProducts(@Param("sellerId") Long sellerId);
}


