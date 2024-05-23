package codebusters.smarttradebackend.BusinessLogic.Models.GiftList;

import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Models.WishList.WishList;
import jakarta.persistence.*;

@Entity
@Table(name = "gift_product")
public class GiftProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "gift_list_Id")
    private GiftList giftList;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product giftProduct;

    @Column(name = "friend")
    private String friend;

    public GiftProduct(GiftList giftList, Product giftProduct, String friend) {
        this.giftList = giftList;
        this.giftProduct = giftProduct;
        this.friend = friend;
    }

    public GiftProduct() {
    }

    public int getId() {
        return id;
    }

    public GiftList getGiftList() {
        return giftList;
    }

    public void setGiftList(GiftList giftList) {
        this.giftList = giftList;
    }

    public Product getGiftProduct() {
        return giftProduct;
    }

    public void setGiftProduct(Product giftProduct) {
        this.giftProduct = giftProduct;
    }

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }
}
