class BookLibrary {
    String title;
    String author;
    double price;
    boolean isAvailable;

    public BookLibrary(String title, String author, double price, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public boolean borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("The book '" + title + "' has been borrowed.");
            return true;
        } else {
            System.out.println("Sorry, the book '" + title + "' is not available.");
            return false;
        }
    }

    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }

    public static void main(String[] args) {
        BookLibrary book1 = new BookLibrary("Java Programming", "John Doe", 29.99, true);
        book1.display();
        System.out.println();
        book1.borrowBook();
        System.out.println();
        book1.display();
    }
}
