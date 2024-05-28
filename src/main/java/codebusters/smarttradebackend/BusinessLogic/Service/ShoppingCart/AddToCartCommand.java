package codebusters.smarttradebackend.BusinessLogic.Service.ShoppingCart;

import codebusters.smarttradebackend.BusinessLogic.IntService.Command.ShoppingCartCommand;
import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;

public class AddToCartCommand implements ShoppingCartCommand {
    private int userId;
    private Product product;
    private int quantity;
    private ShoppingService shoppingService;

    public AddToCartCommand(int userId, Product product, int quantity, ShoppingService shoppingService) {
        this.userId = userId;
        this.product = product;
        this.quantity = quantity;
        this.shoppingService = shoppingService;
    }

    @Override
    public int execute() {
        return shoppingService.addShoppingProduct(userId, product.getId(), quantity);
    }
}