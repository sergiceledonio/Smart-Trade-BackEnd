package codebusters.smarttradebackend.BusinessLogic.Service.Product;

import codebusters.smarttradebackend.BusinessLogic.IntService.IProductService;
import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Models.Products.ProductFactory;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import codebusters.smarttradebackend.Persistence.Repository.ProductRepository;
import codebusters.smarttradebackend.Persistence.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productData;

    @Autowired
    private UserRepository userData;

    //cambiar por attb booleanos
    @Override
    public List<Product> getProducts() {
        return (List<Product>) productData.findAll();
    }

    @Override
    public Optional<Product> getProductById(int id) {
        return productData.findById(id);
    }

    @Override
    public Optional<Product> getProductByName(String name) {
        return productData.findProductByName(name);
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
    public Product addProduct(String name, Double price, String type, String description, Boolean pending, Boolean validation, int user_id) {
        ProductFactory fact = new ProductFactory();
        Product np2 = fact.createProduct(new String[]{name, Double.toString(price), type, description, user_id});

        try{
            np2.setPending(pending);
            np2.setValidation(validation);
        }catch(Exception e){
            e.printStackTrace();
        }
        productData.save(np2);

        return np2;
    }

    @Override
    public void deleteProduct(Product p) {
        Optional<Product> deleted = getProductByName(p.getName());
        productData.deleteById(deleted.get().getId());
    }

    @Override
    public List<Product> getPendingProducts(List<Product> products) {
        List<Product> pendingProducts = new ArrayList<Product>();
        for (Product p : products) {
            if (p.getPending()) {
                pendingProducts.add(p);
            }
        }
        return pendingProducts;
    }

    @Override
    public List<Product> getValidatedProductsByUser(int user_id) {
        List<Product> p_list = productData.findProductsByUser(user_id);
        return getValidatedProducts(p_list);
    }

    @Override
    public List<Product> getValidatedProducts(List<Product> products) {
        List<Product> validatedProducts = new ArrayList<Product>();
        for (Product p : products) {
            if (p.getValidation()) {
                validatedProducts.add(p);
            }
        }
        return validatedProducts;
    }

    @Override
    public void validateProduct(Product product, boolean isValid) {
        if(isValid){
            product.setPending(false);
            product.setValidation(true);
            productData.save(product);
        }else{
            deleteProduct(product);
        }
    }

    @Override
    public String[] getAtrib(Product p) {
        String[] data = new String[6];
        data[0] = p.getName();
        data[1] = String.valueOf(p.getPrice());
        data[2] = p.getType();
        data[3] = p.getDescription();
        data[4] = String.valueOf(p.getPending());
        data[5] = String.valueOf(p.getValidation());
        return data;
    }
}
