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

	  ILoT mt = new MTLoT();
	  ILoT allbooks =
	    new ConsLoT(oms, new ConsLoT(eos, new ConsLoT(htdp, new ConsLoT(ll,
	        new ConsLoT(hobbit, new ConsLoT(twain, new ConsLoT(toc, mt)))))));
	  ILoT ficbooks =
	    new ConsLoT(oms, new ConsLoT(hobbit, new MTLoT()));
	  ILoT nonficbooks = 
	    new ConsLoT(eos, new ConsLoT(ll, new ConsLoT(twain, mt)));
	  ILoT textbooks = 
	    new ConsLoT(htdp, new ConsLoT(toc, mt));
	  ILoT mfbooks =   // written by matthias felleisen
	    new ConsLoT(htdp, new ConsLoT(ll, mt));
	  ILoT over20 =    // sale price $20 or more
	    new ConsLoT(htdp, new ConsLoT(twain, new ConsLoT(toc, mt)));
	  ILoT under20 =   // sale price under $20
	    new ConsLoT(oms, new ConsLoT(eos, new ConsLoT(ll, new ConsLoT(hobbit, mt))));

	  Runner br = new Runner("Bill Rogers", 51, 26, 143);
	  Runner fs = new Runner("Frank Shorter", 48, 26, 153);
	  Runner kk = new Runner("Komo Kenyata", 25, 26, 131);
	  Runner jb = new Runner("Joan Benoit", 51, 26, 165);
	  Runner as = new Runner("Anne Smith", 32, 26, 198);

	  ILoT mtLoT = new MTLoT();
	  ILoT allrunners = 
	    new ConsLoT(br, new ConsLoT(fs, new ConsLoT(kk, new ConsLoT(jb, new ConsLoT(as, mtLoT)))));

	  ILoT names = new ConsLoT("TJ", new ConsLoT("Avery", mt));
	  
	@Test
	void test() {
		assertEquals(21, ficbooks.totalSomething(new PriceProducer() ) );       // ficbooks.totalPrice());
		
		assertEquals(26, new ConsLoR(br, new MTLoR()).totalDist());
	}

}


class PriceProducer  implements ObjectWithANumberProducingMethod {
	public int crunch(Object obj) {
		return ((Book)obj).salePrice();
	}
	
}










