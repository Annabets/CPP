package sample;

public class Store {
    private String storeName;
    private Customer customer;

    Store(String storeName,Customer customer){
        this.storeName = storeName;
        this.customer = customer;
    }

    public void askForMoney() {
        customer.pay();
    }

    public Customer getCustomer() {
        return customer;
    }
}
