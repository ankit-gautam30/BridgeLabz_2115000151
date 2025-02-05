import java.util.ArrayList;
import java.util.List;

// Book class
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{Title='" + title + "', Author='" + author + "'}";
    }
}

// Library class
class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        System.out.println("Library: " + name);
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

// Main class to demonstrate aggregation
public class LibrarySystem {
    public static void main(String[] args) {
        // Creating books
        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald");

        // Creating libraries
        Library library1 = new Library("Central Library");
        Library library2 = new Library("Community Library");

        // Adding books to libraries
        library1.addBook(book1);
        library1.addBook(book2);
        
        library2.addBook(book2);
        library2.addBook(book3);

        // Displaying books in each library
        library1.displayBooks();
        System.out.println();
        library2.displayBooks();
    }
}
