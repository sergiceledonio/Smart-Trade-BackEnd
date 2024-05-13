package codebusters.smarttradebackend.Persistence.Controllers;


import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Service.WishList.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wish")
public class WishListController {

    @Autowired
    private WishListService service;

    @GetMapping("/wishList")
    public List<Product> getWishList(@RequestParam("user_id") int user_id) {
        return service.getWishProductsById(user_id);
    }

    @PostMapping("/newWishProduct")
    public void addWishProduct(@RequestBody Map<String, Integer> request) {
        int user_id = request.get("user_id");
        int p_id = request.get("p_id");
        service.addWishedProduct(user_id, p_id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Map<String, Integer> request) {
        int user_id = request.get("user_id");
        int product_id = request.get("product_id");
        service.delete(user_id, product_id);
    }
}
