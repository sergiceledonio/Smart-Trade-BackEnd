package codebusters.smarttradebackend.BusinessLogic.IntService;

import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public List<User> getUsers();
    public Optional<User> getUserById(int id);
    public int save(User u);
    public void delete(String email);
    public void clientRegister(int id, String email, String name, String password, String dni);
    public void sellerRegister(int id, String email, String name, String password, String cif, String iban);
    public User login(String email, String password);
}
