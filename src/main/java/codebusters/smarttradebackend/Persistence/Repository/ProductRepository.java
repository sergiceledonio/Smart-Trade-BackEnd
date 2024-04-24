package codebusters.smarttradebackend.Persistence.Repository;

import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE p.type = 'book'")
    public List<Product> findAllBooks();

    @Query("SELECT u FROM User u WHERE u.type = 'clothing'")
    public List<Product> findAllClothing();

    @Query("SELECT u FROM User u WHERE u.type = 'cosmetics'")
    public List<Product> findAllCosmetics();

    @Query("SELECT u FROM User u WHERE u.type = 'electronics'")
    public List<Product> findAllElectronics();

    @Query("SELECT u FROM User u WHERE u.type = 'food'")
    public List<Product> findAllFood();

    @Query("SELECT u FROM User u WHERE u.type = 'tourism'")
    public List<Product> findAllTourism();

    @Query("SELECT u FROM User u WHERE u.type = 'toy'")
    public List<Product> findAllToys();

}