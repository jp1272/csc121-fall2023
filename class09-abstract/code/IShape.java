/** geometric shapes */
interface IShape {

    /** computes the area of this shape */
    public double area();

    /** computes the distance of this shape to the origin */
    public double distTo0();

    /** determines if this shape is larger than that */
    public boolean largerThan(IShape that);
}
