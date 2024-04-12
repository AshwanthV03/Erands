package com.erands.erands.Service.OrderService;

import com.erands.erands.Model.Orders;
import com.erands.erands.Model.OrderRequestObject;
import com.erands.erands.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Override
    public String placeOrder(OrderRequestObject payload, Long userId) {
        Orders order = new Orders();
        order.setUserId(userId);

        OrderRequestObject orderRequestObject = new OrderRequestObject();
        orderRequestObject.setQyt(payload.getQyt());
        orderRequestObject.setProductId(payload.getProductId());

        order.setProductOrdered(orderRequestObject);
        order.setOrderDateTime(LocalDateTime.now());

        orderRepository.save(order);
        return "Order Placed";
    }

    @Override
    public String getOrder(Long orderId) {
        Optional<Orders> order= orderRepository.findById(orderId);
        if (!order.isPresent()) return new RuntimeException("order Does not Exist").toString();
        return order.toString();
    }

    @Override
    public String deleteOrder(Long orderId, Long userId) {
        Optional<Orders> order= orderRepository.findById(orderId);
        if (!order.isPresent()) throw new RuntimeException("order Does not Exist");
        if(!(order.get().getUserId() == userId)) return  new RuntimeException("Cannot delete others order...").toString();
        orderRepository.deleteById(orderId);
        return "Deleted";
    }
    @Override
    public List<Orders> getOrdersByDateRange(String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startDateTime = LocalDateTime.parse(startDate + " 00:00:00", formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(endDate + " 23:59:59", formatter);
        return orderRepository.findByOrderDateTimeBetween(startDateTime, endDateTime);
    }
    @Override
    public List<Orders> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

//    @Override
//    public List<Orders> getOrdersBySellerId(Long sellerId) {
//        return orderRepository.findByProductOrderedSellerId(sellerId);
//    }
}
