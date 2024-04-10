package codebusters.smarttradebackend.Factory;

public class FoodFactory extends ProductFactory {
    @Override
    public Product createProduct(String[] parameters) {
        if (parameters.length < 5) {
            throw new IllegalArgumentException("Insufficient parameters to create Food.");
        }
        return new Food(parameters[0],parameters[1],parameters[2],parameters[3],parameters[4]);
    }
}