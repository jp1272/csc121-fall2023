
/*
 * Making a void method in the ILoP classes that adds a person to a list of people runs into a problem when
 * handling the method in the MTLoP class.  Since an empty list doesn't have a first and a rest, you can't 
 * change or mutate these fields, so it is impossible to write the method in this case.
 */


import java.util.Objects;


class ContactsList {
	
	ILoP list;
	
	public ContactsList() {
		this.list = new MTLoP();
	}
	
	
	/** determines if a person with the given name is in this list */
	public boolean contains(String n) {
		return this.list.contains(n);
	}
	
	/** produces a list with the phone number of the given
    person in this list *changed* to the given number */
	public void changeNumber(String name, int newNumber) {
		this.list.changeNumber(name, newNumber);
	}
	
	/** adds a new person to this list */ 
	public void addPerson(String name, int number) {
		this.list = this.list.addPerson(name, number);
	}
	
	
}




/** Represents a list of people in a phone contact list */
interface ILoP {
	/** determines if a person with the given name is in this list */
	public boolean contains(String n);
	
	/** produces a list with the phone number of the given
    person in this list *changed* to the given number */
	public void changeNumber(String name, int newNumber);
	
	/** adds a new person to this list */ 
	public ILoP addPerson(String name, int number);
}

class MTLoP implements ILoP {

	public MTLoP() {
	}

	/** determines if a person with the given name is in this list */
	public boolean contains(String n) {
		return false;
	}
	
	/** produces a list with the phone number of the given
    person in this list *changed* to the given number */
	public void changeNumber(String name, int newNumber) {
		//throw new RuntimeException("Reached the end of the list!");
	}
	
	/** adds a new person to this list */ 
	public ILoP addPerson(String name, int number) {
		///// DOESN'T WORK !! this = new ConsLoP( new Person(name, number), this );
		return new ConsLoP( new Person(name, number), this );
	}

	// auto-generated methods

	@Override
	public boolean equals(Object other) {
		return other instanceof MTLoP;
	}

	@Override
	public int hashCode() {
		return MTLoP.class.hashCode();
	}
}

class ConsLoP implements ILoP {
	Person first;
	ILoP rest;

	public ConsLoP(Person first, ILoP rest) {
		this.first = first;
		this.rest = rest;
	}
	
	/** determines if a person with the given name is in this list */
	public boolean contains(String n) {
		return this.first.sameName(n) || this.rest.contains(n);
	}
	
	/** produces a list with the phone number of the given    (if ....  _____  _____)
    person in this list *changed* to the given number */
	public void changeNumber(String name, int newNumber) {
		//if (this.contains(name)) {
		
			//if (this.first.getName().split().getFirstName().toLowerCase()equals(name)) {                
			if (this.first.sameName(name)) {                
				this.first.changeNumber(newNumber);
			} else {
				this.rest.changeNumber(name, newNumber);
			}
		//} 
	}
	
	
	/** adds a new person to this list */ 
	public ILoP addPerson(String name, int number) {
		//this.rest = 
		//		new ConsLoP( new Person(name, number), this.rest );
		return new ConsLoP( new Person(name, number), this );
	}
	
	

	// auto-generated methods

	@Override
	public int hashCode() {
		return Objects.hash(first, rest);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsLoP other = (ConsLoP) obj;
		return Objects.equals(first, other.first) && Objects.equals(rest, other.rest);
	}

}