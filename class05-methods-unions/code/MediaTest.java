import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MediaTest {
    
    IMedia i1 = new Image("flower.gif", 57234, 100, 50, "medium");
    IMedia t1 = new Text("welcome.txt", 5312, 830);
    IMedia s1 = new Sound("theme.mp3", 40960, 210);

}
