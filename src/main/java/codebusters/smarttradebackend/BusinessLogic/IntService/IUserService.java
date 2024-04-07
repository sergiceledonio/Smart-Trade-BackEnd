package codebusters.smarttradebackend.BusinessLogic.IntService;

import codebusters.smarttradebackend.BusinessLogic.Models.User;

import java.util.ArrayList;
import java.util.Optional;

public interface IUserService {
    public ArrayList<User> getUsers();
    public Optional<User> getUserById(int id);
    public int save(User u);
    public void delete(String email);
}
