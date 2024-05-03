package codebusters.smarttradebackend.BusinessLogic.Models.Products;
public class ProductFactory {
    public codebusters.smarttradebackend.BusinessLogic.Models.Products.Product createProduct(String[] parameters, boolean pend, boolean val)
    {
        if (parameters.length < 4) {
            throw new IllegalArgumentException("Insufficient parameters to create Product.");
        }
        Product a = new Product(parameters[0], Double.parseDouble(parameters[1]), parameters[2], parameters[3], pend, val);
        return a;
    }
    public codebusters.smarttradebackend.BusinessLogic.Models.Products.Product createProduct(String[] parameters)
    {
        if (parameters.length < 4) {
            throw new IllegalArgumentException("Insufficient parameters to create Product.");
        }
        Product a = new Product(parameters[0], Double.parseDouble(parameters[1]), parameters[2], parameters[3], true, false);
        return a;
    }

}
