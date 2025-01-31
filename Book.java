class Book{
	private String title;
	private String author;
	private double price;

	public Book(String title, String author, double price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	public void displayDetails() {
		System.out.println("Enter Book Details:");
		System.out.println("Enter Title of Book:" + title);
		System.out.println("Enter Author of Book:" + author);
		System.out.println("Enter price of Book:" + price);
	}
public static void main(String[] args) {
	Book book = new Book("Gaban", "Premchand", 199.99);
		book.displayDetails();
	}
}
