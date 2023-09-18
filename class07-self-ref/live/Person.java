import java.util.Objects;

public class Person implements IAT {
	String name;
	int yob;  // year of birth
	IAT mother;
	IAT father;
	
	/*
	  template:
	  
	  ??? method() {
	       .... this.name
	            this.yob
	            this.mother
	            this.father
	           
	            this.mother.method() ...
	            this.father.method() ...
	   }
	 */
	
	/* OVERLOADED CONSTRUCTOR
	 * Overloading === defining multiple versions of a constructor with
	 * 						different numbers or types of parameters 
	 */
	public Person(String name, int yob) {
		this(name, yob, new Unknown(), new Unknown());
		/*
		this.name = name;
		this.yob = yob;
		this.mother = new Unknown();
		this.father = new Unknown();
		*/
	}
	
	public Person(String name, int yob, IAT mother, IAT father) {
		this.name = name;
		this.yob = yob;
		this.mother = mother;
		this.father = father;
	}


	/** count the number of known people in this Person's family tree */
	public int count() {
		return 1 + this.mother.count() + this.father.count();
        
		/*
			{
	       ....
	            this.mother
	            this.father
	           
	            ..
	   }
		 */
	}

	
	
	
	
	

	@Override
	public int hashCode() {
		return Objects.hash(father, mother, name, yob);
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
		return Objects.equals(father, other.father) && Objects.equals(mother, other.mother)
				&& Objects.equals(name, other.name) && yob == other.yob;
	}


}
