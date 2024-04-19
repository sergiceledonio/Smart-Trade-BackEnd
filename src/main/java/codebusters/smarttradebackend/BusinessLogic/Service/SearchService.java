package codebusters.smarttradebackend.BusinessLogic.Service;

import codebusters.smarttradebackend.BusinessLogic.IntService.ISearchService;
import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@Service
public class SearchService implements ISearchService {

    public static class PriceComparator implements Comparator<Product> {
        @Override
        public int compare(Product p1, Product p2) {
            return Double.compare(p1.getPrice(), p2.getPrice());
        }
    }

    /*public static class StarsNumComparator implements Comparator<Product> {
        @Override
        public int compare(Product p1, Product p2) {
            return Double.compare(p1.getStarsNum(), p2.getStarsNum());
        }
    }*/

    public List<Product> sortByPrice(List<Product> Products, double minPrice, double maxPrice) {
        List<Product> auxProducts = new ArrayList<Product>();
        for (int i = 0; i < Products.size(); i++) {
            if (Products.get(i).getPrice() >= minPrice && Products.get(i).getPrice() <= maxPrice) {
                auxProducts.add(Products.get(i));
            }
        }
        Collections.sort(auxProducts, new PriceComparator());
        return auxProducts;
    }
    public List<Product> sortByCategory(List<Product> Products, String category) {
        List<Product> auxProducts = new ArrayList<Product>();
        for (int i = 0; i < Products.size(); i++) {
            if (Products.get(i).getClass().getSimpleName().toLowerCase().equals(category.toLowerCase())) {
                auxProducts.add(Products.get(i));
            }
        }
        return auxProducts;
    }

    public List<Product> sortByAscendingCategory(List<Product> Products) {
        List<Product> auxProducts = new ArrayList<Product>();
        List<String> ascendingCategories = new ArrayList<String>(List.of("book", "clothing", "cosmetic", "electronic",
            "food", "tourism", "toy"));
        for (int i = 0; i < Products.size(); i++) {
            for (int j = 0; j < ascendingCategories.size(); j++) {
                if (Products.get(i).getClass().getSimpleName().toLowerCase().equals(ascendingCategories.get(j))) {
                    auxProducts.add(Products.get(i));
                }
            }
        }
        return auxProducts;
    }

    public List<Product> sortByDescendingCategory(List<Product> Products) {
        List<Product> auxProducts = new ArrayList<Product>();
        List<String> descendingCategories = new ArrayList<String>(List.of("toy", "tourism", "food", "electronic",
            "cosmetic", "clothing", "book"));
        for (int i = 0; i < Products.size(); i++) {
            for (int j = 0; j < descendingCategories.size(); j++) {
                if (Products.get(i).getClass().getSimpleName().toLowerCase().equals(descendingCategories.get(j))) {
                    auxProducts.add(Products.get(i));
                }
            }
        }
        return auxProducts;
    }

    /*
        La búsqueda más reciente esta en la posición 3 y la más antigua en la 0
    */
    public List<Product> storableSearch(List<Product> SearchHistory, List<Product> Products, String searchText) {
        if (SearchHistory.size() == 3) {
            SearchHistory.remove(0);
        }
        for (int i = 0; i < Products.size(); i++) {
            if (Products.get(i).getName().toLowerCase().equals(searchText.toLowerCase())) {
                SearchHistory.add(Products.get(i));
            }
        }
        return SearchHistory;
    }
}
