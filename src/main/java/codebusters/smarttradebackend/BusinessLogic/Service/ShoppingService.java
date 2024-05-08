package codebusters.smarttradebackend.BusinessLogic.Service;

import codebusters.smarttradebackend.BusinessLogic.IntService.IShoppingService;
import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Models.ShoppingCart.CartProduct;
import codebusters.smarttradebackend.BusinessLogic.Models.ShoppingCart.ShoppingCart;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import codebusters.smarttradebackend.Persistence.Repository.ProductRepository;
import codebusters.smarttradebackend.Persistence.Repository.ShoppingCartRepository;
import codebusters.smarttradebackend.Persistence.Repository.ShoppingProductRepository;
import codebusters.smarttradebackend.Persistence.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import codebusters.smarttradebackend.BusinessLogic.Service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingService implements IShoppingService {

    @Autowired
    private ShoppingCartRepository scdata;

    @Autowired
    private ProductRepository pdata;

    @Autowired
    private ShoppingProductRepository spdata;

    @Autowired
    private UserRepository udata;

    @Override
    public List<Product> getShoppingProducts(int user_id) {
        return scdata.findShoppingProductsByUserId(user_id);
    }

    @Override
    public void addShoppingProduct(int user_id, int p_id, int amount) {
        Optional<ShoppingCart> sc = scdata.findByUserId(user_id);
        Optional<User> u = udata.findById(user_id);
        if(sc.isPresent()) {
            Optional<Product> p = pdata.findById(p_id);
            CartProduct cp = new CartProduct(sc.get(), p.get(), amount);
            spdata.save(cp);
        } else {
            ShoppingCart newsc = new ShoppingCart(u.get());
            Optional<Product> p = pdata.findById(p_id);
            CartProduct cp = new CartProduct(newsc, p.get(), amount);
            scdata.save(newsc);
            spdata.save(cp);
        }
    }


}
