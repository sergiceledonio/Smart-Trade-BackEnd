package codebusters.smarttradebackend.BusinessLogic.Service.PagosService;

import codebusters.smarttradebackend.BusinessLogic.Models.Pagos.Card;
import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import codebusters.smarttradebackend.Persistence.Repository.PagosRepository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import codebusters.smarttradebackend.BusinessLogic.IntService.ICardService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CardService implements ICardService {
    @Autowired
    private CardRepository cardData;

    @Override
    public Optional<Card> getCardById(int id) {return (Optional<Card>) cardData.findById(id);}
    public List<Card> getCardByUser(User user){return (List<Card>) cardData.findByUser(user);};
    public List<Card> getCards(){return (List<Card>) cardData.findAllCards();};
    public Card addCard(String number, String name, String cvv, Date expireDate, User user){
        Card c = new Card();
        try {
            c.setNumber(number);
            c.setName(name);
            c.setCvv(cvv);
            c.setExpireDate(expireDate);
            c.setUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return c;
    };
    public void deleteCard(Card card){
        Optional<Card> deleted = getCardById(card.getId());
        cardData.deleteById(deleted.get().getId());
    };
}
