package codebusters.smarttradebackend.BusinessLogic.Models.Factory;

public class ElectronicsFactory extends ProductFactory {
    @Override
    public Product createProduct(String[] parameters) {
        if (parameters.length < 5) {
            throw new IllegalArgumentException("Insufficient parameters to create Electronics.");
        }
        return new Electronics(parameters[0],parameters[1],parameters[2],parameters[3],parameters[4]);
    }
}