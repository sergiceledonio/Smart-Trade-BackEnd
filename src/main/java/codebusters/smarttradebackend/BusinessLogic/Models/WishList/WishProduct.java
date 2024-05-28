package codebusters.smarttradebackend.BusinessLogic.Models.WishList;


import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Models.ShoppingCart.ShoppingCart;
import jakarta.persistence.*;

@Entity
@Table(name = "wish_products")
public class WishProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "wish_list_Id")
    private WishList wishList;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productWished;

    public WishProduct(WishList wishList, Product productWished) {
        this.wishList = wishList;
        this.productWished = productWished;
    }

    public WishProduct() {
    }

    public int getId() {
        return id;
    }

    public WishList getWishList() {
        return wishList;
    }

    public void setWishList(WishList wishList) {
        this.wishList = wishList;
    }

    public Product getProductWished() {
        return productWished;
    }

    public void setProductWished(Product productWished) {
        this.productWished = productWished;
    }
}
