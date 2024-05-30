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

    UserService userController;
    @Autowired
    private PaypalService service;
    @GetMapping("/paypals")
    public List<Paypal> getpaypals() {
        return (List<Paypal>) service.getPaypals();
    }

    @GetMapping("/Paypalbyid")
    public Optional<Paypal> getPaypalsById(int id) {
        return (Optional<Paypal>) service.getPaypalById(id);
    }

    @GetMapping("/Paypalsbyuser")
    public List<Paypal> getPaypalsByUser(int id) {
        User user = userController.getUserById(id).get();
        return (List<Paypal>) service.getPaypalByUser(user);
    }

    @GetMapping("/addPaypal")
    public Paypal addPaypal(String number, String email, String password, User user) {
        return (Paypal) service.addPaypal(email, password, user);
    }

}
