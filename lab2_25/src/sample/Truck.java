package sample;

import java.util.ArrayList;

public class Truck {
    private ArrayList<Product> productsList;
    private double price;

    Truck(){
        productsList = new ArrayList<>();
        price = 0;
    }

    public void takeProducts(Product product) {
        productsList.add(product);
        price+=product.getPrice();
    }

    public void clear() {
        productsList.clear();
        price = 0;
    }

    public double getPrice() {
        return price;
    }
}
