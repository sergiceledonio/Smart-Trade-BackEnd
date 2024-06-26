package codebusters.smarttradebackend.Persistence.Controllers;

import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Service.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Map;
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
        String decodedName = "";
        try{
            decodedName = URLDecoder.decode(name, StandardCharsets.UTF_8.toString());

        }catch(Exception e){
            e.printStackTrace();
        }
            return service.getProductByName(decodedName);
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
    public String addProduct(@RequestBody Map<String, Object> request) {
        System.out.println("El producto está siendo guardado");
        String type = (String) request.get("type");
        String name = (String) request.get("name");
        String priceS = (String) request.get("price");
        double price = Double.parseDouble(priceS);
        int user_id = (int)request.get("user_id");
        String description = (String) request.get("desc");
        boolean pending = (boolean)request.get("pending");
        boolean validation = (boolean)request.get("validation");
        String imgS = (String)request.get("image");
        byte[] img = Base64.getDecoder().decode(imgS);
        System.out.println(img);


        service.addProduct(name, price, type, description, pending, validation, user_id, img);
        return "Producto recibido: " + name;
    }

    @DeleteMapping("/delete")
    public void deleteByName(@RequestBody Product p) {
        service.deleteProduct(p);
    }

    @GetMapping("/validatedByUser")
    public List<Product> getValidatedByUser(@RequestBody Map<String, Integer> request) {
        int user_id = request.get("user_id");
        return service.getValidatedProductsByUser(user_id);
    }

    @GetMapping("/pending")
    public List<Product> getPendingProducts() {
        return service.getPendingProducts(this.getProducts());
    }

    @GetMapping("/validated")
    public List<Product> getValidatedProducts() {
        return service.getValidatedProducts(this.getProducts());
    }

    @PostMapping("/validate")
    public void validateProduct(@RequestBody Map<String, Object> request) {
        int id = (int) request.get("id");
        boolean valid = (boolean) request.get("valid");
        Optional<Product> product = service.getProductById(id);
        if (product.isPresent()) {
            service.validateProduct(product.get(), valid);
        } else {
            throw new IllegalArgumentException("Product not found with name: " + id);
        }
    }

    @GetMapping("/atributos")
    public String[] getAtribs(@RequestBody Product product) {
        return service.getAtrib(product);
    }

    @PostMapping("/newImage")
    public void addImage(@RequestParam("file") MultipartFile image, String name) {
        service.addImage(name, image);
    }

    @GetMapping("/image")
    public byte[] getImage(@RequestBody Map<String, String> request) {
        String name = request.get("name");
        return service.getImage(name);
    }
}
