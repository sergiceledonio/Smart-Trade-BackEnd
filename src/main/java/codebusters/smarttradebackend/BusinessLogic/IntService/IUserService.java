package codebusters.smarttradebackend.BusinessLogic.IntService;

import codebusters.smarttradebackend.BusinessLogic.Models.Users.Client;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.Seller;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public List<User> getUsers();
    public Optional<User> getUserById(int id);
    public User save(User u);
    public void delete(String email);
    public Client clientRegister(String email, String name, String password, String dni);
    public Seller sellerRegister(String email, String name, String password, String cif, String iban);
    public User login(String email, String password);
}
