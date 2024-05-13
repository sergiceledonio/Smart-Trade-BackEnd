package codebusters.smarttradebackend.Persistence.Repository;

import codebusters.smarttradebackend.BusinessLogic.Models.ShoppingCart.CartProduct;
import codebusters.smarttradebackend.BusinessLogic.Models.WishList.WishProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WishProductRepository extends JpaRepository<WishProduct, Integer> {
    @Query("SELECT wp FROM WishProduct wp WHERE wp.productWished.id = :p_id AND wp.wishList.id = :sc_id")
    public WishProduct findByProduct(int p_id, int sc_id);
}
