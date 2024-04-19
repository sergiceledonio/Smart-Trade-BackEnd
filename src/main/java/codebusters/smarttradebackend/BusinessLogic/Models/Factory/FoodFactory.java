package codebusters.smarttradebackend.BusinessLogic.Models.Factory;

public class FoodFactory  {
    public Food createProduct(String[] parameters) {
        if (parameters.length < 5) {
            throw new IllegalArgumentException("Insufficient parameters to create Food.");
        }
        return new Food(parameters[0],parameters[1],parameters[2],parameters[3],parameters[4]);
    }
}