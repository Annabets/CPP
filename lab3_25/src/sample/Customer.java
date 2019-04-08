package sample;

public class Customer {
    private double money;
    private Truck truck;
    private Package pack;
    private Product product;

    Customer(Truck truck, double money) {
        this.money = money;
        this.truck = truck;
        pack = new Package();
    }

    public Truck getTruck() {
        return truck;
    }

    public double getMoney() {
        return money;
    }

    public Package getPack() {
        return pack;
    }

    public void putProductToTruck() {
        truck.addProduct(product);
    }

    public void putProductToPackage() {
        pack.addProduct(product);
    }

    public void takeProduct(Product p) {
        product = p;
    }

    public void pay() throws Exception {
        if (money >= truck.getPrice()) {
            if(truck.getProducts().isEmpty()){
                throw new NoProductsInTruckException("there are no products in the truck.");
            }
            money -= truck.getPrice();
            for (Product i : truck.getProducts()) {
                product = i;
                putProductToPackage();
            }
            truck.clear();
        } else {
            truck.clear();
            throw new NoMoneyException("insufficient funds");
        }
    }
}
