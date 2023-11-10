import java.util.Objects;

/** represents an entry in a phone contacts list */
class Person {
    private String name;
    private int number;

    public Person(String name, int number) {
        this.name = name;
        this.number = number;
    }
    
    /**
     * Returns whether this person has the same name as the given string
     */
    public boolean sameName(String n) {
    	return this.name.equals(n);
    }

    
    public String getName()  {
    	return this.name;
    }
    
    /** produces a person with updated number */
    public Person updateNumber(int newNumber) {
        return new Person(this.name, newNumber);
    }
    
    /**
     * Changes the phone number of this person
     */
    public void changeNumber(int newNumber) {
    	this.number = newNumber;
    }

	@Override
	public int hashCode() {
		return Objects.hash(name, number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(name, other.name) && number == other.number;
	}
    
}