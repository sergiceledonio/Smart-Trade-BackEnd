package codebusters.smarttradebackend.BusinessLogic.Service.WishList;

import codebusters.smarttradebackend.BusinessLogic.IntService.Command.ICommand;
import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;

public class AddToWishCommand implements ICommand {
    private int userId;
    private Product product;
    private WishListService wlservice;

    public AddToWishCommand(int userId, Product product, WishListService wishService) {
        this.userId = userId;
        this.product = product;
        this.wlservice = wishService;
    }

    @Override
    public int execute() {
        return wlservice.addWishedProduct(userId, product.getId());
    }
}