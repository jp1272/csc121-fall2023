/** a square shape */
class Square implements IShape {
  CartPt loc;   // top-left corner
  int size;
  
  Square(CartPt loc, int size) {
    this.loc = loc;
    this.size = size;
  }

  // to compute the area of this shape
  public double area() {
    return this.size * this.size;
  }

  // to compute the distance of this shape to the origin
  public double distTo0() {
    return this.loc.distTo0();
  }
  
  // to determine if this shape is larger than that
  public boolean largerThan(IShape that) {
    return this.area() > that.area();
  }
}