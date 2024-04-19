package codebusters.smarttradebackend.BusinessLogic.Service;

import codebusters.smarttradebackend.BusinessLogic.IntService.IProductService;
import codebusters.smarttradebackend.BusinessLogic.Models.Factory.Product;
import codebusters.smarttradebackend.Persistence.Repository.ProductRepository;
import codebusters.smarttradebackend.Persistence.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository data;

    @Override
    public List<Product> getProducts() {
        return (List<Product>) data.findAllProducts();
    }
}
