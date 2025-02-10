abstract class Product {
	private int productId;
	private String name;
	private double price;

	public Product(int productId, String name, double price) {
		this.productId = productId;
		this.name = name;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public abstract double calculateDiscount();
}
interface Taxable {
	double calculateTax();
	String getTaxDetails();
}

class Electronics extends Product implements Taxable {
	public Electronics(int productId, String name, double price) {
		super(productId, name, price);
	}
	@Override
	public double calculateDiscount() {
		return getPrice() * 0.10;
	}
	@Override
	public double calculateTax() {
		return getPrice() * 0.18;
	}
	@Override
	public String getTaxDetails() {
		return "Electronics Tax: 18%";
	}
}
class Clothing extends Product implements Taxable {
	public Clothing(int productId, String name, double price) {
		super(productId, name, price);
	}
	@Override
	public double calculateDiscount() {
		return getPrice() * 0.20;
	}
	@Override
	public double calculateTax() {
		return getPrice() * 0.12;
	}
	@Override
	public String getTaxDetails() {
		return "Clothing Tax: 12%";
	}
}
class Groceries extends Product implements Taxable {
	public Groceries(int productId, String name, double price) {
		super(productId, name, price);
	}
	@Override
	public double calculateDiscount() {
		return getPrice() * 0.15;
	}
	@Override
	public double calculateTax() {
		return getPrice() * 0.10;
	}
	@Override
	public String getTaxDetails(){
		return "Groceries Tax: 10%";
	}
}
public class Q2_ECommercePlatform {
	public static void main (String[] args) {
	 Product[] products = new Product[3];

	products[0] = new Electronics(1,"Cell Phone",5000);
	products[1] = new Clothing(2,"Jeans",500);
	products[2] = new Groceries(3,"Banana",50);

	for (Product product : products) {
        	double finalPrice = product.getPrice() + (product instanceof Taxable ? ((Taxable) product).calculateTax() : 0) - product.calculateDiscount();
            	System.out.println("Product: " + product.getName() + ", Final Price: " + finalPrice);
            	if (product instanceof Taxable) {
                System.out.println(((Taxable) product).getTaxDetails());
            	}
            	System.out.println("---------------------------");
		}
	}
}
