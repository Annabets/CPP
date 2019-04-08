package sample;

import java.util.ArrayList;
import java.util.List;

public class Package {
    private List<Product> products;

    Package(){
        products = new ArrayList<>();
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}
