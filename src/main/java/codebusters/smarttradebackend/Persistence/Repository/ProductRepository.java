package codebusters.smarttradebackend.Persistence.Repository;

import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE %:nombre%")
    public Optional<Product> findProductByName(@Param("nombre") String nombre);

    @Query("SELECT p FROM Product p WHERE p.user_id = :user_id")
    public List<Product> findProductsByUser(int user_id);

    @Query("SELECT p FROM Product p WHERE p.type = 'book'")
    public List<Product> findAllBooks();

    @Query("SELECT p FROM Product p WHERE p.type = 'clothing'")
    public List<Product> findAllClothing();

    @Query("SELECT p FROM Product p WHERE p.type = 'cosmetics'")
    public List<Product> findAllCosmetics();

    @Query("SELECT p FROM Product p WHERE p.type = 'electronics'")
    public List<Product> findAllElectronics();

    @Query("SELECT p FROM Product p WHERE p.type = 'food'")
    public List<Product> findAllFood();

    @Query("SELECT p FROM Product p WHERE p.type = 'tourism'")
    public List<Product> findAllTourism();

    @Query("SELECT p FROM Product p WHERE p.type = 'toy'")
    public List<Product> findAllToys();

    @Query("SELECT p FROM Product p WHERE p.pending = true")
    public List<Product> findPendingProducts();

    @Query("SELECT p FROM Product p WHERE p.validation = true")
    public List<Product> findValProducts();

}
