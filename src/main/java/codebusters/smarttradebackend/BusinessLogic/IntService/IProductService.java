package codebusters.smarttradebackend.BusinessLogic.IntService;

import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;


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

    Product addProduct(String type, String name, String price, String description);

    public void deleteProduct(Product p);

    public List<Product> getPendingProducts(List<Product> products);

    public List<Product> getValidatedProducts(List<Product> products);

    public void validateProduct(Product product, boolean isValid);

    public String[] getAtrib(Product p);
}
