package codebusters.smarttradebackend.Persistence.Repository.PagosRepository;

import codebusters.smarttradebackend.BusinessLogic.Models.Pagos.Paypal;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaypalRepository extends JpaRepository<Paypal, Integer> {

    @Query("select c from Paypal c where c.user.id = :user")
    public List<Paypal> findByUser(int user);
    @Query("SELECT c FROM Paypal c")
    public List<Paypal> findAllCards();
    @Query("SELECT c FROM Paypal c where c.id = :id")
    public Optional<Paypal> findById(int id);
}
