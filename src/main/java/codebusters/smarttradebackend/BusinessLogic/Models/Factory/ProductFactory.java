package codebusters.smarttradebackend.BusinessLogic.Models.Factory;

public abstract class ProductFactory {
    public abstract Product createProduct(String[] parameters);
}