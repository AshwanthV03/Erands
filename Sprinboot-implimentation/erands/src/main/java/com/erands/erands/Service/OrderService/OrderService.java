    package com.erands.erands.Service.OrderService;

    import com.erands.erands.Model.Orders;
    import com.erands.erands.Model.OrderRequestObject;

    import java.util.List;

    public interface OrderService {
        public String placeOrder(OrderRequestObject payload, Long id);
        public  String getOrder(Long orderid);
        public String deleteOrder(Long orderid,Long userId);
        public List<Orders> getOrdersByDateRange(String startDate, String endDate);
        public List<Orders> getOrdersByUserId(Long userId);
       // public List<Orders> getOrdersBySellerId(Long sellerId);
    }
