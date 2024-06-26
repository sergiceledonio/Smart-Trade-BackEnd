package codebusters.smarttradebackend.BusinessLogic.Service.WishList;

import codebusters.smarttradebackend.BusinessLogic.IntService.IWishListService;
import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Models.ShoppingCart.CartProduct;
import codebusters.smarttradebackend.BusinessLogic.Models.ShoppingCart.ShoppingCart;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import codebusters.smarttradebackend.BusinessLogic.Models.WishList.WishList;
import codebusters.smarttradebackend.BusinessLogic.Models.WishList.WishProduct;
import codebusters.smarttradebackend.Persistence.Repository.*;
import codebusters.smarttradebackend.Persistence.Repository.WishList.WishListRepository;
import codebusters.smarttradebackend.Persistence.Repository.WishList.WishProductRepository;
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
    public int addWishedProduct(int user_id, int product_id) {
        Optional<WishList> wl = wldata.findByUserId(user_id);
        Optional<User> u = udata.findById(user_id);

        if(wl.isPresent()) {
            Optional<Product> p = pdata.findById(product_id);
            List<WishProduct> wishProducts = wldata.getWishedProductsById(wl.get().getId());
            System.out.println("El tamaño de la lista es: " + wishProducts.size());
            for(int i = 0; i < wishProducts.size(); i++) {
                System.out.println(wishProducts.get(i).getProductWished().getId() == product_id);
                if(wishProducts.get(i).getProductWished().getId() == product_id) {

                    System.out.println("-1");
                    return -1;
                }
            }
            WishProduct wp = new WishProduct(wl.get(), p.get());
            wpdata.save(wp);
        } else {
            WishList newsc = new WishList(u.get());
            Optional<Product> p = pdata.findById(product_id);
            WishProduct cp = new WishProduct(newsc, p.get());
            wldata.save(newsc);
            wpdata.save(cp);
        }
        System.out.println("1");
        return 1;
    }

    @Override
    public void delete(int user_id, String product_name) {
        Optional<WishList> wl = wldata.findByUserId(user_id);
        Optional<Product> product = pdata.findProductByName(product_name);
        if(product.isPresent()){
            Product p = product.get();
            WishProduct deleted = wpdata.findByProduct(p.getId(), wl.get().getId());
            wpdata.deleteById(deleted.getId());
        } else {
            System.out.println("estamos jodidos");
        }
    }
}
