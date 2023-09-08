import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BooksTest {
    
    IBook oms = new PrintBook("Old Man and the Sea", "EH", 10);
    IBook eos = new PrintBook("Elements of Style", "EBW", 20);
    IBook htdp = new PrintBook("HtDP", "MF", 60);
    
    IBook omsAudio = new AudioBook("Old Man and the Sea", "EH", 10, 2);

    IBook omsOnline = new OnlineBook("Old Man and the Sea", "EH", 10, "gutenberg.org");
    IBook htdpOnline = new OnlineBook("HtDP", "MF", 0, "htdp.org");

    /*
    @Test
    void testSalePrice() {
        assertEquals(7,  this.oms.salePrice());
        assertEquals(8,  this.omsAudio.salePrice());
        assertEquals(10, this.omsOnline.salePrice());
        assertEquals(0,  this.htdpOnline.salePrice());
      }
    */
    
}
