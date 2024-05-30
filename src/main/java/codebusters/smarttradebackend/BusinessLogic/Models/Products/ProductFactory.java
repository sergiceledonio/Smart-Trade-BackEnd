package codebusters.smarttradebackend.BusinessLogic.Models.Products;

import java.sql.Blob;

public class ProductFactory {
    public codebusters.smarttradebackend.BusinessLogic.Models.Products.Product createProduct(String[] parameters, Boolean pend, Boolean val, int user, Blob image)
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
        a.setUser_id(user);
        a.setImage(image);
        System.out.println(a.getName());
        return a;
    }
    public codebusters.smarttradebackend.BusinessLogic.Models.Products.Product createProduct(String[] parameters, int user, Blob image)
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
        a.setUser_id(user);
        a.setImage(image);
        System.out.println(a.getName());
        return a;
    }

}
