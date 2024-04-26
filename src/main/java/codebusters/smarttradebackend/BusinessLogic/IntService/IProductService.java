package codebusters.smarttradebackend.BusinessLogic.IntService;

import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;


import java.util.List;

public interface IProductService {
    public List<Product> getProducts();

    public List<Product> getBooks();

    public List<Product> getCosmetics();

    public List<Product> getClothing();

    public List<Product> getFood();

    public List<Product> getElectronics();

    public List<Product> getTourism();

    public List<Product> getToys();

    public Product addProduct(String type, String name, double price, String description);

}
