

/** to represent a part of support structure for a mobile */
class Complex implements IMobile {
  int length;
  int leftSide;
  int rightSide;
  IMobile left;
  IMobile right;

  Complex(int length, int leftSide, int rightSide, 
          IMobile left, IMobile right) {
    this.length = length;
    this.leftSide = leftSide;
    this.rightSide = rightSide;
    this.left = left;
    this.right = right;
  }

  /* TEMPLATE:
  public ??? imobileMethod(...) {
    ...
  }
  */

}
