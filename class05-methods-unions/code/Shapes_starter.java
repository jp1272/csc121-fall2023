
// shapes - methods

/*
 RECALL RACKET *SL:
 
  ;; A Shape is one of:
  ;;   -- circle, (make-circle posn number)
  ;;   -- square, (make-square posn number)
  
  (define-struct circle (center radius))
  (define-struct square (nw size))
  
  ;; shape-func : Shape ??? -> ???
  (define (shape-func a-shape ...) 
    (cond [(circle? a-shape)  ... (circle-center a-shape)
                              ... (circle-radius a-shape) ...]
          [(square? a-shape)  ... (square-nw a-shape) 
                              ... (square-size a-shape) ...]))
   
*/


/*

                             +----------+
                             |  IShape  |
                             +----------+
                                  |
                                 / \
                                +---+
                                  |
                      +-----------+-----------+
                      |                       |
                      |                       |
   +------------------+---------+      +------+---------------------+
   |          Square            |      |          Circle            |
   +----------------------------+      +----------------------------+
   | CartPt nw                  |      | CartPt center              |
   | double size                |      | double radius              |
   +----------------------------+      +----------------------------+


   +------------------------+
   |        :               |
   |        :100  B         |
   |        :               |
   |   200  +-------+       |
   |~~~~~~~~|       |       |
   |        |   E   |50  C  |
   |    A   |       |       |
   |        +-------+       |
   |                        |
   |            D           |
   +------------------------+
   
  */


/** Represents a 2D cartesian coordinate */
//  - Needed for the shapes defined below
class Posn {
  double x;
  double y;
  
  Posn(double x, double y) {
    this.x = x;
    this.y = y;
  }
       
}


/** represents a geometric shape at some location */
interface IShape {}


/** represents a circle */
class Circle implements IShape {
  Posn center;
  double radius;

  Circle(Posn center, double radius) {
    this.center = center;
    this.radius = radius;
  }

}


/** represents a square */
class Square implements IShape {
  Posn nw;
  double size;
  
  Square(Posn nw, double size) {
    this.nw = nw;
    this.size = size;
  }

}

