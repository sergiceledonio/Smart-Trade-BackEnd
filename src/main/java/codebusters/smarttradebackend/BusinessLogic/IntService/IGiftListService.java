package codebusters.smarttradebackend.BusinessLogic.IntService;

import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;

import java.util.List;

public interface IGiftListService {
    List<Product> getGiftProductsById(int user_id, String friend);

    void addGiftProduct(int user_id, int product_id, String friend);

    void delete(int user_id, String product_name);
}
