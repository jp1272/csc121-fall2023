import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ListTests {
	  Book oms = new Book("Old Man and the Sea", "EH", 10, 'F');
	  Book eos = new Book("Elements of Style", "EBW", 20, 'N');
	  Book htdp = new Book("HtDP", "MF", 60, 'T');
	  Book ll = new Book("LL", "MF", 20, 'N');
	  Book hobbit = new Book("The Hobbit", "JRRT", 20, 'F');
	  Book twain = new Book("Autobiography", "MT", 35, 'N');
	  Book toc = new Book("Theory of Computation", "MS", 120, 'T');

	  ILoT<Book> mt = new MTLoT<Book>();
	  
	  ILoT<Book> allbooks =
	    new ConsLoT<Book>(oms, new ConsLoT<Book>(eos, new ConsLoT<Book>(htdp, new ConsLoT<Book>(ll,
	        new ConsLoT<Book>(hobbit, new ConsLoT<Book>(twain, new ConsLoT<Book>(toc, mt)))))));
	  ILoT<Book> ficbooks =
	    new ConsLoT<Book>(oms, new ConsLoT<Book>(hobbit, new MTLoT<Book>()));
	  ILoT<Book> nonficbooks = 
	    new ConsLoT<Book>(eos, new ConsLoT<Book>(ll, new ConsLoT<Book>(twain, mt)));
	  ILoT<Book> textbooks = 
	    new ConsLoT<Book>(htdp, new ConsLoT<Book>(toc, mt));
	  ILoT<Book> mfbooks =   // written by matthias felleisen
	    new ConsLoT<Book>(htdp, new ConsLoT<Book>(ll, mt));
	  ILoT<Book> over20 =    // sale price $20 or more
	    new ConsLoT<Book>(htdp, new ConsLoT<Book>(twain, new ConsLoT<Book>(toc, mt)));
	  ILoT<Book> under20 =   // sale price under $20
	    new ConsLoT<Book>(oms, new ConsLoT<Book>(eos, new ConsLoT<Book>(ll, new ConsLoT<Book>(hobbit, mt))));

	  Runner br = new Runner("Bill Rogers", 51, 26, 143);
	  Runner fs = new Runner("Frank Shorter", 48, 26, 153);
	  Runner kk = new Runner("Komo Kenyata", 25, 26, 131);
	  Runner jb = new Runner("Joan Benoit", 51, 26, 165);
	  Runner as = new Runner("Anne Smith", 32, 26, 198);
	  
	  ILoT<Object> weird = new ConsLoT<Object>(br, new ConsLoT<Object>(eos, new MTLoT<Object>()));

	  ILoT<Runner> mtLoT = new MTLoT<Runner>();
	  ILoT<Runner> allrunners = 
	    new ConsLoT<Runner>(br, new ConsLoT<Runner>(fs, new ConsLoT<Runner>(kk, new ConsLoT<Runner>(jb, new ConsLoT<Runner>(as, mtLoT)))));

	  ILoT<String> names = new ConsLoT<String>("TJ", new ConsLoT<String>("Avery", new MTLoT<String>()));
	  
	@Test
	void test() {
		
		assertEquals(21, ficbooks.totalOf(new PriceProducer()));       // ficbooks.totalPrice());
		//assertEquals( 130, allrunners.totalOf(  ????  ));
		//assertEquals( 7, names.totalOf( ????  ));  // total length of all strings
	}

}



class PriceProducer implements NumberFunction<Book> {
	public int apply(Book obj) {    // defined
		return obj.salePrice();
	}
}







