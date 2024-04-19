package codebusters.smarttradebackend.BusinessLogic.Models.Factory;

public class TourismFactory {

    public Tourism createProduct(String[] parameters) {
        if (parameters.length < 6) {
            throw new IllegalArgumentException("Insufficient parameters to create Tourism.");
        }
        return new Tourism(parameters[0],parameters[1],parameters[2],parameters[3],parameters[4],parameters[5]);
    }
}