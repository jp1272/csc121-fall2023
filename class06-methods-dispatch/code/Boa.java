/**
 * Represents a boa constrictor in our zoo.
 */
public class Boa implements IAnimal {
    String name;
    int length;
    String food;

    public Boa(String name, int length, String food) {
        this.name = name;
        this.length = length;
        this.food = food;
    }

    /**
     * determine whether this animal is within an expected size range appropriate
     * for the species
     */
    public boolean isNormalSize() {
        return 30 <= this.length && this.length <= 60;
    }

    /** determines whether this boa likes the same food as the given boa */
    boolean likesSameFood(Boa aBoa) {
        return this.food.equals(aBoa.food);
    }

}
