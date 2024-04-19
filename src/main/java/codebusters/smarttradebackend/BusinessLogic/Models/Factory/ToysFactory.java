package codebusters.smarttradebackend.BusinessLogic.Models.Factory;

public class ToysFactory  {
    public Toys createProduct(String[] parameters) {
        if (parameters.length < 5) {
            throw new IllegalArgumentException("Insufficient parameters to create Toys.");
        }
        return new Toys(parameters[0],parameters[1],parameters[2],parameters[3],parameters[4]);
    }
}