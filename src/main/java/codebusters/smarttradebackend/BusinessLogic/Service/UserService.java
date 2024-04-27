package codebusters.smarttradebackend.BusinessLogic.Service;

import codebusters.smarttradebackend.BusinessLogic.IntService.IUserService;
import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
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
    public User save(User u) {
        return data.save(u);
    }

    @Override
    public void delete(String email) {

    }

    public User clientRegister(String email, String name, String password, String dni) {
        User client = new User();
        try {
            if (data.findByEmailAndPassword(email, password) != null) {
                throw new Exception("Cliente registrado anteriormante, el email es: " +email+ " y la contraseña: " + password);
            }

            client.setType("client");
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

    public User sellerRegister(String email, String name, String password, String cif, String iban) {
        User seller = new User();
        try {
            if (data.findByEmailAndPassword(email, password) != null) {
                throw new Exception("Vendedor registrado anteriormante el email es: " +email+ " y la contraseña: " + password);
            }

            seller.setType("seller");
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

    public User adminRegister(String email, String name, String password) {
        User admin = new User();
        try {
            if (email.equals("admin@admin.com") && password.equals("12345678")) {
                admin.setType("admin");
                admin.setEmail(email);
                admin.setPassword(password);
                admin.setName(name);
                data.save(admin);
            } else {
                throw new Exception("El usuario no es administrador");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admin;
    }

    public Object[] login(String email, String password) {
        User myuser = null;
        Object[] res = new Object[2];
        try {
            myuser = data.findByEmailAndPassword(email, password);
            if (myuser == null) {
                throw new Exception("EL usuario no esta registrado");
            } else if (myuser.getType().equals("client")) {
                System.out.println("El usuario que quiere acceder es el cliente: " + email + " y " + password);
                res[0] = 1;
                res[1] = myuser;
            } else if(myuser.getType().equals("seller")){
                System.out.println("El usuario que quiere acceder es el vendedor: " + email + " y " + password);
                res[0] = 2;
                res[1] = myuser;
            } else {
                System.out.println("El usuario que quiere acceder es el administrador: " + email + " y " + password);
                res[0] = 3;
                res[1] = myuser;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public List<User> findAllSellers() {
        return  data.findAllSellers();
    }

    public List<User> findAllClients() {
        return  data.findAllClients();
    }

    public List<User> findAllAdmins() {
        return  data.findAllAdmins();
    }

}
