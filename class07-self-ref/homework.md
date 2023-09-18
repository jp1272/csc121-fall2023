# Homework 7 - Self-referential data; Overloading constructors

Create an Eclipse project named `hw07-self-ref`.

## Project Milestone

Complete Part 1 of [Creative Project - Milestone 1](https://berry.instructure.com/courses/10589/assignments/169154) by Friday and start working on Part 2.


## Part 1: Mobiles

Define classes for the **Mobiles** example given in the [lecture slides](./slides.md#example-mobiles). (Follow the given class diagram.)

Create examples of data of mobiles including some for the following two:

```
  
  Simple mobile      |
                     |
                     10
                    blue
  

  Complex mobile         |
                         |
                         |
             ------------+-----
             |                |
       ------+------          |
       |           |          | 
       10          |          40    
      red          10        green
                  blue
```



## Part 2: Phone Tree

([Exercise 5.9, page 50 in *HtDC*](https://felleisen.org/matthias/HtDC/htdc.pdf#page=62))

Soccer leagues arrange its soccer teams into phone trees so that they can quickly inform all parents about rain-outs. The league calls the coach, who in turn calls the parents of the team captain. Each parent then calls at most two other parents.

The class diagram in [figure 28](https://felleisen.org/matthias/HtDC/htdc.pdf#page=62) contains the data definition for a program that manages phone trees. Given these classes, one could create the data in [figure 29](https://felleisen.org/matthias/HtDC/htdc.pdf#page=63). Draw the phone tree there as a circle-and-arrow diagram. Each circle corresponds to a player or coach. An arrow means that a player calls some other player; it goes from the caller to the callee. Then develop the class definitions that correspond to the given data definition.

