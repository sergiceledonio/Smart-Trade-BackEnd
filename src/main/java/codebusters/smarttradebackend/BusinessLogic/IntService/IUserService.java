package codebusters.smarttradebackend.BusinessLogic.IntService;

import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public List<User> getUsers();
    public Optional<User> getUserById(int id);
    public User save(User u);
    public void delete(String email);
    public User clientRegister(String email, String name, String password, String dni);
    public User sellerRegister(String email, String name, String password, String cif, String iban);
    public Object[] login(String email, String password);
}
