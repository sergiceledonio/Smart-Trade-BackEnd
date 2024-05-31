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

    @Query("select c from Card c where c.user = ?1")
    public List<Paypal> findByUser(User user);
    @Query("SELECT c FROM Card c")
    public List<Paypal> findAllCards();
    @Query("SELECT c FROM Card c where c.id = ?1")
    public Optional<Paypal> findById(int id);
}
