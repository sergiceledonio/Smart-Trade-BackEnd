package codebusters.smarttradebackend.Persistence.Controllers;

import codebusters.smarttradebackend.BusinessLogic.Models.GiftList.GiftProduct;
import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Service.GiftListService.GiftListService;
import codebusters.smarttradebackend.BusinessLogic.Service.WishList.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/gift")
public class GiftListController {
    @Autowired
    private GiftListService service;

    @PostMapping("/giftList")
    public List<Product> getGiftList(@RequestBody Map<String, Object> request) {
        int user_id = (int) request.get("user_id");
        String friend = (String) request.get("friend");
        return service.getGiftProductsById(user_id, friend);
    }

    @PostMapping("/friends")
    public List<String> getFriendsByUserId(@RequestBody Map<String, Object> request) {
        int user_id = (int) request.get("user_id");
        return service.getFriendsByUserId(user_id);
    }

    @PostMapping("/newGiftProduct")
    public int addGiftProduct(@RequestBody Map<String, Object> request) {
        int user_id = (int) request.get("user_id");
        int p_id = (int) request.get("p_id");
        String friend = (String) request.get("friend");
        return service.addGiftProduct(user_id, p_id, friend);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Map<String, Object> request) {
        int user_id = (int) request.get("user_id");
        String product_name = (String) request.get("product_name");
        service.delete(user_id, product_name);
    }
}
