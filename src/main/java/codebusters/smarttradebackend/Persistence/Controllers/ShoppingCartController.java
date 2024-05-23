package codebusters.smarttradebackend.Persistence.Controllers;

import codebusters.smarttradebackend.BusinessLogic.IntService.Command.ShoppingCartCommand;
import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Service.Product.ProductService;
import codebusters.smarttradebackend.BusinessLogic.Service.ShoppingCart.AddToCartCommand;
import codebusters.smarttradebackend.BusinessLogic.Service.ShoppingCart.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import codebusters.smarttradebackend.BusinessLogic.Service.ShoppingCart.CommandExecutor;


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
    @Autowired
    private CommandExecutor commandExecutor;

    @GetMapping("/cartProducts")
    public List<Product> getShoppingProducts(@RequestParam("user_id") int userId) {
        return shoppingService.getShoppingProducts(userId);
    }

    @PostMapping("/newCartProduct")
    public int addCartProduct(@RequestBody Map<String, Integer> request) {
        int userId = request.get("user_id");
        int productId = request.get("p_id");
        int amount = request.get("amount");

        Optional<Product> productOptional = productService.getProductById(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            ShoppingCartCommand addToCartCommand = new AddToCartCommand(userId, product, amount, shoppingService);
            commandExecutor.executeCommand(addToCartCommand);
            return 1;
        } else {
            return -1;
        }
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

        }
    }

    @PostMapping("/newAmount")
    public void changeAmount(@RequestBody Map<String, Object> request) {
        int n = (int)request.get("n");
        String p_name = (String) request.get("p_name");
        int u_id = (int)request.get("u_id");
        System.out.println("Se le añade: " + n + " a la cantidad que había");
        int p_id = productService.getProductByName(p_name).get().getId();

        shoppingService.changeAmount(n, p_id, u_id);
    }

    @PostMapping("/amount")
    public int amount(@RequestBody Map<String, Object> request) {
        String p_name = (String) request.get("p_name");
        int u_id = (int)request.get("u_id");
        int p_id = productService.getProductByName(p_name).get().getId();
        int res = shoppingService.amount(p_id, u_id);
        System.out.println("La llamada devuelve: " + res);
        return res;
    }
}
