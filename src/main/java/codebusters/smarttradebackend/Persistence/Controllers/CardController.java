package codebusters.smarttradebackend.Persistence.Controllers;

import codebusters.smarttradebackend.BusinessLogic.IntService.IUserService;
import codebusters.smarttradebackend.BusinessLogic.Models.Pagos.Card;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import codebusters.smarttradebackend.BusinessLogic.Service.PagosService.CardService;
import codebusters.smarttradebackend.BusinessLogic.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService service;
    UserService userController;
    @GetMapping("/cards")
    public List<Card> getCards() {
        return (List<Card>) service.getCards();
    }

    @GetMapping("/cardbyid")
    public Optional<Card> getCardsById(int id) {
        return (Optional<Card>) service.getCardsById(id);
    }

    @GetMapping("/cardsbyuser")
    public List<Card> getCardsByUser(int id) {
        User user = userController.getUserById(id).get();
        return (List<Card>) service.getCardByUser(user);
    }

    @GetMapping("/addcard")
    public Card addCard(String number, String name, String cvv, Date expireDate, User user) {
        return (Card) service.addCard(number, name, cvv, expireDate, user);
    }

}
