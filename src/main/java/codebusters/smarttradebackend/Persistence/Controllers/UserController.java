package codebusters.smarttradebackend.Persistence.Controllers;

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
        service.register(user);
    }
    @PostMapping("/registerSeller")
    public void registerSeller(@RequestBody User user) {
        service.register(user);
    }

}
