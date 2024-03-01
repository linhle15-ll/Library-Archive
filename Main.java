public class Main {
    
    private static void printResources(Resource[] res) {
        for (int i = 0; i < res.length; i++) {
            System.out.println (res[i]);
        }
    }

    public static void main(String[] args) {
        Library l = new Library (6);
        Book b1 = new Book ("The Fifth Season", "Orbit", 2015, false, 1,
                "N.K. Jemisin", 378);
       
        CD cd1 = new CD ("Wrong Places", "RCA Records", 2020, 1, "H.E.R.", 38);
        Book b2 = new Book("On Earth We're Briefly Gorgeous", "Penguin Press", 2019,
                false, 3, "Ocean Vuong", 256);
        Book b3 = new Book("Small Gods", "Harper Collins", 1992, true, 5, 
                "Terry Pratchett", 400);
        CD cd2 = new CD("Harry's House", "Real World", 2022, 2, "Harry Styles", 42);
        CD cd3 = new CD("Renaissance", "Parkwood Entertainment", 2022, 4, "Beyonce", 
                62);

        l.addResource(b1);
        l.addResource(cd1);
        l.addResource(b2);
        l.addResource(b3);
        l.addResource(cd2);
        l.addResource(cd3);

        System.out.println ("*** All resources ***");
        printResources(l.getAllResources());
        
        b1.checkOut("Barbara");
        b3.checkOut("Barbara");
        cd3.checkOut("Dovan");

        System.out.println ("\n*** All unavailable ***");
        printResources(l.getUnavailable());

        System.out.println ("\n*** All checked out by Barbara ***");
        printResources(l.getAllUserHasCheckedOut("Barbara"));
        
        System.out.println ("\n*** All books ***");
        printResources(l.getAllBooks());
        
        System.out.println ("\n*** All CDs ***");
        printResources(l.getAllCDs());
    }
}
