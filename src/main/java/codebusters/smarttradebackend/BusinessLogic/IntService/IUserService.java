package codebusters.smarttradebackend.BusinessLogic.IntService;

import codebusters.smarttradebackend.BusinessLogic.Models.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public List<User> listar();
    public Optional<User> listarId(String email);
    public int save(User u);
    public void delete(String email);
}
