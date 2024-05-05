package codebusters.smarttradebackend.Persistence.Controllers;

import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Models.Products.ProductFactory;
import codebusters.smarttradebackend.BusinessLogic.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return (List<Product>) service.getProducts();
    }

    @GetMapping("/getbyid/{id}")
    public Optional<Product> getProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/getbyname/{name}")
    public Optional<Product> getProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }

    @GetMapping("/books")
    public List<Product> getBooks() {
        return (List<Product>) service.getBooks();
    }

    @GetMapping("/clothing")
    public List<Product> getClothing() {
        return (List<Product>) service.getClothing();
    }

    @GetMapping("/cosmetics")
    public List<Product> getCosmetics() {
        return (List<Product>) service.getCosmetics();
    }

    @GetMapping("/electronics")
    public List<Product> getElectronics() {
        return (List<Product>) service.getElectronics();
    }

    @GetMapping("/food")
    public List<Product> getFood() {
        return (List<Product>) service.getFood();
    }

    @GetMapping("/tourism")
    public List<Product> getTourism() {
        return (List<Product>) service.getTourism();
    }

    @GetMapping("/toys")
    public List<Product> getToys() { return (List<Product>) service.getToys(); }

    @PostMapping("/newproducts")
    public String addProduct(@RequestBody Product request) {
        String type = request.getType();
        String name = request.getName();
        double price = request.getPrice();
        String description = request.getDescription();
        boolean pending = request.getPending();
        boolean validation = request.getValidation();

        service.addProduct(type, name, price, description, pending, validation);
        return "Producto recibido: " + name;
    }

    @DeleteMapping("/delete")
    public void deleteByName(@RequestBody Product p) {
        service.deleteProduct(p);
    }

    @GetMapping("/pending")
    public List<Product> getPendingProducts() {
        return service.getPendingProducts(this.getProducts());
    }

    @GetMapping("/validated")
    public List<Product> getValidatedProducts() {
        return service.getValidatedProducts(this.getProducts());
    }

    @GetMapping("/validate")
    public void validateProduct(@RequestBody String name, @RequestBody boolean valid) {
        Optional<Product> product = service.getProductByName(name);
        service.validateProduct(product.get(), valid);
    }

    @GetMapping("/atributos")
    public String[] getAtribs(@RequestBody Product product) {
        return service.getAtrib(product);
    }
}
