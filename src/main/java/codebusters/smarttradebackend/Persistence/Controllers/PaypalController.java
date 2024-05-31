package codebusters.smarttradebackend.Persistence.Controllers;

import codebusters.smarttradebackend.BusinessLogic.Models.Pagos.Paypal;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import codebusters.smarttradebackend.BusinessLogic.Service.PagosService.PaypalService;
import codebusters.smarttradebackend.BusinessLogic.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/paypal")
public class PaypalController {

    @Autowired
    private PaypalService service;

    @GetMapping("/paypalbyid")
    public Optional<Paypal> getPaypalsById(@RequestParam ("user_id") int id) {
        return (Optional<Paypal>) service.getPaypalById(id);
    }

    @GetMapping("/paypalsbyuser")
    public List<Paypal> getPaypalsByUser(@RequestParam ("id") int id) {
        return (List<Paypal>) service.getPaypalByUser(id);
    }

    @PostMapping("/addPaypal")
    public void addPaypal(@RequestBody Map<String, Object> cardData) {
        int id = (int)cardData.get("id");
        String email = (String) cardData.get("email");
        String password = (String) cardData.get("password");
        service.addPaypal(email, password, id);
    }

}
