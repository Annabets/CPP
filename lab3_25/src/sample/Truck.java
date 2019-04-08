package sample;

import java.util.ArrayList;
import java.util.List;

public class Truck {
    private List<Product> products;
    private double price;

    Truck() {
        products = new ArrayList<>();
        price = 0;
    }

    public void addProduct(Product product) {
        products.add(product);
        price += product.getPrice();
    }

    public void clear() {
        products.clear();
        price = 0;
    }

    public double getPrice() {
        return price;
    }

    public List<Product> getProducts() {
        return products;
    }
}
