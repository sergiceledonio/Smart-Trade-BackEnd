package codebusters.smarttradebackend.Persistence.Repository;

import codebusters.smarttradebackend.BusinessLogic.Models.ShoppingCart.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingProductRepository extends JpaRepository<CartProduct, Integer> {

}
