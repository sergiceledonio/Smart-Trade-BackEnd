package codebusters.smarttradebackend.BusinessLogic.Service.PagosService;

import codebusters.smarttradebackend.BusinessLogic.Models.Pagos.Card;
import codebusters.smarttradebackend.BusinessLogic.Models.Pagos.Paypal;
import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import codebusters.smarttradebackend.Persistence.Repository.PagosRepository.PaypalRepository;
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

    public Optional<Paypal> getPaypalById(int id) {return (Optional<Paypal>) paypalData.findById(id);};
    public List<Paypal> getPaypalByUser(User user){return (List<Paypal>) paypalData.findByUser(user);};
    public List<Paypal> getPaypals(){return (List<Paypal>) paypalData.findAllPaypals();};
    public Paypal addPaypal(String email, String password, User user){
        Paypal p = new Paypal();
        try {
            p.setEmail(email);
            p.setPassword(password);
            p.setUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return p;
    };
    public void deletePaypal(Paypal paypal){
        Optional<Paypal> deleted = getPaypalById(paypal.getId());
        paypalData.deleteById(deleted.get().getId());
    };
}
