package codebusters.smarttradebackend.BusinessLogic.IntService;

import codebusters.smarttradebackend.BusinessLogic.Models.Users.Client;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.Seller;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public List<Usuario> getUsers();
    public Optional<Usuario> getUserById(int id);
    public int save(Usuario u);
    public void delete(String email);
    public Client clientRegister(int id, String email, String name, String password, String dni);
    public Seller sellerRegister(int id, String email, String name, String password, String cif, String iban);
    public Usuario login(String email, String password);
}
