package codebusters.smarttradebackend.BusinessLogic.Service;

import codebusters.smarttradebackend.BusinessLogic.IntService.ISearchService;
import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@Service
public class SearchService implements ISearchService, Comparator {

    public List<Product> sortByPrice(List<Product> Products, double minPrice, double maxPrice) {
        List<Product> auxProducts = new ArrayList<Product>();
        for (int i = 0; i < Products.size(); i++) {
            if (Products.get(i).getPrice() >= minPrice && Products.get(i).getPrice() <= maxPrice) {
                auxProducts.add(Products.get(i));
            }
        }
        Collections.sort(auxProducts, (Product p1, Product p2) -> {
            return Double.compare(p1.getPrice(), p2.getPrice());
        });
        return auxProducts;
    }

    public List<Product> sortByAssessment(List<Product> Products, int starNumber) {
        List<Product> auxProducts = new ArrayList<Product>();
        for (int i = 0; i < Products.size(); i++) {
            if (Products.get(i).getNumStars() >= starNumber) {
                auxProducts.add(Products.get(i));
            }
        }
        Collections.sort(auxProducts, (Product p1, Product p2) -> {
            return Integer.compare(p1.getNumStars(), p2.getNumStars());
        });
        return auxProducts;
    }

    /*
    public List<Product> sortByShippingDuration(List<Product> Products, int days) {
        List<Product> auxProducts = new ArrayList<Product>();
        for (int i = 0; i < Products.size(); i++) {
            if (Products.get(i).getNumStars() >= starNumber)
        }
    }
    */
}
