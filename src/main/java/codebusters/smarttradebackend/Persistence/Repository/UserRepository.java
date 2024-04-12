package codebusters.smarttradebackend.Persistence.Repository;

import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.Email = ?1 and u.Password = ?2")
    public User findByEmailAndPassword(String email, String password);

    @Query("select c from Client c where c.Email = ?1 and c.Password = ?2")
    public User findClientByEmailAndPassword(String email, String password);

    @Query("select s from Seller s where s.Email = ?1 and s.Password = ?2")
    public User findSellerByEmailAndPassword(String email, String password);
}
