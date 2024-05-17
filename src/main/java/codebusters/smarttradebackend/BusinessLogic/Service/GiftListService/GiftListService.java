package codebusters.smarttradebackend.BusinessLogic.Service.GiftListService;

import codebusters.smarttradebackend.BusinessLogic.IntService.IGiftListService;
import codebusters.smarttradebackend.BusinessLogic.Models.GiftList.GiftList;
import codebusters.smarttradebackend.BusinessLogic.Models.GiftList.GiftProduct;
import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import codebusters.smarttradebackend.Persistence.Repository.GiftList.GiftListRepository;
import codebusters.smarttradebackend.Persistence.Repository.GiftList.GiftProductRepository;
import codebusters.smarttradebackend.Persistence.Repository.ProductRepository;
import codebusters.smarttradebackend.Persistence.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GiftListService implements IGiftListService {

    @Autowired
    private GiftListRepository gldata;

    @Autowired
    private ProductRepository pdata;

    @Autowired
    private GiftProductRepository gpdata;

    @Autowired
    private UserRepository udata;

    @Override
    public List<Product> getGiftProductsById(int user_id, String friend) {
        return gldata.findGiftProductsByUserId(user_id, friend);
    }

    @Override
    public List<String> getFriendsByUserId(int user_id) {
        return gldata.getFriendsByUserId(user_id);
    }

    @Override
    public void addGiftProduct(int user_id, int product_id, String friend) {
        Optional<GiftList> gl = gldata.findByUserId(user_id);
        Optional<User> u = udata.findById(user_id);
        if(gl.isPresent()) {
            Optional<Product> p = pdata.findById(product_id);
            GiftProduct gp = new GiftProduct(gl.get(), p.get(), friend);
            gpdata.save(gp);
        } else {
            GiftList newgl = new GiftList(u.get());
            Optional<Product> p = pdata.findById(product_id);
            GiftProduct gp = new GiftProduct(newgl, p.get(), friend);
            gldata.save(newgl);
            gpdata.save(gp);
        }
    }

    @Override
    public void delete(int user_id, String product_name) {
        Optional<GiftList> wl = gldata.findByUserId(user_id);
        Optional<Product> product = pdata.findProductByName(product_name);
        if(product.isPresent()){
            Product p = product.get();
            GiftProduct deleted = gpdata.findByProduct(p.getId(), wl.get().getId());
            gpdata.deleteById(deleted.getId());
        } else {
            System.out.println("estamos jodidos");
        }
    }
}
