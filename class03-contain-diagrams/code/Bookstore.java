
// Methods for objects with containment

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

/** to represent a book in a bookstore */
class Book {
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
    ... this.title ...          -- String
    ... this.author ...         -- Author
    ... this.price ...          -- int
    ... this.kind ...           -- char

    ... this.writtenBy(String)  -- boolean
    ... this.olderAuthor(Book)  -- boolean  

    ... this.author.authorMethod(...) -- ???
  }
     */  

    /** was this book written by the given author? */
    public boolean writtenBy(String author){
        return this.author.sameName(author);
    } 

    /** was the author of this book born before the author of that book? */
    public boolean olderAuthor(Book that){ 
        return this.author.bornBefore(that.author);
    }
}


/** to represent a book author */
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

    ... this.sameName(String) -- boolean
    ... this.bornBefore(Author) -- boolean
  }  
     */

    /** is this author's name the same as the given name? */
    public boolean sameName(String name){
        return this.name.equals(name);
    }

    /** was this author born before the given author? */
    public boolean bornBefore(Author that){
        return this.yob < that.yob;
    }
}

