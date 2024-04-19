package codebusters.smarttradebackend.Persistence.Repository;

import codebusters.smarttradebackend.BusinessLogic.Models.Users.Client;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.Seller;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    @Query("select u from User u where u.Email = ?1 and u.Password = ?2")
    public User findByEmailAndPassword(String email, String password);

    @Query("select c from Client c where c.Email = ?1 and c.Password = ?2")
    public Client findClientByEmailAndPassword(String email, String password);

    @Query("select s from Seller s where s.Email = ?1 and s.Password = ?2")
    public Seller findSellerByEmailAndPassword(String email, String password);
    @Query("SELECT s  FROM Seller s")
    public List<Seller> findAllSellers();
    @Query("SELECT c FROM Client c")
    public List<Client> findAllClients();
}
