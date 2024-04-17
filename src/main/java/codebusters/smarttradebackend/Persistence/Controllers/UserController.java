package codebusters.smarttradebackend.Persistence.Controllers;

import codebusters.smarttradebackend.BusinessLogic.Models.Users.Client;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.Seller;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.Usuario;
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
    public List<Usuario> getUsers() {
        return (List<Usuario>) service.getUsers();
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
    public ResponseEntity<Object> login(@RequestBody Map<String, String> userData) {
        String email = userData.get("email");
        String password = userData.get("password");

        Usuario user = service.login(email, password);
        boolean isSeller = false;
        List<Seller> lista = service.findAllSellers();

        for (Seller seller : lista) {
            if (seller.getEmail().equals(email)) {
                isSeller = true;
                break;
            }
        }

        if(user != null){
            Map<String, Object> response = new HashMap<>();
            response.put("email", user.getEmail());
            response.put("name", user.getName());
            response.put("isSeller", isSeller);
            response.put("password", user.getPassword());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
