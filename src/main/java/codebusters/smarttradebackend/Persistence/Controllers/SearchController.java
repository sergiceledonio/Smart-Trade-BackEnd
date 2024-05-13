package codebusters.smarttradebackend.Persistence.Controllers;

import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Service.Search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    SearchService service;

    @GetMapping("/price")
    public List<Product> sortByPrice(@RequestBody Map<String, Object> request) {
        List<Product> Products = (List<Product>) request.get("Products");
        double minPrice = (double) request.get("minPrice");
        double maxPrice = (double) request.get("maxPrice");
        return service.sortByPrice(Products, minPrice, maxPrice);
    }

    @GetMapping("/category")
    public List<Product> sotyByCategory(@RequestBody Map<String, Object> request) {
        List<Product> Products = (List<Product>) request.get("Products");
        String category = (String) request.get("category");
        return service.sortByCategory(Products, category);
    }

    @GetMapping("/ascending")
    public List<Product> sortByAscendingCategory(@RequestBody Map<String, List<Product>> request) {
        List<Product> Products = request.get("Products");
        return service.sortByAscendingCategory(Products);
    }

    @GetMapping("/descending")
    public List<Product> sortByDescendingCategory(@RequestBody Map<String, List<Product>> request) {
        List<Product> Products = request.get("Products");
        return service.sortByDescendingCategory(Products);
    }

    @GetMapping("/storable")
    public List<Product> storableSearch(@RequestBody Map<String, Object> request) {
        List<Product> SearchHistory = (List<Product>) request.get("SearchHistory");
        List<Product> Products = (List<Product>) request.get("Products");
        String searchText = (String) request.get("searchText");
        return service.storableSearch(SearchHistory, Products, searchText);
    }
}
