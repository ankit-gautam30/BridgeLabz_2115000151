// Movie Management System using Doubly Linked List

class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    // Constructor to initialize a movie node
    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieList {
    private Movie head;
    private Movie tail;

    // Add a movie at the beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add a movie at the end
    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add a movie at a specific position
    public void addAtPosition(String title, String director, int year, double rating, int position) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }
        if (position == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        Movie newMovie = new Movie(title, director, year, rating);
        Movie temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
            return;
        }
        newMovie.next = temp.next;
        newMovie.prev = temp;
        temp.next.prev = newMovie;
        temp.next = newMovie;
    }

    // Remove a movie by title
    public void removeMovie(String title) {
        Movie temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Movie not found!");
            return;
        }
        if (temp == head) {
            head = temp.next;
            if (head != null) head.prev = null;
        } else if (temp == tail) {
            tail = temp.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    // Search for movies by director
    public void searchByDirector(String director) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                System.out.println("Found: " + temp.title + " (" + temp.year + ") Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found by " + director);
    }

    // Search for movies by rating
    public void searchByRating(double rating) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println("Found: " + temp.title + " (" + temp.year + ") Directed by: " + temp.director);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found with rating " + rating);
    }

    // Update a movie's rating by title
    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated successfully for " + title);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found!");
    }

    // Display movies in forward order
    public void displayForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    // Display movies in reverse order
    public void displayReverse() {
        Movie temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | Rating: " + temp.rating);
            temp = temp.prev;
        }
    }
}

public class Q2_Movie_Management_System {
    public static void main(String[] args) {
        MovieList movieList = new MovieList();
        
        // Adding movies
        movieList.addAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        movieList.addAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        movieList.addAtPosition("The Dark Knight", "Christopher Nolan", 2008, 9.0, 2);
        
        // Display movies
        System.out.println("Movies in Forward Order:");
        movieList.displayForward();
        
        System.out.println("Movies in Reverse Order:");
        movieList.displayReverse();
        
        // Search and update
        movieList.searchByDirector("Christopher Nolan");
        movieList.updateRating("Inception", 9.0);
        
        // Remove a movie
        movieList.removeMovie("Interstellar");
        
        // Display updated list
        System.out.println("Updated Movies:");
        movieList.displayForward();
    }
}
