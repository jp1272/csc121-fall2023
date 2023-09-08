/* *******
 * CONTEXT:
 the sale price of the book depends on the daily discounts
 these may differ depending on the kind of book
 suppose today we have the following discounts:
     - there is 30% discount on print books
     - there is 20% discount on audio books
     - online books sell at full price
*/

/*
                      +-------+
                      | IBook |
                      +-------+
                         / \
                         ---
                          |
         -------------------------------------------
         |                    |                    |
 +---------------+    +---------------+    +---------------+
 | PrintBook     |    | AudioBook     |    | OnlineBook    |
 +---------------+    +---------------+    +---------------+
 | String title  |    | String title  |    | String title  |
 | String author |    | String author |    | String author |
 | int price     |    | int price     |    | int price     |
 +---------------+    | int noCDs     |    | String url    |
                      +---------------+    +---------------+
                      
                      
*/

/**
 * Represents various books in a bookstore.
 */
interface IBook {
    /** compute the discounted sale price for this book */
    public int salePrice();
}



/** Represents a printed book in a bookstore */
class PrintBook implements IBook {
  String title;
  String author;
  int price;
  
  PrintBook(String title, String author, int price) {
    this.title = title;
    this.author = author;
    this.price = price;  
  }
  
  /* TEMPLATE:
  public ??? printBookMethod(...) {
    ... this.title ...       -- String
    ... this.author ...      -- String
    ... this.price ...       -- int
  
    ... this.salePrice() ... -- int
  }
  */  
  
  /** compute the discounted sale price for this book */
  public int salePrice() {
    return this.price - (this.price * 3 / 10);
  }
  
}



/** Represents an audio book in a bookstore */
class AudioBook implements IBook {
  String title;
  String author;
  int price;
  int noCDs;
  
  AudioBook(String title, String author, int price, int noCDs) {
    this.title = title;
    this.author = author;
    this.price = price;
    this.noCDs = noCDs;    
  }

  /* TEMPLATE:
  public ??? audioBookMethod(...) {
    ... this.title ...       -- String
    ... this.author ...      -- String
    ... this.price ...       -- int
    ... this.noCDs ...       -- int
  
    ... this.salePrice() ... -- int
  }
  */  
  
  /** compute the discounted sale price for this book */
  public int salePrice() {
      return this.price - 2 * (this.price / 10);
    }  
  
}



/** Represents an online book in a bookstore */
class OnlineBook implements IBook {
  String title;
  String author;
  int price;
  String url;
  
  OnlineBook(String title, String author, int price, String url) {
    this.title = title;
    this.author = author;
    this.price = price;
    this.url = url;    
  }
  
  /* TEMPLATE:
  public ??? onlinetBookMethod(...) {
    ... this.title ...       -- String
    ... this.author ...      -- String
    ... this.price ...       -- int
    ... this.url ...         -- int
  
    ... this.salePrice() ... -- int
  }
  */  

  /** compute the discounted sale price for this book */
  public int salePrice(){
      return this.price;
    }

}
