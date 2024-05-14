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

    @GetMapping("/giftList")
    public List<Product> getGiftList(@RequestParam("user_id") int user_id) {
        return service.getGiftProductsById(user_id);
    }

    @PostMapping("/newGiftProduct")
    public void addGiftProduct(@RequestBody Map<String, Object> request) {
        int user_id = (int) request.get("user_id");
        int p_id = (int) request.get("p_id");
        String friend = (String) request.get("friend");
        service.addGiftProduct(user_id, p_id, friend);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Map<String, Object> request) {
        int user_id = (int) request.get("user_id");
        String product_name = (String) request.get("product_name");
        service.delete(user_id, product_name);
    }
}