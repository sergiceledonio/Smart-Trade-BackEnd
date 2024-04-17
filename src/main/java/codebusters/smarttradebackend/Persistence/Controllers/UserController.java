package codebusters.smarttradebackend.Persistence.Controllers;

import codebusters.smarttradebackend.BusinessLogic.Models.Users.Client;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.Seller;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import codebusters.smarttradebackend.BusinessLogic.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return (List<User>) service.getUsers();
    }

    @PostMapping("/Client")
    public Client registerClient(@RequestBody Client client) {
        return service.clientRegister(1, client.getEmail(), client.getName(), client.getPassword(), client.getDni());
    }
    @PostMapping("/Seller")
    public Seller registerSeller(@RequestBody Seller seller) {
       return service.sellerRegister(1, seller.getEmail(), seller.getName(), seller.getPassword(), seller.getCif(), seller.getIban());
    }
    @PostMapping("Login")
    public Object[] login(@RequestParam String email, @RequestParam String password) {
        User user = service.login(email, password);
        Boolean isSeller = service.isSeller(user);
        Object[] res = {user.getEmail(), user.getPassword(), user.getName(), user.getDni(), isSeller};
        if (user != null) {
            return res;
        } else {
            return null;
        }
    }

}
