public class Library{
    Resource[] arrResource;
    int numLibResources;

    public Library (int numResources){
        this.arrResource = new Resource[numResources];
        numLibResources = 0;
    }
    /**
     * Take a resource and add it to the array of the library's resources.
     * @params: Resource r, an object of type Resource (*Resource class)
     * @return: false if arrSource array is full
     * @return: true if the arrSource array is not full, after add the resource to the array
     */
    // public boolean addResource(Resource r){ 
    //     for (int i = 0; i < arrResource.length; i++){
    //         if (arrResource[i] != null){
    //             arrResource[i]= r;
    //             return true;
    //             // numResources ++;
    //         }
    //     }
    //     return false;
    // }
    
    public boolean addResource(Resource r) {
        // int numLibResources = 0;
        if (numLibResources < arrResource.length) {
            arrResource[numLibResources] = r;
            numLibResources++;
            return true;
        }
        return false;
    }

    /**
     * Get all resources in the library 
     * @return: an array of all the resources in the library (of type Resource)
     */
    public Resource[] getAllResources(){
        return arrResource;
    }

    /**
     * Get the subset of library resources that have no copies available
     * @return: an array containing the subset of library resources that have no copies available.
     */

    public Resource[] getUnavailable(){ 
        int numUnavailable = 0; // QUESTION: why I can set a default number here, but cannot do the same in addResource? (the problem demands told there is just one instance variable for Library class, so how can I fix this?)
        for (int i = 0; i < arrResource.length; i++){
            if (arrResource[i] != null && !arrResource[i].isAvailable()){
                numUnavailable++;
            }
        }
        Resource[] unavailableResource = new Resource[numUnavailable];
        int indexUnavailable = 0;
        for (int i = 0; i < arrResource.length; i++){
            if (arrResource[i] != null && !arrResource[i].isAvailable()){
                unavailableResource[indexUnavailable] = arrResource[i]; // because Library and Resource are of different types so it cannot be that unavailableResource[numLibResources] = arrResource[i]
                indexUnavailable ++;
            }
        }
        return unavailableResource;
    }
    /**
     * Take the name of the borrower (a String) and return all the resources that that person has borrowed
     * @params: String borrower
     * @return: an array of Resource objects that the user has borrowed.
     */
    // This has problem
    public Resource[] getAllUserHasCheckedOut(String borrower){
        int numCheckout = 0;
        for (int i = 0; i < arrResource.length; i++){
            if (arrResource[i] != null && arrResource[i].isBorrowedBy(borrower)){
                numCheckout ++;
            }
        }
        int indexCheckout = 0;
        Resource[] checkoutResources = new Resource[numCheckout];
        for (int i = 0; i < arrResource.length; i++){
            if(arrResource[i] != null && arrResource[i].isBorrowedBy(borrower)){
                checkoutResources[indexCheckout] = arrResource[i];  
                indexCheckout ++;
            }
        }
        return checkoutResources;
    }

    /**
     * Check if the resource is book. If it is, add it to the array of books
     * @params:
     * @return: an array containing the subset of Resource objects that are books
     */
    public Resource[] getAllBooks(){        
        // count the number of book in the arrResource array
        int numBooks = 0;
        for (int i = 0; i < arrResource.length; i++){
            if (arrResource[i] instanceof Book){
                numBooks ++;
            }
        }
        int indexAllBooks = 0;
        // because the allBooks array might not contain up to i index like the arrResource array, 
        // so we must create a separate index for allBooks array, and increment them everytime there is a book counted in the arrResource array.
        Resource[] allBooks = new Resource[numBooks];
        for (int i = 0; i < arrResource.length; i++){
            if (arrResource[i] instanceof Book){
                allBooks[indexAllBooks] = arrResource[i];
                indexAllBooks ++;

            }
        }
        return allBooks;
    }

    /**
     * Check if the resource is CD. If it is, add it to the array of CDs
     * @params:
     * @return: an array containing the subset of Resource objects that are CDs
     */
    public Resource[] getAllCDs(){
        // count the number of CDs in the arrResource array
        int numCDs = 0;
        for (int i = 0; i < arrResource.length; i++){
            if (arrResource[i] instanceof CD){
                numCDs ++;
            }
        }
        int indexCDs = 0; 
        // because the allBooks array might not contain up to i index like the arrResource array, 
        // so we must create a separate index for allBooks array, and increment them everytime there is a book counted in the arrResource array.
        Resource[] allCDs = new Resource[numCDs];
        for (int i = 0; i < arrResource.length; i++){
            if (arrResource[i] instanceof CD){
                allCDs[indexCDs] = arrResource[i];
                indexCDs ++;
            }
        }
        return allCDs;
    }
}

    

