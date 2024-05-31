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

import javax.print.attribute.standard.JobKOctets;
import java.util.*;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService service;
    @Autowired
    private UserService userController;
    @GetMapping("/cards")
    public List<Card> getCards() {
        return (List<Card>) service.getCards();
    }

    @GetMapping("/cardbyid")
    public Optional<Card> getCardsById(@RequestParam ("user_id") int id) {
        return (Optional<Card>) service.getCardsById(id);
    }

    @GetMapping("/cardsbyuser")
    public List<Card> getCardsByUser(@RequestParam ("user_id") int id) {
        User user = userController.getUserById(id).get();
        return (List<Card>) service.getCardByUser(user);
    }

    @PostMapping("/addcard")
    public Card addCard(@RequestBody Map<String, Object> cardData) {
        int id = (int)cardData.get("id");
        String number = (String) cardData.get("number");
        String name = (String) cardData.get("name");
        String cvv = (String) cardData.get("cvv");
        String expireDate = (String) cardData.get("expireDate");
        User user = userController.getUserById(id).get();
        return (Card) service.addCard(number, name, cvv, expireDate, user);
    }

}
