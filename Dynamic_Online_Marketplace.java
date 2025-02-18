// Enums for Product Categories
enum BookCategory {
    FICTION, NON_FICTION, SCIENCE, HISTORY
}

enum ClothingCategory {
    MEN, WOMEN, KIDS, ACCESSORIES
}

enum GadgetCategory {
    MOBILE, LAPTOP, TABLET, ACCESSORY
}

// Generic Product Class
class Product<T> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}

// Marketplace Class with Discount Method
class Marketplace {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountAmount = product.getPrice() * (percentage / 100);
        double newPrice = product.getPrice() - discountAmount;
        product.setPrice(newPrice);
        System.out.println("Discount applied! New price of " + product.getName() + " is: " + newPrice);
    }
}

// Main Class to Demonstrate Functionality
public class Dynamic_Online_Marketplace {
    public static void main(String[] args) {
        // Creating Products
        Product<BookCategory> book = new Product<>("Effective Java", 45.00, BookCategory.NON_FICTION);
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 20.00, ClothingCategory.MEN);
        Product<GadgetCategory> phone = new Product<>("Smartphone", 699.99, GadgetCategory.MOBILE);

        // Displaying Original Products
        System.out.println(book);
        System.out.println(shirt);
        System.out.println(phone);

        // Applying Discounts
        Marketplace.applyDiscount(book, 10); // Apply 10% discount on book
        Marketplace.applyDiscount(shirt, 15); // Apply 15% discount on shirt
        Marketplace.applyDiscount(phone, 5);   // Apply 5% discount on phone
    }
}
