package codebusters.smarttradebackend.Persistence.Controllers;

import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Service.ShoppingCart.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")

public class ShoppingCartController {

    @Autowired
    private ShoppingService shoppingService;

    @GetMapping("/cartProducts")
    public List<Product> getShoppingProducts(@RequestParam("user_id") int userId) {
        return shoppingService.getShoppingProducts(userId);
    }

    @PostMapping("/newCartProduct")
    public void addCartProduct(@RequestBody Map<String, Integer> request) {
        int user_id = request.get("user_id");
        int p_id = request.get("p_id");
        int amount = request.get("amount");
        shoppingService.addShoppingProduct(user_id, p_id, amount);
    }

    @DeleteMapping("/delete")
    public void deleteCartProduct(@RequestBody Map<String, Integer> request) {
        int p_id = request.get("p_id");
        int u_id = request.get("u_id");
        shoppingService.delete(p_id, u_id);
    }

    @PostMapping("/newAmount")
    public void changeAmount(@RequestBody Map<String, Integer> request) {
        int n = request.get("n");
        int p_id = request.get("p_id");
        int u_id = request.get("u_id");
        shoppingService.changeAmount(n, p_id, u_id);
    }
}
