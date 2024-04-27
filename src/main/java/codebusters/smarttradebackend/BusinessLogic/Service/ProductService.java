package codebusters.smarttradebackend.BusinessLogic.Service;

import codebusters.smarttradebackend.BusinessLogic.IntService.IProductService;
import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.Persistence.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productData;

    //cambiar por attb booleanos
    @Override
    public List<Product> getProducts() {
        return (List<Product>) productData.findAll();
    }

    @Override
    public List<Product> getBooks() {
        return (List<Product>) productData.findAllBooks();
    }

    @Override
    public List<Product> getCosmetics() {
        return (List<Product>) productData.findAllCosmetics();
    }

    @Override
    public List<Product> getClothing() {
        return (List<Product>) productData.findAllClothing();
    }

    @Override
    public List<Product> getFood() {
        return (List<Product>) productData.findAllFood();
    }

    @Override
    public List<Product> getElectronics() {
        return (List<Product>) productData.findAllElectronics();
    }

    @Override
    public List<Product> getTourism() {
        return (List<Product>) productData.findAllTourism();
    }

    @Override
    public List<Product> getToys() {
        return (List<Product>) productData.findAllToys();
    }

    @Override
    public Product addProduct(String type, String name, double price, String description) {
        Product np = new Product();
        List<Product> products = productData.findAll();
        try {
            np.setType(type);
            np.setName(name);
            np.setPrice(price);
            np.setDescription(description);
            productData.save(np);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return np;
    }

    @Override
    public void deleteProduct(Product p) {
        productData.delete(p);
    }

    public List<Product> getPendingProducts(List<Product> products) {
        List<Product> pendingProducts = new ArrayList<Product>();
        for (Product p : products) {
            if (p.getPending()) {
                pendingProducts.add(p);
            }
        }
        return pendingProducts;
    }

    public List<Product> getValidatedProducts(List<Product> products) {
        List<Product> validatedProducts = new ArrayList<Product>();
        for (Product p : products) {
            if (p.getValidation()) {
                validatedProducts.add(p);
            }
        }
        return validatedProducts;
    }

    public void validateProduct(Product product, boolean isValid) {
        product.setPending(false);
        if (isValid) {
            product.setValidation(true);
        } else {
            deleteProduct(product);
        }
    }
}
