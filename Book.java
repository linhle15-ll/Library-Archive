// child class
// Books have Author

public class Book extends Resource{
    String author;
    int numPages;
    public Book(String title, String publisher, int year, boolean electronic, int numCopies, String author, int numPages){
        super(title, publisher, year, electronic, numCopies);
        this.author = author;
        this.numPages = numPages;
    
    }
    public String toString () {
        return author + ", " + title + ", " + year + ", " + numPages;
    }

}