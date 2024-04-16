package codebusters.smarttradebackend.BusinessLogic.Service;

import codebusters.smarttradebackend.BusinessLogic.IntService.IUserService;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.*;
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

    public void clientRegister(int id, String email, String name, String password, String dni) {
        try {
            if (data.findClientByEmailAndPassword(email, password) != null) {
                throw new Exception("Cliente registrado anteriormante");
            }
            Client client = null;
            client.setId(id);
            client.setEmail(email);
            client.setName(name);
            client.setPassword(password);
            client.setDni(dni);
            data.save(client);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sellerRegister(int id, String email, String name, String password, String dni, String cif, String iban) {
        try {
            if (data.findSellerByEmailAndPassword(email, password) != null) {
                throw new Exception("Vendedor registrado anteriormante");
            }
            Seller seller = null;
            seller.setId(id);
            seller.setEmail(email);
            seller.setName(name);
            seller.setPassword(password);
            seller.setDni(dni);
            seller.setCif(cif);
            seller.setIban(iban);
            data.save(seller);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User login(String email, String password) {
        User user = null;
        try {
            user = data.findByEmailAndPassword(email, password);
            if (user == null) {
                throw new Exception("Usuario no registrado");
            } else {
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
