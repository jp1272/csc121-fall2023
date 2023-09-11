/**
 * Represents a cage that contains an animal.
 */
class Cage {
    int size;
    IAnimal resident;

    Cage(int size, IAnimal resident) {
        this.size = size;
        this.resident = resident;
    }

    /**
     * determines whether this cage had to be specially constructed for an
     * abnormally sized occupant
     */
    boolean isSpecialCageSize() {
        return !this.resident.isNormalSize(); // "NOT" operator
    }

}
