package codebusters.smarttradebackend.Persistence.Controllers;

import codebusters.smarttradebackend.BusinessLogic.Models.Users.Seller;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import codebusters.smarttradebackend.BusinessLogic.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/registerClient")
    public void registerClient(@RequestBody User user) {
        service.clientRegister(user.getId(), user.getEmail(), user.getName(), user.getPassword(), user.getDni());
    }
    @PostMapping("/registerSeller")
    public void registerSeller(@RequestBody Seller user) {
        service.sellerRegister(user.getId(), user.getEmail(),
                user.getName(), user.getPassword(), user.getDni(), user.getCif(), user.getIban());
    }

}
