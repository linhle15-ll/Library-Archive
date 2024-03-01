class Resource {
// abstrace class Resource
    String title;
    String publisher;
    int year;
    boolean electronic;
    int numCopies;
    String[] borrowers;
    
    public Resource (String title, String publisher, int year, boolean electronic, int numCopies)
    {
        this.title = title;
        this.publisher = publisher;
        this.year = year;
        this.electronic = electronic;
        this.numCopies = numCopies;
        this.borrowers = new String[numCopies]; 
        // let the number of elements in borrowers array to be equal to numCopies. We do not care about printing out null or not, just to iterate the loop later.
    }

    /**
     * Get the title of a resource
     * @return title
     */
    public String getTitle(){
        return title;
    }

    /**
     * Get the publisher of a resource
     * @return publisher
     */
    public String getPublisher(){
        return publisher;
    }

    /**
     * Return all the borrowers of particular resources
     * @return an array of String types containing all the borrowers
     */
    public String[] getBorrowers(){
        return borrowers;
    }

    /**
     * check if a resource is electric or not
     * @return boolean values: if the book if electronic, 
     * @return false; otherwise return false if the resource is not electric (CDs are always not electric)
     */
    public boolean isElectronic(){
        return electronic;
    }

    /**
     * check if the particular resource is still available or not
     * @return true if there are still copies for the resource, otherwise return false
     */
    public boolean isAvailable(){
        if (this.numCopies > 0){
            return true;
        }
        return false;
    }
    /**
     * Check if the book is borrowed by a particular person
     * Run in the borrowers array, find the borrower at an index that is the same as the person 
     * @param name of the borrower
     * @return true if the person match the borrower
     * @return false if after iterating through the borrowers array, no borrower matches the person
     */
    public boolean isBorrowedBy(String person){
        String[] borrowers = getBorrowers();
        for (int i = 0; i < borrowers.length; i++){
            if (borrowers[i] != null && borrowers[i].equals(person)){
                return true;
            } 
        }          
        return false;   
    }
    /**
     * @return a string containing the title and year separated by a commma (example: Data Structures, 2021)
     */

    public String toString(){
        return title + ", " + year;
    }

    /**
     * Method to check out a resource
     * @param i: the name of the borrower
     * @return false if the item is not available or no name was provided for the borrower,
     * otherwise update the appropriate information and return true.
     */
    public boolean checkOut(String borrower){
        if (isAvailable()){
            if (borrower != null && !borrower.equals("")){
                numCopies --;
                for (int i = 0; i < borrowers.length; i++){
                    if (borrowers[i] == null){
                        borrowers[i] = borrower;
                
                    }
                }
                return true;
            }
        }
        return false;
    }

    /**
     * class checkIn to check in a resource
     * check in a resource requires as an argument a string of the borrower who is checking in the resource
     * @param i: the name of the borrower
     * @return false if the borrower passed an argument that does not have the resource checked out
     * @return true other wise after update the appropriate information
     */
    public boolean checkIn(String borrower){
        if (!checkOut(borrower)){
            return false;
        }
        else{
            numCopies ++;
            for (int i = 0; i < borrowers.length; i++){
                if (borrowers[i] == borrower){
                    borrowers[i] = null;
                    
                }
            }
            return true;
        }
    }

    // public void testCode(){
    //     //Resource a = new Resource("The Fifth Season", "Orbit", 2015, false, 1);
    //     System.out.println(borrowers);

    // }
    // public static void main(String[] args){
    //     Resource a = new Resource("The Fifth Season", "Orbit", 2015, false, 1);
    //     a.testCode();
    // }

}

