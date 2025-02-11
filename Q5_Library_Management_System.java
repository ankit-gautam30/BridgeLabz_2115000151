class Book {
    String title, author, genre;
    int bookID;
    boolean available;
    Book next, prev;

    public Book(String title, String author, String genre, int bookID, boolean available) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.available = available;
        this.next = this.prev = null;
    }
}

class Library {
    private Book head, tail;
    private int count;

    public void addAtBeginning(String title, String author, String genre, int bookID, boolean available) {
        Book newBook = new Book(title, author, genre, bookID, available);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        count++;
    }

    public void addAtEnd(String title, String author, String genre, int bookID, boolean available) {
        Book newBook = new Book(title, author, genre, bookID, available);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        count++;
    }

    public void removeBook(int bookID) {
        if (head == null) return;
        if (head.bookID == bookID) {
            head = head.next;
            if (head != null) head.prev = null;
            count--;
            return;
        }
        Book temp = head;
        while (temp != null && temp.bookID != bookID) {
            temp = temp.next;
        }
        if (temp == null) return;
        if (temp.next != null) temp.next.prev = temp.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp == tail) tail = temp.prev;
        count--;
    }

    public void searchByTitle(String title) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.println(temp.bookID + " | " + temp.author + " | " + temp.genre + " | " + (temp.available ? "Available" : "Checked Out"));
                return;
            }
            temp = temp.next;
        }
    }

    public void searchByAuthor(String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                System.out.println(temp.bookID + " | " + temp.title + " | " + temp.genre + " | " + (temp.available ? "Available" : "Checked Out"));
            }
            temp = temp.next;
        }
    }

    public void updateAvailability(int bookID, boolean available) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookID == bookID) {
                temp.available = available;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayBooksForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println(temp.bookID + " | " + temp.title + " | " + temp.author + " | " + temp.genre + " | " + (temp.available ? "Available" : "Checked Out"));
            temp = temp.next;
        }
    }

    public void displayBooksReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println(temp.bookID + " | " + temp.title + " | " + temp.author + " | " + temp.genre + " | " + (temp.available ? "Available" : "Checked Out"));
            temp = temp.prev;
        }
    }

    public void countBooks() {
        System.out.println("Total Books: " + count);
    }
}

public class Q5_Library_Management_System {
    public static void main(String[] args) {
        Library library = new Library();
        library.addAtBeginning("Book A", "Author X", "Fiction", 101, true);
        library.addAtEnd("Book B", "Author Y", "Non-Fiction", 102, false);
        library.displayBooksForward();
        library.countBooks();
        library.displayBooksReverse();
    }
}
