package practice;
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

    ILoB mt = new MTLoB();
    ILoB allbooks =
            new ConsLoB(oms, new ConsLoB(eos, new ConsLoB(htdp, new ConsLoB(ll,
                    new ConsLoB(hobbit, new ConsLoB(twain, new ConsLoB(toc, mt)))))));
    ILoB ficbooks =
            new ConsLoB(oms, new ConsLoB(hobbit, new MTLoB()));
    ILoB nonficbooks = 
            new ConsLoB(eos, new ConsLoB(ll, new ConsLoB(twain, mt)));
    ILoB textbooks = 
            new ConsLoB(htdp, new ConsLoB(toc, mt));
    ILoB mfbooks =   // written by matthias felleisen
            new ConsLoB(htdp, new ConsLoB(ll, mt));
    ILoB over20 =    // sale price $20 or more
            new ConsLoB(htdp, new ConsLoB(twain, new ConsLoB(toc, mt)));
    ILoB under20 =   // sale price under $20
            new ConsLoB(oms, new ConsLoB(eos, new ConsLoB(ll, new ConsLoB(hobbit, mt))));

    Runner br = new Runner("Bill Rogers", 51, 26, 143);
    Runner fs = new Runner("Frank Shorter", 48, 26, 153);
    Runner kk = new Runner("Komo Kenyata", 25, 26, 131);
    Runner jb = new Runner("Joan Benoit", 51, 26, 165);
    Runner as = new Runner("Anne Smith", 32, 26, 198);

    ILoR mtLoR = new MTLoR();
    ILoR allrunners = 
            new ConsLoR(br, new ConsLoR(fs, new ConsLoR(kk, new ConsLoR(jb, new ConsLoR(as, mtLoR)))));


    @Test
    void testSelect() {
        assertEquals(ficbooks, allbooks.onlyFiction());
        assertEquals(new ConsLoR(br, new ConsLoR(fs, new ConsLoR(jb, mtLoR))), 
                     allrunners.selectOver40());
        
        assertEquals(under20, allbooks.onlyLessThan(20));
    }


}



