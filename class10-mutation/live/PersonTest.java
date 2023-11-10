import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {

	Person brook = new Person("Brook", 1234);
	Person sarah = new Person("Sarah", 5678);
	
	ILoP mt = new MTLoP();
	
	
	ILoP pl1 = new ConsLoP(brook, mt);
	ILoP pl2 = new ConsLoP(sarah, pl1);

	
	ContactsList contacts = new ContactsList();
	
	
	@Test
	public void testUpdatePerson() {
	    assertEquals(new Person("Brook", 3333),   // updated "Brook" object
	                 this.brook.updateNumber(3333));

	    // note that the updateNumber method did NOT affect the original "Brook".
	    assertEquals(false,     // original `brook` still has number 1234
	                this.brook.equals(new Person("Brook", 3333)));
	}
	
	@Test
	public void testChangePerson() {
	  assertEquals(brook, new Person("Brook", 1234));
	  brook.changeNumber(3333);
	  assertEquals(brook, new Person("Brook", 3333));
	}
	
	@Test
	public void testContains() {
		assertFalse(mt.contains("Joe"));
		assertTrue(pl1.contains("Brook"));
		assertTrue(pl2.contains("Brook"));
		assertFalse(pl2.contains("Joe"));
	}
	
	@Test
	public void testChangeLoP() {
		mt.changeNumber("bruh", 2332);
		assertEquals(mt, new MTLoP());
		
		pl1.changeNumber("Joe", 1234);
		assertEquals(pl1, new ConsLoP(brook, mt));
		
		pl2.changeNumber("Brook", 1111);
		assertEquals(pl2, new ConsLoP(sarah, new ConsLoP(new Person("Brook", 1111), mt)));
	}
	
	@Test
	public void testAddPerson() {
		contacts.addPerson("Amy", 1000);
		assertEquals(new ConsLoP( new Person("Amy", 1000), new MTLoP())  , contacts.list);
		
		
		//pl2.addPerson("Joe", 7654);
		//assertEquals(
		//    new ConsLoP(sarah, new ConsLoP(new Person("Joe", 7654), new ConsLoP(brook, mt)))
		//	, pl2);
		
	}
}
