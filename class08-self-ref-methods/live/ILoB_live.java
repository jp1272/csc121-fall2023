
// to represent a list of books

import java.util.Objects;

interface ILoB {
	// public ??? ilobMethod(...);

	// computes the total sale price of all books in *this* list
	public int totalPrice();

	// produce the book with cheapest sale price in this list
	public Book cheapestBook();
	
	/** produce the book with cheapest sale price in this list; given the
	   cheapest book seen so far in the list (accumulator-style method) */
	public Book cheapestBookAcc(Book cheapestSoFar);

}


// an empty list of books
class MTLoB implements ILoB {

	MTLoB() {}

	/* TEMPLATE:
  public ??? ilobMethod(...) {
  }
	 */

	/**  computes the total sale price of all books in *this* empty list */
	public int totalPrice() {
		return 0;
	}
	
	/** produce the book with cheapest sale price in this list */
	public Book cheapestBook() {
		throw new RuntimeException("The list is empty!");
	}

	/** produce the book with cheapest sale price in this list; given the
	   cheapest book seen so far in the list (accumulator-style method) */
	public Book cheapestBookAcc(Book cheapestSoFar) {
		return cheapestSoFar;
	}



	@Override
	public boolean equals(Object other) {
		return other instanceof MTLoB;
	}

	@Override
	public int hashCode() {
		return MTLoB.class.hashCode();
	}

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


	/**  computes the total sale price of all books in *this* list */
	public int totalPrice() {
		return  this.first.salePrice() + this.rest.totalPrice() ;
	}
	
	/** produce the book with cheapest sale price in this list */
	public Book cheapestBook() {
		return this.rest.cheapestBookAcc( this.first );
		/*
		if (this.first.salePrice() < this.rest.cheapestBook().salePrice()) {
			return this.first;
		} else {
			return this.rest.cheapestBook();
		}
		*/
		
	}


	/** produce the book with cheapest sale price in this list; given the
	   cheapest book seen so far in the list (accumulator-style method) */
	public Book cheapestBookAcc(Book cheapestSoFar) {
		if (this.first.salePrice() < cheapestSoFar.salePrice()) {
			return this.rest.cheapestBookAcc( this.first );
		} else {
			return this.rest.cheapestBookAcc( cheapestSoFar );
		}
		
	}






	@Override
	public int hashCode() {
		return Objects.hash(first, rest);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsLoB other = (ConsLoB) obj;
		return Objects.equals(first, other.first) && Objects.equals(rest, other.rest);
	}
}




/* EXERCISES:

 - Compute the total sale price of all books in this list
 - Sort book list by sale price
 - Produce list of books written by a given author
 - Find cheapest book in the list (two ways; from scratch/sorting it first)
   (signaling error in empty list: Util.error(String) -- section 12.2 (page 131)

 */
