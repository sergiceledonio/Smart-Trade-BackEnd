package codebusters.smarttradebackend.Persistence.Repository.GiftList;

import codebusters.smarttradebackend.BusinessLogic.Models.GiftList.GiftProduct;
import codebusters.smarttradebackend.BusinessLogic.Models.ShoppingCart.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GiftProductRepository extends JpaRepository<GiftProduct, Integer> {
    @Query("SELECT gp FROM GiftProduct gp WHERE gp.giftProduct.id = :p_id AND gp.giftList.id = :gl_id")
    public GiftProduct findByProduct(int p_id, int gl_id);
}
