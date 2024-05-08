package codebusters.smarttradebackend.Persistence.Repository;

import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Models.ShoppingCart.CartProduct;
import codebusters.smarttradebackend.BusinessLogic.Models.ShoppingCart.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer>{

    @Query("SELECT pc.shoppingProduct FROM CartProduct pc JOIN pc.shoppingCart s WHERE s.user.id = :userid")
    List<Product> findShoppingProductsByUserId(int userid);

    @Query("SELECT s FROM ShoppingCart s, User u WHERE s.user.id = :user_id")
    ShoppingCart findByUserId(int user_id);

    @Query("SELECT cp FROM CartProduct cp, ShoppingCart sc WHERE cp.shoppingCart.id = :sc_id")
    List<CartProduct> getCartProductsById(int sc_id);

}
