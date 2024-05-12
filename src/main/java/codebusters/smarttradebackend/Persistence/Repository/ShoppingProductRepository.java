package codebusters.smarttradebackend.Persistence.Repository;

import codebusters.smarttradebackend.BusinessLogic.Models.ShoppingCart.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShoppingProductRepository extends JpaRepository<CartProduct, Integer> {

    @Query("SELECT cp FROM CartProduct cp WHERE cp.shoppingProduct.id = :p_id AND cp.shoppingCart.id = :sc_id")
    public CartProduct findByProduct(int p_id, int sc_id);
}
