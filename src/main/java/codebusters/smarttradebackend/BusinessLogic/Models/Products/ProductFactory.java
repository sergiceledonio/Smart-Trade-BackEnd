package codebusters.smarttradebackend.BusinessLogic.Models.Products;
public class ProductFactory {
    public codebusters.smarttradebackend.BusinessLogic.Models.Products.Product createProduct(String[] parameters, boolean pend, boolean val)
    {
        if (parameters.length < 4) {
            throw new IllegalArgumentException("Insufficient parameters to create Product.");
        }
        Product a = new Product();
        a.setName(parameters[0]);
        a.setPrice(Double.parseDouble(parameters[1]));
        a.setType(parameters[2]);
        a.setDescription(parameters[3]);
        a.setPending(pend);
        a.setValidation(val);
        System.out.println(a.getName());
        return a;
    }
    public codebusters.smarttradebackend.BusinessLogic.Models.Products.Product createProduct(String[] parameters)
    {
        if (parameters.length < 4) {
            throw new IllegalArgumentException("Insufficient parameters to create Product.");
        }
        Product a = new Product();
        a.setName(parameters[0]);
        a.setPrice(Double.parseDouble(parameters[1]));
        a.setType(parameters[2]);
        a.setDescription(parameters[3]);
        a.setPending(true);
        a.setValidation(false);
        System.out.println(a.getName());
        return a;
    }

}
