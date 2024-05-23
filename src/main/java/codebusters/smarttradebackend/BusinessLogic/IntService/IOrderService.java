package codebusters.smarttradebackend.BusinessLogic.IntService;

import codebusters.smarttradebackend.BusinessLogic.Models.Order.Order;

import java.util.List;

public interface IOrderService {
    void addOrder(int sc_id);

    List<Order> getOrders(int user_id);
}
