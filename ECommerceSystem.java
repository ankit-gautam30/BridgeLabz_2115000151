import java.util.ArrayList;
import java.util.List;

// Product class
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Order class (Aggregation - contains multiple products)
class Order {
    private int orderId;
    private List<Product> products;
    private Customer customer;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void listOrderDetails() {
        System.out.println("Order ID: " + orderId + " for Customer: " + customer.getName());
        System.out.println("Products:");
        for (Product product : products) {
            System.out.println("  " + product.getName() + " - $" + product.getPrice());
        }
    }
}

// Customer class
class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public String getName() {
        return name;
    }

    public void listOrders() {
        System.out.println("Customer: " + name);
        for (Order order : orders) {
            order.listOrderDetails();
        }
    }
}

// E-commerce platform class
class ECommercePlatform {
    private String name;
    private List<Customer> customers;
    private List<Product> products;

    public ECommercePlatform(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void listPlatformDetails() {
        System.out.println("E-Commerce Platform: " + name);
        System.out.println("Available Products:");
        for (Product product : products) {
            System.out.println("  " + product.getName() + " - $" + product.getPrice());
        }
    }
}

// Main class to demonstrate relationships
public class ECommerceSystem {
    public static void main(String[] args) {
        // Creating e-commerce platform
        ECommercePlatform platform = new ECommercePlatform("ShopEasy");

        // Creating products
        Product laptop = new Product("Laptop", 999.99);
        Product phone = new Product("Smartphone", 699.99);
        platform.addProduct(laptop);
        platform.addProduct(phone);

        // Creating customers
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");
        platform.addCustomer(customer1);
        platform.addCustomer(customer2);

        // Creating and placing orders
        Order order1 = new Order(101, customer1);
        order1.addProduct(laptop);
        order1.addProduct(phone);
        customer1.placeOrder(order1);

        Order order2 = new Order(102, customer2);
        order2.addProduct(phone);
        customer2.placeOrder(order2);

        // Displaying platform details
        platform.listPlatformDetails();
        System.out.println();

        // Displaying customer orders
        customer1.listOrders();
        customer2.listOrders();
    }
}
