import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        System.out.println("Library Books:");
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " [" + (book.isAvailable() ? "Available" : "Not Available") + "]");
        }
        System.out.println();
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                return book;
            }
        }
        return null;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding sample books to the library
        library.addBook(new Book("Book 1", "Author A"));
        library.addBook(new Book("Book 2", "Author B"));
        library.addBook(new Book("Book 3", "Author C"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Display Books");
            System.out.println("2. Issue a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after nextInt()

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter the title of the book to issue: ");
                    String issueTitle = scanner.nextLine();
                    Book issuedBook = library.findBookByTitle(issueTitle);
                    if (issuedBook != null) {
                        issuedBook.setAvailable(false);
                        System.out.println("Book \"" + issuedBook.getTitle() + "\" issued successfully!");
                    } else {
                        System.out.println("Book not found or already issued.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the title of the book to return: ");
                    String returnTitle = scanner.nextLine();
                    Book returnedBook = library.findBookByTitle(returnTitle);
                    if (returnedBook != null) {
                        returnedBook.setAvailable(true);
                        System.out.println("Book \"" + returnedBook.getTitle() + "\" returned successfully!");
                    } else {
                        System.out.println("Book not found or already returned.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
   }
}
}