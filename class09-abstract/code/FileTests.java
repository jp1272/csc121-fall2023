import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FileTests {

    IFile text = new TextFile("Files.java", "nah", 2048);
    IFile img = new ImageFile("photo.jpg", "tapia", 640, 480);
    IFile aud = new AudioFile("watcha_want.mp3", "mcdowell", 44, 120000);

    @Test
    // Test the size method
    public void testSize() {
        assertEquals(2048, this.text.size());
        assertEquals(307200, this.img.size());
        assertEquals(5280000, this.aud.size());
    }
}
