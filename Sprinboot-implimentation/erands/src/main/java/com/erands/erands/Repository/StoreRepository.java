package com.erands.erands.Repository;

import com.erands.erands.Model.Products;
import com.erands.erands.Model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store,Long> {
    @Query("SELECT p FROM Products p " +
            "JOIN p.stores s " +
            "WHERE s.id = :storeId")
    List<Products> findProductsByStoreId(@Param("storeId") Long storeId);

    @Query("SELECT p FROM Products p " +
            "JOIN p.stores s " +
            "WHERE p.id = :productId")
    Products FindStoreProductById(@Param("productId")Long productId);
}
