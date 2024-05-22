package codebusters.smarttradebackend.BusinessLogic.Service.OrderService;


import codebusters.smarttradebackend.BusinessLogic.IntService.IOrderService;
import codebusters.smarttradebackend.BusinessLogic.Models.ShoppingCart.ShoppingCart;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import codebusters.smarttradebackend.Persistence.Repository.OrderRepository.OrderRepository;
import codebusters.smarttradebackend.Persistence.Repository.ShoppingCart.ShoppingCartRepository;
import codebusters.smarttradebackend.Persistence.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository data;

    @Autowired
    private UserRepository udata;

    @Autowired
    private ShoppingCartRepository scdata

    @Override
    public void addOrder(int sc_id) {
        Optional<ShoppingCart> sc = scdata.findById(sc_id);
    }
}
