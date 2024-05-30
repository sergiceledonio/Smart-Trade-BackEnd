package codebusters.smarttradebackend.BusinessLogic.IntService;

import codebusters.smarttradebackend.BusinessLogic.Models.Pagos.Card;
import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ICardService {

    public Optional<Card> getCardsById(int id);
    public List<Card> getCardByUser(User user);
    public List<Card> getCards();
    public Card addCard(String number, String name, String cvv, String expireDate, User user);
    public void deleteCard(Card card);

}
