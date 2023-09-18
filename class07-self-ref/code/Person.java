/**
 * Represents a known person in an ancestral family tree
 */
public class Person implements IFamTree {
    String name;
    IFamTree mother;
    IFamTree father;

    /*
     * Note two constructors
     *
     * This class illustrates a nice feature of Java when you would like to have
     * default values for some variables in some cases: you can actually define
     * multiple constructors, some of which omit arguments. Constructors that are
     * missing arguments can set default values. More description is on the second
     * constructor below.
     */

    Person(String name, IFamTree mother, IFamTree father) {
        this.name = name;
        this.mother = mother;
        this.father = father;
    }

	// another version of the constructor for people with no known parents.
	// Java allows multiple constructors, as long as they have different
	// arguments or types (so Java can tell which version to use).  Here, we
	// supply only the name, and automatically set the parents to Unknown.
    Person(String name) {
        this.name = name;
        this.mother = new Unknown();
        this.father = new Unknown();
    }

    /*
     * TEMPLATE:
     * public ... mmm() { 
     *    ... this.name 
     *    ... this.mother 
     *    ... this.father
     *    ... this.mother.mmm()
     *    ... this.father.mmm() ... 
     * }
     */

    /** Produce the number of people in this family tree with the given name. */
    public int countName(String checkname) {
        if (this.name.equals(checkname)) {
            return 1 + this.mother.countName(checkname) + this.father.countName(checkname);
        } else {
            return this.mother.countName(checkname) + this.father.countName(checkname);
        }
    }
}
