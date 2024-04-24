package codebusters.smarttradebackend.BusinessLogic.Service;

import codebusters.smarttradebackend.BusinessLogic.IntService.IProductService;
import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.Persistence.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productData;

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
    public Product addProduct(Product p) {
        Product np = new Product();
        List<Product> products = productData.findAll();
        try {
            for(int i = 0; i < products.size(); i++){
                if(np.getName().equals(products.get(i).getName())) {
                    throw new Exception("El producto ya existe");
                }
            }
            np.setType(p.getType());
            np.setName(p.getName());
            np.setPrice(p.getPrice());
            np.setDescription(p.getDescription());
            productData.save(np);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return np;
    }
}
