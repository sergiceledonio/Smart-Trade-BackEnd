package codebusters.smarttradebackend.BusinessLogic.Models.Factory;

public class BooksFactory extends ProductFactory {
    @Override
    public Product createProduct(String[] parameters) {
        if (parameters.length < 7) {
            throw new IllegalArgumentException("Insufficient parameters to create Clothing.");
        }
        return new Books(parameters[0],parameters[1],parameters[2],parameters[3],parameters[4],parameters[5],parameters[6]);
    }
}