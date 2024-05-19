package codebusters.smarttradebackend.BusinessLogic.IntService;

import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import org.springframework.web.multipart.MultipartFile;


import java.awt.*;
import java.util.List;
import java.util.Optional;

public interface IProductService {

    public List<Product> getProducts();

    public Optional<Product> getProductById(int id);

    public Optional<Product> getProductByName(String name);

    public List<Product> getBooks();

    public List<Product> getCosmetics();

    public List<Product> getClothing();

    public List<Product> getFood();

    public List<Product> getElectronics();

    public List<Product> getTourism();

    public List<Product> getToys();

    public Product addProduct(String name, Double price, String type, String description, Boolean pending, Boolean validation, int user_id);

    public void deleteProduct(Product p);

    public List<Product> getPendingProducts(List<Product> products);

    List<Product> getValidatedProductsByUser(int user_id);

    public List<Product> getValidatedProducts(List<Product> products);

    public void validateProduct(Product product, boolean isValid);

    public String[] getAtrib(Product p);

    void addImage(String name, MultipartFile image);

    byte[] getImage(String name);
}
