package codebusters.smarttradebackend.Persistence.Controllers;

import codebusters.smarttradebackend.BusinessLogic.Models.Order.Order;
import codebusters.smarttradebackend.BusinessLogic.Service.OrderService.OrderService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/newOrder")
    public void addOrder(@RequestBody Map<String, Integer> request) {
        int user_id = request.get("user_id");
        service.addOrder(user_id);
    }

    @GetMapping("/orders")
    public List<Order> getOrders(@RequestBody Map<String, Integer> request) {
        int user_id = request.get("user_id");
        return service.getOrders(user_id);
    }
}
