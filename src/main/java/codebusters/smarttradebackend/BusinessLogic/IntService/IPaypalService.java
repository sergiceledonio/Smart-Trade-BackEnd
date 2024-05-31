package codebusters.smarttradebackend.BusinessLogic.IntService;

import codebusters.smarttradebackend.BusinessLogic.Models.Pagos.Card;
import codebusters.smarttradebackend.BusinessLogic.Models.Pagos.Paypal;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IPaypalService {

    public Optional<Paypal> getPaypalById(int id);
    public List<Paypal> getPaypalByUser(int user);
    public void addPaypal(String email, String password, int user);

}
