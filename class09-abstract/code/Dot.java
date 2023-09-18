/** a dot shape */
class Dot implements IShape {
  CartPt loc;

  Dot(CartPt loc) {
    this.loc = loc;
  }
  
  // to compute the area of this shape
  public double area() {
    return 0;
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