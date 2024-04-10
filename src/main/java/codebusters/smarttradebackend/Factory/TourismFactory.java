package codebusters.smarttradebackend.Factory;

public class TourismFactory extends ProductFactory {
    @Override
    public Product createProduct(String[] parameters) {
        if (parameters.length < 6) {
            throw new IllegalArgumentException("Insufficient parameters to create Tourism.");
        }
        return new Tourism(parameters[0],parameters[1],parameters[2],parameters[3],parameters[4],parameters[5]);
    }
}