package codebusters.smarttradebackend.BusinessLogic.Service;

import codebusters.smarttradebackend.BusinessLogic.IntService.IUserService;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.*;
import codebusters.smarttradebackend.Persistence.Repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository data;

    @Override
    public List<Usuario> getUsers() {
        return (List<Usuario>) data.findAllUsers();
    }


    @Override
    public Optional<Usuario> getUserById(int id) {
        return data.findById(id);
    }

    @Override
    public int save(Usuario u) {
        return 0;
    }

    @Override
    public void delete(String email) {

    }

    public Client clientRegister(int id, String email, String name, String password, String dni) {
        Client client = new Client();
        try {
            if (data.findClientByEmailAndPassword(email, password) != null) {
                throw new Exception("Cliente registrado anteriormante");
            }
            client.setId(id);
            client.setEmail(email);
            client.setName(name);
            client.setPassword(password);
            client.setDni(dni);
            data.save(client);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return client;
    }

    public Seller sellerRegister(int id, String email, String name, String password, String cif, String iban) {
        Seller seller = new Seller();
        try {
            if (data.findSellerByEmailAndPassword(email, password) != null) {
                throw new Exception("Vendedor registrado anteriormante");
            }
            seller.setId(id);
            seller.setEmail(email);
            seller.setName(name);
            seller.setPassword(password);
            seller.setCif(cif);
            seller.setIban(iban);
            data.save(seller);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seller;
    }

    public Usuario login(String email, String password) {
        Usuario myuser = null;
        try {
            myuser = data.findByEmailAndPassword(email, password);
            if (myuser == null) {
                throw new Exception("Usuario no registrado");
            } else {
                return myuser;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Seller> findAllSellers() {
        return  data.findAllSellers();
    }
}
