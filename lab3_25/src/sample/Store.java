package sample;

public class Store {
    private String storeName;
    private Customer customer;

    Store(String storeName, Customer customer) {
        this.storeName = storeName;
        this.customer = customer;
    }

    public void askForMoney() {
        try {
            customer.pay();
        } catch (NoMoneyException exception) {
            System.out.println("You have "+exception.getMessage());
        } catch (NoProductsInTruckException exception) {
            System.out.println("Sorry, but "+exception.getMessage());
        } catch (Exception exception) {
            System.out.println("Unexpected exception");
            System.out.println(exception.getMessage());
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getStoreName() {
        return storeName;
    }
}
