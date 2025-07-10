package Day5_Inheritance;

public class Book {
    protected String title;
    protected int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

class Author extends Book {
    private String name;
    private String bio;

    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author Name: " + name);
        System.out.println("Bio: " + bio);
    }

    public static void main(String[] args) {
        Author bookWithAuthor = new Author(
            "Effective Java",
            2018,
            "Joshua Bloch",
            "Joshua Bloch is a software engineer and a technology author, formerly employed at Sun Microsystems and Google."
        );
        bookWithAuthor.displayInfo();
    }
}