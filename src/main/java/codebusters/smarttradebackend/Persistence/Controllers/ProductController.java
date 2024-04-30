package codebusters.smarttradebackend.Persistence.Controllers;

import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
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

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/{name}")
    public Optional<Product> getProductByName(@RequestParam String name) {
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

    @DeleteMapping("/delete/{nombre}")
    public void deleteByName(@RequestParam String name) {
        Optional<Product> p = getProductByName(name);
        service.deleteProduct(p.get());
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
    public boolean validateProduct(@RequestBody Product product, @RequestParam boolean valid) {
        service.validateProduct(product, valid);
        //Si el objeto se ha borrado, devolvera false, si se ha validado devolvera true
        return valid;
    }
}
