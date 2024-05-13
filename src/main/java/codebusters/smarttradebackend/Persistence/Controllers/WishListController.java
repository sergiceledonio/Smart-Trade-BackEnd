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

    @PostMapping("/delete")
    public void delete(@RequestBody Map<String, Object> request) {
        int user_id = (int) request.get("user_id");
        String product_name = (String) request.get("product_name");
        service.delete(user_id, product_name);
    }
}
