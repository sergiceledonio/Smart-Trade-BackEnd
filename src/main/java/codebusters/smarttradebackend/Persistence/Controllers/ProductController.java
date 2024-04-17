package codebusters.smarttradebackend.Persistence.Controllers;

import codebusters.smarttradebackend.BusinessLogic.Models.Factory.Product;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.Usuario;
import codebusters.smarttradebackend.BusinessLogic.Service.ProductService;
import codebusters.smarttradebackend.BusinessLogic.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/Product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/Products")
    public List<Product> getProduct() {
        return (List<Product>) service.getProducts();
    }

    @PostMapping("addProducts")
    public Product addProduct(){
        return null;
    }

}
