package sample;

public class Customer {
    private double money;
    private Truck truck;
    private Product product;

    Customer(Truck truck, double money){
        this.money = money;
        this.truck = truck;
    }

    public Truck getTruck() {
        return truck;
    }

    public  double getMoney(){
        return money;
    }

    public void put() {
        truck.takeProducts(product);
    }

    public void get(Product p) {
        product = p;
    }

    public void pay() {
        if(money>=truck.getPrice()) {
            money-=truck.getPrice();
            truck.clear();
        }
        else {
            truck.clear();
        }
    }
}
