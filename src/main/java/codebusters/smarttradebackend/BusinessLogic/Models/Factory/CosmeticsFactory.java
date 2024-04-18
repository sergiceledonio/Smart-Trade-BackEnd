package codebusters.smarttradebackend.BusinessLogic.Models.Factory;

public class CosmeticsFactory {
    public Cosmetics createProduct(String[] parameters) {
        if (parameters.length < 6) {
            throw new IllegalArgumentException("Insufficient parameters to create Clothing.");
        }
        return new Cosmetics(parameters[0],parameters[1],parameters[2],parameters[3],parameters[4],parameters[5]);
    }
}