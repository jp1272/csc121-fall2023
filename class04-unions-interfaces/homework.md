# Homework 4 - Unions ; Interfaces

Name your project `hw04-unions`.

1. *[How to Design Classes](https://felleisen.org/matthias/HtDC/htdc.pdf)*, Exercise 4.5 (page 35). Use the UMLet plugin in Eclipse to draw a class diagram and export it as a PDF file which you can then upload.

    Put all your interface and class definitions in a single file named `Media.java` and examples in `MediaTest.java`.

2. Exercise 4.7 (page 35). Use the UMLet plugin in Eclipse to draw the diagram and export it as a PDF file which you can then upload.

3. **Lunch Order** <br>
    Design classes to represent a lunch order. The customer can choose a soup (soups have different flavors), a salad (one of several kinds, as well as add one of several choices of dressings), and a sandwich. For the sandwich the customer selects the bread, the filling, and a list of extras (tomatoes, onions, mayo, mustard, olives, etc.) For each of the lunch parts we care whether they are vegetarian. The restaurant charges individually for each selection, but all breads cost the same and all extras cost the same. There is no extra charge for the salad dressing.

    Make examples of at least two of each: soup, salad, dressings, breads, fillings, extras, and at least four examples of lunches, at least one of them a vegetarian choice.

    The class that represents the entire lunch order should be named `Lunch`. Save your work in a file named `Lunch.java`. You can name all the other classes as you wish, but make sure your names are sensible, and the class names start with a capital letter.

    Provide a class diagram in PDF format along with your code implementation.

---


## Creative Project

Over the course of this semester, I will ask you to design and program a graphics-based interactive game or simulation in the style you have done in the first course. A game/application will consist of several different types of objects. The object move either on each tick of the clock, or in response to the keys (typically the arrow keys). There may be other changes in the game object over the time or in response to the key events (`x` key launches a water balloon, an animal gets hungrier as the time goes on, ...). The objects interact in some predefined manner. Finally, something (the state of an object, the interaction between objects) triggers the end of the game.

At this point, I would like you to decide who you want to work with on this project. You may work in groups of 2 or 3 people. Make sure that you pair up with people with whom you can set up mutually agreeable times to meet and work on/discuss the project. Post the names of your group members on the Discord channel under the "Creative Project Groups" thread that I will create there.

In addition, start thinking about a game or simulation or other interactive graphical application that you would like to design and implement. It should involve some interaction and multiple objects. One constraint: your games should not involve any guns or shooting. They may involve things "eating"/running-into/catching-up-with other things, if you have to. But try to be creative. You may run your idea(s) by me at any point. In future weeks I will ask for more formal design specifications/documentation.

