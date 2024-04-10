package codebusters.smarttradebackend.BusinessLogic.Service;

import codebusters.smarttradebackend.BusinessLogic.IntService.IUserService;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import codebusters.smarttradebackend.Persistence.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository data;

    @Override
    public List<User> getUsers() {
        return (List<User>) data.findAll();
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

    public void register(User user) {
        try {
            if (data.findByEmailAndPassword(user.getEmail(), user.getPassword()) != null) {
                throw new Exception("Usuario registrado anteriormante");
            }
            data.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User login(String email, String password) {
        try {
            User user = data.findByEmailAndPassword(email, password);
            if (user == null) {
                throw new Exception("Usuario no registrado");
            }else{
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
