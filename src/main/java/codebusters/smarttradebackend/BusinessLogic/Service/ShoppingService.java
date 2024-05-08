package codebusters.smarttradebackend.BusinessLogic.Service;

import codebusters.smarttradebackend.BusinessLogic.IntService.IShoppingService;
import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Models.ShoppingCart.CartProduct;
import codebusters.smarttradebackend.Persistence.Repository.ProductRepository;
import codebusters.smarttradebackend.Persistence.Repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import codebusters.smarttradebackend.BusinessLogic.Service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingService implements IShoppingService {

    @Autowired
    private ShoppingCartRepository data;

    @Autowired
    private ProductRepository pdata;

    @Override
    public List<Product> getShoppingProducts(int user_id) {
        return data.findShoppingProductsByUserId(user_id);
    }

    @Override
    public void addShoppingProduct(int user_id, int p_id) {
        Optional<Product> p = pdata.findById(p_id);
    }
}
