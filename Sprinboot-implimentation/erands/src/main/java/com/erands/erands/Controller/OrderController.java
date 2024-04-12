package com.erands.erands.Controller;

import com.erands.erands.Model.OrderRequestObject;
import com.erands.erands.Model.Orders;
import com.erands.erands.Service.OrderService.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Order")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;
    @PostMapping("/placeOrder/{userId}")
    public String placeOrder(@RequestBody OrderRequestObject payload, @PathVariable Long userId) {
        return orderService.placeOrder(payload, userId);
    }

    @GetMapping("/{orderId}")
    public String getOrder(@PathVariable Long orderId) {
        return orderService.getOrder(orderId);
    }

    @DeleteMapping("/{orderId}/{userId}")
    public String deleteOrder(@PathVariable Long orderId, @PathVariable Long userId) {
        return orderService.deleteOrder(orderId, userId);
    }

    @GetMapping("/getOrdersByDateRange")
    public List<Orders> getOrdersByDateRange(@RequestParam String startDate, @RequestParam String endDate) {
        return orderService.getOrdersByDateRange(startDate, endDate);
    }

    @GetMapping("/getOrdersByUserId/{userId}")
    public List<Orders> getOrdersByUserId(@PathVariable Long userId) {
        return orderService.getOrdersByUserId(userId);
    }
}

