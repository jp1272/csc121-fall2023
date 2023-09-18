import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IATTest {

	IAT joe = new Person("Joseph", 1828, new Person("Desiah", 1798),
										  new Unknown());
	IAT abbi = new Person("Abigail", 1839);
	IAT sam = new Person("Samuel", 1863, abbi, joe);
	
	
	@Test
	void test() {
		assertEquals( abbi,  
					new Person("Abigail", 1839, new Unknown(), new Unknown() ));
		
		assertEquals(0 , new Unknown().count());
		assertEquals(1 , abbi.count());
		assertEquals(2 , joe.count());
		assertEquals(4 , sam.count());

	}

}
