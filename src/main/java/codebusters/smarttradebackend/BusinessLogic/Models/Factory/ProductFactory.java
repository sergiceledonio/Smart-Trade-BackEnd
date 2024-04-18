package codebusters.smarttradebackend.BusinessLogic.Models.Factory;

public class ProductFactory {
    public Product createProduct(String[] parameters)
    {
        if (parameters.length < 4) {
            throw new IllegalArgumentException("Insufficient parameters to create Product.");
        }
        return new Product(parameters[0],parameters[1],parameters[2],parameters[3]);
    };
}