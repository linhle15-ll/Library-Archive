public class CD extends Resource{
    String artist;
    int length;

    public CD (String title, String publisher, int year, int numCopies, String artist, int length){
        super(title, publisher, year, false, numCopies);
        this.artist = artist;
        this.length = length;
    }

    public String toString(){
        return artist + ", " + title + ", " + year + ", " + length;
    }

}