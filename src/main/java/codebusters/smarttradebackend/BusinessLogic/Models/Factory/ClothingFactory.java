package codebusters.smarttradebackend.BusinessLogic.Models.Factory;

public class ClothingFactory extends ProductFactory {
    @Override
    public Product createProduct(String[] parameters) {
        if (parameters.length < 7) {
            throw new IllegalArgumentException("Insufficient parameters to create Clothing.");
        }
        return new Clothing(parameters[0],parameters[1],parameters[2],parameters[3],parameters[4],parameters[5],parameters[6]);
    }
}