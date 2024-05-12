package codebusters.smarttradebackend.BusinessLogic.Service.WishList;

import codebusters.smarttradebackend.BusinessLogic.IntService.IWishListService;
import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Models.ShoppingCart.CartProduct;
import codebusters.smarttradebackend.BusinessLogic.Models.ShoppingCart.ShoppingCart;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import codebusters.smarttradebackend.BusinessLogic.Models.WishList.WishList;
import codebusters.smarttradebackend.BusinessLogic.Models.WishList.WishProduct;
import codebusters.smarttradebackend.Persistence.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishListService implements IWishListService {

    @Autowired
    private WishListRepository wldata;

    @Autowired
    private ProductRepository pdata;

    @Autowired
    private WishProductRepository wpdata;

    @Autowired
    private UserRepository udata;

    @Override
    public List<Product> getWishProductsById(int user_id) {
        return wldata.findProductsByUserId(user_id);
    }

    @Override
    public void addWishedProduct(int user_id, int product_id) {
        Optional<WishList> wl = wldata.findByUserId(user_id);
        Optional<User> u = udata.findById(user_id);
        if(wl.isPresent()) {
            Optional<Product> p = pdata.findById(product_id);
            WishProduct wp = new WishProduct(wl.get(), p.get());
            wpdata.save(wp);
        } else {
            WishList newwl = new WishList(u.get());
            Optional<Product> p = pdata.findById(product_id);
            WishProduct wp = new WishProduct(newwl, p.get());
            wldata.save(newwl);
            wpdata.save(wp);
        }

    }
}