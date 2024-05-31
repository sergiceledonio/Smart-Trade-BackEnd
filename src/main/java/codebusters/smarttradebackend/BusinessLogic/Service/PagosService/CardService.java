package codebusters.smarttradebackend.BusinessLogic.Service.PagosService;

import codebusters.smarttradebackend.BusinessLogic.Models.Pagos.Card;
import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import codebusters.smarttradebackend.Persistence.Repository.PagosRepository.CardRepository;
import codebusters.smarttradebackend.Persistence.Repository.UserRepository;
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
    @Autowired
    private UserRepository userData;

    @Override
    public Optional<Card> getCardsById(int id) {return (Optional<Card>) cardData.findById(id);}
    public List<Card> getCardByUser(int user){return (List<Card>) cardData.findByUser(userData.findById(user).get());};
    public List<Card> getCards(){return (List<Card>) cardData.findAllCards();};
    public Card addCard(String number, String name, String cvv, String expireDate, int user){
        Card c = new Card();
        try {
            c.setNumber(number);
            c.setName(name);
            c.setCvv(cvv);
            c.setExpireDate(expireDate);
            c.setUser(userData.findById(user).get());
            cardData.save(c);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return c;
    };
    public void deleteCard(Card card){
        Optional<Card> deleted = getCardsById(card.getId());
        cardData.deleteById(deleted.get().getId());
    };
}
