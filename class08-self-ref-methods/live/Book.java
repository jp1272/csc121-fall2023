
// Methods for classes with self references (lists)

/*
 +---------------+
 | Book          |
 +---------------+
 | String title  |
 | Author author |--+
 | int price     |  |
 | char kind     |  |
 +---------------+  |
                    v
             +-------------+
             | Author      |
             +-------------+
             | String name |
             | int yob     |
             +-------------+
*/

// to represent a book in a bookstore

import java.util.Objects;

class Book{
  String title;
  Author author;
  int price;
  char kind;
  
  Book(String title, Author author, int price, char kind){
    this.title = title;
    this.author = author;
    this.price = price;
    this.kind = kind;    
  }
  
  /* TEMPLATE:
  public ??? bookMethod(...) {
    FIELDS:
    ... this.title ...          -- String
    ... this.author ...         -- Author
    ... this.price ...          -- int
    ... this.kind ...           -- char
    
    METHODS FOR FIELDS:
    ... this.author.sameName(String) -- boolean
    ... this.author.authorMethod(...) -- ???
    
    METHODS FOR THIS CLASS:
    ... this.writtenBy(Author)  -- boolean
    ... this.salePrice()        -- int
  }
  */  
  
  // was this book written by the given author?
  boolean writtenBy(Author author){
    return this.author.samePerson(author);
  }
  
/*  
 the sale price of the book depends on the daily discounts
 these may differ depending on the kind of book
 suppose today we have the following discounts:
 there is 30% discount on fiction books
 there is 20% discount on nonfiction books
 textbooks sell at full price
*/
  
  // compute the discounted sale price for this book
  int salePrice(){    
    if (this.kind == 'F'){
        return this.price - 3 * (this.price / 10);
    } else {if (this.kind == 'N'){
        return this.price - 2 * (this.price / 10);
    } else {
        return this.price;
    }}
  }

  @Override
  public int hashCode() {
	  return Objects.hash(author, kind, price, title);
  }

  @Override
  public boolean equals(Object obj) {
	  if (this == obj)
		  return true;
	  if (obj == null)
		  return false;
	  if (getClass() != obj.getClass())
		  return false;
	  Book other = (Book) obj;
	  return Objects.equals(author, other.author) && kind == other.kind && price == other.price
			  && Objects.equals(title, other.title);
  }


}


// to represent a book author
class Author{
  String name;
  int yob;
  
  Author(String name, int yob){
    this.name = name;
    this.yob = yob;
  }
  
  /* TEMPLATE:
  public ??? authorMethod(...) {
    ... this.name ...         -- String
    ... this.yob ...          -- int
    
    ... this.samePerson(Author) -- boolean
  }  
  */

  // is this author the same person as that one, based on name
  boolean samePerson(Author that){
    return this.name.equals(that.name);
  }

  @Override
  public int hashCode() {
	  return Objects.hash(name, yob);
  }

  @Override
  public boolean equals(Object obj) {
	  if (this == obj)
		  return true;
	  if (obj == null)
		  return false;
	  if (getClass() != obj.getClass())
		  return false;
	  Author other = (Author) obj;
	  return Objects.equals(name, other.name) && yob == other.yob;
  }


}

