package codebusters.smarttradebackend.BusinessLogic.IntService;

import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Models.ShoppingCart.CartProduct;

import java.util.List;

public interface IShoppingService {
    public List<Product> getShoppingProducts(int user_id);

    public void addShoppingProduct(int user_id, int p_id);
}
