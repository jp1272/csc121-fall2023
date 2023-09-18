# Homework 8 - Methods for Self-referential Data

Create an Eclipse project named `hw08-self-ref-methods`.

## Project Milestone

Complete Part 2 of [Creative Project - Milestone 1](https://berry.instructure.com/courses/10589/assignments/169154) for Monday.


## Part 1: Methods for Books - due Monday

Start with the code files here representing a list of books in a bookstore:

- [Book, BookTest, and ILoB](./code/)

Add equals/hashCode methods to the `ILoB` hierarchy of classes. Make sure you add them to the `Book` and `Author` classes as well. 

Add the following methods to the `ILoB` hierarchy of classes. There are some test cases already in the BookTest class -- uncomment them as you go.

```
  // computes the total sale price of all books in *this* list
  public int totalPrice();
  
  // sort *this* list of books by sale price
  public ILoB sortByPrice();
  
  // insert a book into this list, sorted by sale price
  public ILoB insertByPrice(Book b);
  
  // select from this list those books written by the given author
  public ILoB selectByAuthor(Author a);
  
  // produce the book with cheapest sale price in this list
  public Book cheapestBook();
  /* in the MTLoB case, raise an error using this statement 
     instead of a return:
         throw new RuntimeException("The list is empty!");
  */
  
  // produce the book with cheapest sale price in this list; given the
  // cheapest book seen so far in the list (accumulator-style method)
  public Book cheapestBookAcc(Book cheapest);
```



## Part 2: Methods for Mobiles - due Wednesday

Download the files for mobiles and add them to your project. Finish designing the four methods that are currently commented out in the `IMobile` interface definition.

> [IMobile, Simple, Complex, IMobileTest](./code/)

- Study the data definitions and examples, then **fill in the templates** for the classes `Simple` and `Complex`.

- Design the method `totalWeight` that computes the total weight of a mobile. Suppose for simplicity that that only thing that contributes to the weight of the mobile are the weights at the end of the simple hanging items. I have already include a set of examples at the bottom of the file; uncomment it and study it to understand how the method should be designed.

- We would like to hang the mobile in a room and want to figure out how far down below the ceiling it will hang. Design the method `height` that computes the height of the mobile. Note that the height of the `complex2` example is 60 (do you understand how that is?).

- Design a function to compute the `torque` on a mobile. Loosely speaking, `torque` is a measure of the turning force on an object. Suppose the torque is given by the formula:

      torque = (total right hand weight * right hand distance) - 
            (total left hand weight * left hand distance )

  Note: Torque is not recursive. If a mobile has a submobile, the torque does not need to know the submobile's torques, just the weight of the whole submobile. Think about the fact that the whole submobile's weight is suspended by a thin string from a single point on the higher mobile, thus the subtorques don't matter because all the weight of the submobile is exerted on one point, so it might as well just be a weight.

- Design a method to determine if a mobile is balanced. Let's say a mobile is balanced if:

  - The mobile's torque is zero.
  - Its left submobile is balanced.
  - Its right submobile is balanced.

  Note that simple weights are always balanced for the purposes of this calculation.



