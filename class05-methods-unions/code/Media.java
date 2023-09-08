

/** represents media in an online gallery */
interface IMedia {}

/** represents an image in the online gallery */
class Image implements IMedia {
  String source;  // source file name
  int size;       // size of file in bytes
  int height;     // in pixels
  int width;      // in pixels
  String quality;  // low, medium, etc.
  
  Image(String source, int size, int height, int width, String quality) {
    this.source = source;
    this.size = size;
    this.height = height;
    this.width = width;
    this.quality = quality;
  }
}

/** represents text content in the online gallery */
class Text implements IMedia {
  String source;  // source file name
  int size;       // size of file in bytes
  int lines;      // number of lines needed for visual representation
  
  Text(String source, int size, int lines) {
    this.source = source;
    this.size = size;
    this.lines = lines;
  }
}

/** represents audio content in the online gallery */
class Sound implements IMedia {
  String source;  // source file name
  int size;       // size of file in bytes
  int time;       // playing time in seconds
  
  Sound(String source, int size, int time) {
    this.source = source;
    this.size = size;
    this.time = time;
  }
}
