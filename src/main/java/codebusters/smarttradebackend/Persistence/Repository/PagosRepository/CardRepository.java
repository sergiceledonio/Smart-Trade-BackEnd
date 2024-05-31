package codebusters.smarttradebackend.Persistence.Repository.PagosRepository;

import codebusters.smarttradebackend.BusinessLogic.Models.Pagos.Card;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

    @Query("select c from Card c where c.user.id = :user")
    public List<Card> findByUser(int user);
    @Query("SELECT c FROM Card c")
    public List<Card> findAllCards();
    @Query("SELECT c FROM Card c where c.id = :id")
    public Optional<Card> findById(int id);
}
