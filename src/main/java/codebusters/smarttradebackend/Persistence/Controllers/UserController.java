package codebusters.smarttradebackend.Persistence.Controllers;

import codebusters.smarttradebackend.BusinessLogic.Models.Users.Client;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.Seller;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import codebusters.smarttradebackend.BusinessLogic.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return this.service.clientRegister(client.getEmail(), client.getName(), client.getPassword(), client.getDni());
    }
    @PostMapping("/Seller")
    public Seller registerSeller(@RequestBody Seller seller) {
       return this.service.sellerRegister(seller.getEmail(), seller.getName(), seller.getPassword(), seller.getCif(), seller.getIban());
    }
    @PostMapping("Login")
    public ResponseEntity<Object> login(@RequestBody Map<String, String> userData) {
        String email = userData.get("email");
        String password = userData.get("password");

        User user = service.login(email, password);

        if (user != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("email", user.getEmail());
            response.put("name", user.getName());
            response.put("password", user.getPassword());

            if (user instanceof Client) {
                Client client = (Client) user;
                response.put("isSeller", false);
                response.put("dni", client.getDni());
                response.put("cif", "");
                response.put("iban", "");
            } else if (user instanceof Seller) {
                Seller seller = (Seller) user;
                response.put("isSeller", true);
                response.put("cif", seller.getCif());
                response.put("iban", seller.getIban());
                response.put("dni", "");
            }

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
