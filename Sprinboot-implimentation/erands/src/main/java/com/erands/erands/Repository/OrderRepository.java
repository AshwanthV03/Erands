package com.erands.erands.Repository;

import com.erands.erands.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,Long> {
    @Query("SELECT o FROM Orders o WHERE o.orderDateTime BETWEEN :startDate AND :endDate")
    List<Orders> findByOrderDateTimeBetween(LocalDateTime startDate, LocalDateTime endDate);


   // List<Orders> findByProductOrderedSellerId(Long sellerId); // Removed underscore from method name

    List<Orders> findByUserId(Long userId);
}
