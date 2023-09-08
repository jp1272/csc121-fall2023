# Homework 5 - Methods for Unions

Name your project `hw05-methods-unions`.

1. (Exercise 14.6, page 140, *[HtDC](https://felleisen.org/matthias/HtDC/htdc.pdf)*) Recall your data representation of media (images, sounds, texts) for an online gallery from Homework 4. Here is a file with that: [Media.java](code/Media.java) and examples: [MediaTest.java](code/MediaTest.java). 

    Develop the following methods for this program. (Add more examples to develop a thorough set of test cases for each method. Do not just write three `assertEquals` tests -- your work will be marked "incomplete".)

    - `timeToDownload`, which computes how long it takes to download a file at some given network connection speed (in bytes per second);
    - `smallerThan`, which determines whether the file is smaller than some given maximum size;
    - `sameName`, which determines whether the name of a file is the same as some given name (a `String`).

2. (Exercise 12.3) Design an extension for the shapes classes that introduces an isosceles right triangle. Assume the right angle is always in the lower left corner and that the two sides adjacent to the right angle are always parallel to the two axes. The extension should implement all the methods in `IShape`. Here is the shapes code to start with: [Shapes.java](code/Shapes_final.java) and examples: [ShapesTest.java](code/ShapesTest.java).

    Remember your first design step is to develop a data representation for these triangles. Two obvious representation come to mind: one just uses the three points and the other one uses a representation similar to the one for squares in this section. Explore both with examples before you design the rest of the program. Use examples to justify your design choice.

   [This video might be helpful](https://berry.zoom.us/rec/share/scqQ1zMzndbN5DQdC6J3JAYm4aWfmimOhsnR9IU8KfyovKuIMcL_2V6GZPXZVtbp.eXjiBeN0pZhJGl9b).

4. (Exercise 12.4) Design an extension for the shapes class hierarchy from the previous task that enables computing the perimeter of a shape. Provide a method named `perimeter` that has no parameters, and returns a `double`.






---


## Creative Project

(For Monday)

Come up with an idea of a game or interactive simulation that you would like to design and implement. In a simple text file, write out the following. Try to be as thorough as possible, but don't worry if you don't get all the details -- you will probably have to rework your design a few times over as you work on the project.

For the first version of your project that you implement, you'll just have a fixed number of objects interacting with each other and the user. (i.e. no lists of arbitrary lengths of data.)

- On paper, or using a drawing program, draw/sketch one or more pictures representing a particular point of time in your game/simulation. The images in your scene may be basic shapes -- ellipses, circles, rectangles, lines, text -- as well as images from a file -- jpg, gif, png, bmp formats.

- Make a list of all the objects that make up your game/simulation "world" and all the essential information you will need to keep track of as the world changes.

- For each object, describe briefly its behavior in the game: does it change with the clock tick? does in respond to key events? mouse? does it interact with another object in the game?

- Sketch a rough diagram of the classes to represent the objects in the game and list possible examples of data, especially those at the beginning of the game, or in any expected unusual situations during the game.

