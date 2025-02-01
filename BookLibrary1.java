class Book {
    public String ISBN;
    protected String title;
    private String author;

    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class EBook extends Book {
    public EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    public void displayDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + getAuthor());
    }
}

public class BookLibrary1 {
    public static void main(String[] args) {
        EBook eBook = new EBook("978-1234567890", "Java Programming", "John Smith");
        eBook.displayDetails();
        eBook.setAuthor("Jane Doe");
        System.out.println("Updated Author: " + eBook.getAuthor());
    }
}
