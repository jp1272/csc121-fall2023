/** a 2d (cartesian) point */

class CartPt {
    int x;
    int y;

    CartPt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /** computes the distance of this point to the origin */
    public double distTo0() {
        return Math.sqrt((this.x * this.x) + (this.y * this.y));
    }
}
