package codebusters.smarttradebackend.Persistence.Controllers;

import codebusters.smarttradebackend.BusinessLogic.Models.User;
import codebusters.smarttradebackend.BusinessLogic.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/getUsers")
    public ArrayList<User> getUsers() {
        return (ArrayList<User>) service.getUsers();
    }
}
