/**
 * Represents an armadillo in our zoo.
 */
public class Dillo implements IAnimal {
    int length;
    boolean isDead;

    Dillo(int length, boolean isDead) {
        this.length = length;
        this.isDead = isDead;
    }

    /**
     * determines whether this dillo is dead and longer than given person length (inches)
     */
    boolean canShelter(int personLength) {
        return this.isDead && this.length > personLength;
    }

    /**
     * determine whether this animal is within an expected size range appropriate
     * for the species
     */
    public boolean isNormalSize() {
        return 12 <= this.length && this.length <= 24;
    }
}
