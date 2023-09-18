
// to represent a list of books
interface ILoB {
  // public ??? ilobMethod(...);
}


// an empty list of books
class MTLoB implements ILoB {

  MTLoB() {}

  /* TEMPLATE:
  public ??? ilobMethod(...) {
  }
  */
}


// to represent a book added to a list of books
class ConsLoB implements ILoB {
  Book first;
  ILoB rest;

  ConsLoB(Book first, ILoB rest) {
    this.first = first;
    this.rest = rest;
  }

  /* TEMPLATE:
  public ??? ilobMethod(...) {
    ... this.first ...     -- Book
    ... this.rest ...     -- ILoB
 
    ... this.first.bookMethod(...) -- ???
    ... this.rest.ilobMethod(...) -- ???
  }
  */
}




/* EXERCISES:
 
 - Compute the total sale price of all books in this list
 - Sort book list by sale price
 - Produce list of books written by a given author
 - Find cheapest book in the list (two ways; from scratch/sorting it first)
   (signaling error in empty list: Util.error(String) -- section 12.2 (page 131)
   
*/
