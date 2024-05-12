package codebusters.smarttradebackend.BusinessLogic.Service.ShoppingCart;

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
    public int addShoppingProduct(int user_id, int p_id, int amount) {
        Optional<ShoppingCart> sc = scdata.findByUserId(user_id);
        Optional<User> u = udata.findById(user_id);
        if(sc.isPresent()) {
            Optional<Product> p = pdata.findById(p_id);
            List<CartProduct> cartProducts = scdata.getCartProductsById(sc.get().getId());
            for(int i = 0; i < cartProducts.size(); i++) {
                if(cartProducts.get(i).getId() == p_id) {
                    return -1;
                }
            }
            CartProduct cp = new CartProduct(sc.get(), p.get(), amount);
            spdata.save(cp);
        } else {
            ShoppingCart newsc = new ShoppingCart(u.get());
            Optional<Product> p = pdata.findById(p_id);
            CartProduct cp = new CartProduct(newsc, p.get(), amount);
            scdata.save(newsc);
            spdata.save(cp);
        }
        return 1;
    }

    @Override
    public void delete(int p_id, int u_id) {
        Optional<ShoppingCart> sp = scdata.findByUserId(u_id);
        CartProduct deleted = spdata.findByProduct(p_id, sp.get().getId());
        spdata.deleteById(deleted.getId());
    }

    @Override
    public void changeAmount(int n, int p_id, int u_id) {
        Optional<ShoppingCart> sp = scdata.findByUserId(u_id);
        CartProduct cartProduct = spdata.findByProduct(p_id, sp.get().getId());
        cartProduct.setCantidad(cartProduct.getCantidad() + n);
        spdata.save(cartProduct);
    }
}
