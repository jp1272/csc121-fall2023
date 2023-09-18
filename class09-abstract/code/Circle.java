/** a circle shape */
class Circle implements IShape {
  CartPt loc;    // center point
  int rad;       // radius
  
  Circle(CartPt loc, int rad) {
    this.loc = loc;
    this.rad = rad;
  }

  // to compute the area of this shape
  public double area() {
    return Math.PI * this.rad * this.rad;
  }

  // to compute the distance of this shape to the origin
  public double distTo0() {
    return this.loc.distTo0() - this.rad;
    // because points on the outside radius circle are
    //  closer to the origin than the center
  }
  
  // to determine if this shape is larger than that
  public boolean largerThan(IShape that) {
    return this.area() > that.area();
  }
}