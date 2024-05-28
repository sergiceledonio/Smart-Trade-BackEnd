package codebusters.smarttradebackend.Persistence.Repository.WishList;

import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Models.ShoppingCart.CartProduct;
import codebusters.smarttradebackend.BusinessLogic.Models.ShoppingCart.ShoppingCart;
import codebusters.smarttradebackend.BusinessLogic.Models.WishList.WishList;
import codebusters.smarttradebackend.BusinessLogic.Models.WishList.WishProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface WishListRepository extends JpaRepository<WishList, Integer> {

    @Query("SELECT wp.productWished FROM WishProduct wp JOIN wp.wishList wl WHERE wl.user.id = :userid")
    List<Product> findProductsByUserId(int userid);

    @Query("SELECT wl FROM WishList wl, User u WHERE wl.user.id = :user_id")
    Optional<WishList> findByUserId(int user_id);

    @Query("SELECT wp FROM WishProduct wp, WishList wl WHERE wp.wishList.id = :wl_id")
    List<WishProduct> getWishedProductsById(int wl_id);

}
