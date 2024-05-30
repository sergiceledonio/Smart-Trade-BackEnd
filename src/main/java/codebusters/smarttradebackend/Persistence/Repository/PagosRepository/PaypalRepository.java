package codebusters.smarttradebackend.Persistence.Repository.PagosRepository;

import codebusters.smarttradebackend.BusinessLogic.Models.Pagos.Paypal;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaypalRepository extends JpaRepository<User, Integer> {

    @Query("select p from Paypal p where p.user = ?1")
    public List<Paypal> findByUser(User user);
    @Query("SELECT p FROM Paypal p")
    public List<Paypal> findAllPaypals();
    @Query("SELECT p FROM Paypal p where p.id = ?1")
    public Optional<Paypal> findById(int id);
}
