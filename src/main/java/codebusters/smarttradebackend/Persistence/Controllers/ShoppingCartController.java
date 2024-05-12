package codebusters.smarttradebackend.Persistence.Controllers;

import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Service.Product.ProductService;
import codebusters.smarttradebackend.BusinessLogic.Service.ShoppingCart.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/cart")

public class ShoppingCartController {

    @Autowired
    private ShoppingService shoppingService;

    @Autowired
    private ProductService productService;

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

    @PostMapping("/delete")
    public void deleteCartProduct(@RequestBody Map<String, Object> request) {
        String p_name = (String) request.get("p_name");
        int u_id = (int) request.get("u_id");

        Optional<Product> productOptional = productService.getProductByName(p_name);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            int p_id = product.getId();
            System.out.println("El producto es borrado");
            shoppingService.delete(p_id, u_id);
        } else {
            // Manejar el caso en el que no se encuentre ningún producto con ese nombre
        }
    }

    @PostMapping("/newAmount")
    public void changeAmount(@RequestBody Map<String, Object> request) {
        int n = (int)request.get("n");
        String p_name = (String) request.get("p_name");
        int u_id = (int)request.get("u_id");
        int p_id = productService.getProductByName(p_name).get().getId();

        shoppingService.changeAmount(n, p_id, u_id);
    }

    @GetMapping("/amount")
    public int amount(@RequestBody Map<String, Object> request) {
        String p_name = (String) request.get("p_name");
        int u_id = (int)request.get("u_id");
        int p_id = productService.getProductByName(p_name).get().getId();
        return shoppingService.amount(p_id, u_id);
    }
}
