package codebusters.smarttradebackend.Persistence.Repository.GiftList;

import codebusters.smarttradebackend.BusinessLogic.Models.GiftList.GiftList;
import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Models.ShoppingCart.CartProduct;
import codebusters.smarttradebackend.BusinessLogic.Models.ShoppingCart.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GiftListRepository extends JpaRepository<GiftList, Integer> {
    @Query("SELECT gp.giftProduct FROM GiftProduct gp JOIN gp.giftList s WHERE s.user.id = :userid")
    List<Product> findGiftProductsByUserId(int userid);

    @Query("SELECT g FROM GiftList g, User u WHERE g.user.id = :user_id")
    Optional<GiftList> findByUserId(int user_id);

    @Query("SELECT gp FROM GiftProduct gp, GiftList gl WHERE gp.giftList.id = :gl_id")
    List<CartProduct> getGiftProductsById(int gl_id);
}
