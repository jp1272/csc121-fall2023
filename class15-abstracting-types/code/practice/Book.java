/*
  +---------------------------+
  | Book                      |
  +---------------------------+
  | String title              |
  | String author             |
  | int price                 |
  | char kind                 |
  +---------------------------+
  | boolean writtenBy(String) |
  | int salePrice()           |
  | boolean sameAuthor(Book)  |
  +---------------------------+  
 */

//to represent a book in a bookstore
package practice;

import java.util.Objects;

public class Book {
    String title;
    String author;
    int price;
    char kind;

    public Book(String title, String author, int price, char kind){
        this.title = title;
        this.author = author;
        this.price = price;
        this.kind = kind;    
    }

    // was this book written by the given author?
    public boolean writtenBy(String author) {
        return this.author.equals(author);
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
    public int salePrice(){    
        if (this.kind == 'F') {
            return this.price - (3 * this.price / 10);
        } else { if (this.kind == 'N') {
            return this.price - (2 * this.price / 10);
        } else {
            return this.price;
        }}
    }

    // determines if this is a fiction book
    public boolean isFiction() { return this.kind == 'F'; }

    // determines if this is a non-fiction book
    public boolean isNonFiction() { return this.kind == 'N'; }

    // determines if this is a textbook
    public boolean isTextBook() { return this.kind == 'T'; }

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

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", price=" + price + ", kind=" + kind + "]";
    }

}
