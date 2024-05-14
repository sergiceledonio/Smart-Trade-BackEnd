package codebusters.smarttradebackend.BusinessLogic.Models.ShoppingCart;


import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "cart_products")
public class CartProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "cart_Id")
    private ShoppingCart shoppingCart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product shoppingProduct;

    @Column(name = "cantidad")
    private int cantidad;

    public CartProduct(ShoppingCart shoppingCart, Product product, int cantidad) {
        this.shoppingCart = shoppingCart;
        this.shoppingProduct = product;
        this.cantidad = cantidad;
    }

    public CartProduct() {

    }

    public int getId() {
        return id;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Product getShoppingProduct() {
        return shoppingProduct;
    }

    public void setShoppingProduct(Product product) {
        this.shoppingProduct = product;
    }

    public int getProductId(){
        return this.shoppingProduct.getId();
    }
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
