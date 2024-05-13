package codebusters.smarttradebackend.BusinessLogic.IntService;

import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;

import java.util.List;

public interface IWishListService {

    public List<Product> getWishProductsById(int user_id);

    public void addWishedProduct(int user_id, int product_id);


    void delete(int user_id, int product_id);
}
