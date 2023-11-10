import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookTest {
	
	Author knuth = new Author("Donald Knuth", 1938, null);
	Author tolkein = new Author("JRR Tolkein", 1930, null);

    Book taocp = new Book("The Art of Computer Programming (volume 1)", 100, 2,
            					this.knuth);
    
    Author bogus;

	@Test
	void test() {
		bogus = taocp.getAuthor();
		bogus = tolkein;
		
		
		//    *change*
		
		//tolkein.book = taocp;
		//tolkein.setBook(taocp);
		
		//this.knuth.book = this.taocp;
		
		assertEquals(  taocp ,  taocp.getAuthor().getBook() );
	}

}
