
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

   /* TEMPLATE
  public ??? posnMethod(...) {
    ... this.x      -- double
    ... this.y      -- double
    
    ... this.inRange(Posn, double, double)  -- boolean
  }    
   */

  // determine whether `this` point is within dx units to the right, 
  //  and dy units below `that` point
  public boolean inRange(Posn that, double dx, double dy) {
      return this.x > that.x && this.y > that.y &&
              this.x < (that.x + dx) && this.y < (that.y + dy);
  }

}


/** represents a geometric shape at some location */
interface IShape {
    /** compute the area of the shape */
    public double area();

    /** is the given point within this shape? */
    public boolean contains(Posn p);
}


/** represents a circle */
class Circle implements IShape {
  Posn center;
  double radius;

  Circle(Posn center, double radius) {
    this.center = center;
    this.radius = radius;
  }

  /* TEMPLATE:
  public ?? circleMethod(...) {
    ... this.center     -- CartPt
    ... this.radius     -- double
    
    ... this.area()     -- double
    ... this.contains(CartPt) -- boolean
    
    ... this.center.cartptMethod(...)  -- ???    
  }    
   */

  /** calculate the area of this circle */
  public double area() {
      return Math.PI * this.radius * this.radius;
  }

  /** Is the given point in this circle */
  public boolean contains(Posn p) {
      return (this.sumSquares(p.x-this.center.x, p.y-this.center.y)
              < 
              (this.radius*this.radius));
      // no need to take the square root -- just compare the sum of the squares and the radius squared
  }

  /** Sum the squares of the two arguments */
  public double sumSquares(double dx, double dy) {
      return (dx*dx+dy*dy);
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

  /* TEMPLATE:
  public ?? squareMethod(...) {
    ... this.nw         -- CartPt
    ... this.size       -- double
    
    ... this.area()     -- double
    ... this.contains(CartPt) -- boolean
    
    ... this.nw.cartptMethod(...)  -- ???    
  }    
   */

  /** calculate the area of this Square */
  public double area() {
      return this.size * this.size;
  }

  /** is the given point within this square */
  public boolean contains(Posn p) {   
      return p.inRange(this.nw, this.size, this.size);
  }

}

