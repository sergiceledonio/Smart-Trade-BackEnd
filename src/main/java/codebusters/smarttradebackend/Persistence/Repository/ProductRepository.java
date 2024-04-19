package codebusters.smarttradebackend.Persistence.Repository;

import codebusters.smarttradebackend.BusinessLogic.Models.Factory.Product;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<User, Integer> {

    @Query("select u from Product u")
    public List<Product> findAllProducts();
}
