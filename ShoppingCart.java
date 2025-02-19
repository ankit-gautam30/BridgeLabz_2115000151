import java.util.*;

public class ShoppingCart {
    private Map<String, Double> priceMap = new HashMap<>();
    private Map<String, Integer> cart = new LinkedHashMap<>();
    private TreeMap<Double, String> sortedItems = new TreeMap<>();
    
    public void addProduct(String product, double price) {
        priceMap.put(product, price);
    }
    
    public void addToCart(String product) {
        if (priceMap.containsKey(product)) {
            cart.put(product, cart.getOrDefault(product, 0) + 1);
            sortedItems.put(priceMap.get(product), product);
        } else {
            System.out.println("Product not found!");
        }
    }
    
    public Map<String, Integer> getCartItems() {
        return cart;
    }
    
    public Map<Double, String> getSortedItemsByPrice() {
        return sortedItems;
    }
    
    public double getTotalPrice() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            total += priceMap.get(entry.getKey()) * entry.getValue();
        }
        return total;
    }
    
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Apple", 1.5);
        cart.addProduct("Banana", 0.75);
        cart.addProduct("Orange", 1.25);
        
        cart.addToCart("Apple");
        cart.addToCart("Banana");
        cart.addToCart("Apple");
        
        System.out.println("Cart Items: " + cart.getCartItems());
        System.out.println("Sorted Items by Price: " + cart.getSortedItemsByPrice());
        System.out.println("Total Price: " + cart.getTotalPrice());
    }
}
