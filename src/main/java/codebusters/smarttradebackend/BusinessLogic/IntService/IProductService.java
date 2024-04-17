package codebusters.smarttradebackend.BusinessLogic.IntService;

import codebusters.smarttradebackend.BusinessLogic.Models.Factory.Product;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.Usuario;

import java.util.List;

public interface IProductService {


    public List<Product> getProducts();
}
