package codebusters.smarttradebackend.BusinessLogic.Service.OrderService;


import codebusters.smarttradebackend.BusinessLogic.IntService.IOrderService;
import codebusters.smarttradebackend.BusinessLogic.Models.Order.Order;
import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Models.ShoppingCart.ShoppingCart;
import codebusters.smarttradebackend.Persistence.Repository.OrderRepository.OrderRepository;
import codebusters.smarttradebackend.Persistence.Repository.ShoppingCart.ShoppingCartRepository;
import codebusters.smarttradebackend.Persistence.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository data;

    @Autowired
    private UserRepository udata;

    @Autowired
    private ShoppingCartRepository scdata;

    @Override
    public void addOrder(int user_id) {
        Optional<ShoppingCart> sc = scdata.findByUserId(user_id);
        Date now = new Date();
        List<Product> productList = scdata.findShoppingProductsByUserId(user_id);
        double total = 0;
        for(int i = 0; i < productList.size(); i++) {
            total += productList.get(i).getPrice();
        }
        Order o = new Order(sc.get(), now, "pending", total, "paypal");
        scdata.delete(sc.get());
        data.save(o);
    }

    @Override
    public List<Order> getOrders(int user_id) {
        return data.findByUserId(user_id);
    }
}
