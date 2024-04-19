package codebusters.smarttradebackend.BusinessLogic.IntService;

import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import java.util.List;

public interface ISearchService {

    public List<Product> sortByPrice(List<Product> Products, double minPrice, double maxPrice);
    //public List<Product> sortByAssessment(List<Product> Products, int starNumber);
    //public List<Product> sortByShippingDuration(List<Product> Products, int days);
    public List<Product> sortByCategory(List<Product> Products, String category);
    public List<Product> sortByAscendingCategory(List<Product> Products);
    public List<Product> sortByDescendingCategory(List<Product> Products);
    public List<Product> storableSearch(List<Product> SearchHistory, List<Product> Products, String search);
}
