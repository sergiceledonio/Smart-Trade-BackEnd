package codebusters.smarttradebackend.Persistence.Repository;

import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.email = ?1 and u.password = ?2")
    public User findByEmailAndPassword(String email, String password);

    @Query("SELECT u FROM User u WHERE u.type = 'seller'")
    public List<User> findAllSellers();
    @Query("SELECT u FROM User u WHERE u.type = 'client'")
    public List<User> findAllClients();

    @Query("SELECT u FROM User u WHERE u.type = 'admin'")
    public List<User> findAllAdmins();
}
