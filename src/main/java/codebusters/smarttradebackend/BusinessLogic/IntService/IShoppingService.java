package codebusters.smarttradebackend.BusinessLogic.IntService;

import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;

import java.util.List;

public interface IShoppingService {
    public List<Product> getShoppingProducts(int user_id);
    public int addShoppingProduct(int user_id, int p_id, int amount);

    public void delete(int p_id, int sp_id);

    void deleteByUserId(int u_id);

    void changeAmount(int n, int p_id, int u_id);

    int amount(int p_id, int u_id);
}
