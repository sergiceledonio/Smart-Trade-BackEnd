package codebusters.smarttradebackend.Persistence.Controllers;

import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) service.getUsers();
    }

    @GetMapping("/clients")
    public List<User> getClients() {
        return (List<User>) service.findAllClients();
    }

    @GetMapping("/sellers")
    public List<User> getSellers() {
        return (List<User>) service.findAllSellers();
    }

    @GetMapping("/admins")
    public List<User> getAdmins() {
        return (List<User>) service.findAllSellers();
    }

    @PostMapping("/newclient")
    public User registerClient(@RequestBody User client) {
        return this.service.clientRegister(client.getEmail(), client.getName(), client.getPassword(), client.getDni(), client.getCity(), client.getStreet(), client.getNumber(), client.getFlat(), client.getDoor());
    }
    @PostMapping("/newseller")
    public User registerSeller(@RequestBody User seller) {
       return this.service.sellerRegister(seller.getEmail(), seller.getName(), seller.getPassword(), seller.getCif(), seller.getIban(), seller.getCity(), seller.getStreet(), seller.getNumber(), seller.getFlat(), seller.getDoor());
    }

    @PostMapping("/newadmin")
    public User registerAdmin(@RequestBody User admin) {
        return this.service.adminRegister(admin.getEmail(), admin.getName(), admin.getPassword());
    }


    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Map<String, String> userData) {
        String email = userData.get("email");
        String password = userData.get("password");

        Object[] user = service.login(email, password);
        User usuario = (User) user[1];

        if ((int) user[0] == 1) {
            Map<String, Object> response = new HashMap<>();
            response.put("email", usuario.getEmail());
            response.put("name", usuario.getName());
            response.put("password", usuario.getPassword());
            response.put("dni", usuario.getDni());
            response.put("type", 1);
            return ResponseEntity.ok(response);
        } else if((int) user[0] == 2) {
            Map<String, Object> response = new HashMap<>();
            response.put("email", usuario.getEmail());
            response.put("name", usuario.getName());
            response.put("password", usuario.getPassword());
            response.put("cif", usuario.getCif());
            response.put("iban", usuario.getIban());
            response.put("type", 2);
            return ResponseEntity.ok(response);
        } else if ((int) user[0] == 3){
            Map<String, Object> response = new HashMap<>();
            response.put("email", usuario.getEmail());
            response.put("name", usuario.getName());
            response.put("password", usuario.getPassword());
            response.put("type", 3);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
