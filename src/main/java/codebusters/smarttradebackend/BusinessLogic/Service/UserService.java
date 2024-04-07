package codebusters.smarttradebackend.BusinessLogic.Service;

import codebusters.smarttradebackend.BusinessLogic.IntService.IUserService;
import codebusters.smarttradebackend.BusinessLogic.Models.User;
import codebusters.smarttradebackend.Persistence.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository data;
    @Override
    public ArrayList<User> getUsers() {
        return (ArrayList<User>) data.findAll();
    }

    @Override
    public Optional<User> getUserById(int id) {
        return data.findById(id);
    }

    @Override
    public int save(User u) {
        return 0;
    }

    @Override
    public void delete(String email) {

    }
}
