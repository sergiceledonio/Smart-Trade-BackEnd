package codebusters.smarttradebackend.BusinessLogic.Service.PagosService;

import codebusters.smarttradebackend.BusinessLogic.Models.Pagos.Card;
import codebusters.smarttradebackend.BusinessLogic.Models.Pagos.Paypal;
import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import codebusters.smarttradebackend.Persistence.Repository.PagosRepository.PaypalRepository;
import codebusters.smarttradebackend.Persistence.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import codebusters.smarttradebackend.BusinessLogic.IntService.IPaypalService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PaypalService implements IPaypalService{
    @Autowired
    private PaypalRepository paypalData;
    @Autowired
    private UserRepository userData;

    public Optional<Paypal> getPaypalById(int id) {return (Optional<Paypal>) paypalData.findById(id);};
    public List<Paypal> getPaypalByUser(int user){return (List<Paypal>) paypalData.findByUser(userData.findById(user).get());};
    public void addPaypal(String email, String password, int user){
        Optional<User> userOptional = userData.findById(user);
        if (userOptional.isPresent()) {
            Paypal p = new Paypal(email, password, userOptional.get());
            try {
                paypalData.save(p);
        } catch (Exception e) {
            e.printStackTrace();

        }

    };
}
}
