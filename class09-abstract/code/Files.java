
// Represents various kinds of files
interface IFile{
    // Compute the size of this file in bytes
    public int size();
}

// Represents a text file
class TextFile implements IFile{
    String name;
    String owner;
    int length;   // in bytes

    TextFile(String name, String owner, int length){
        this.name = name;
        this.owner = owner;
        this.length = length;
    }

    // Compute the size of this TextFile, in bytes
    public int size(){
        return this.length;
    }  
}

//to represent an image file
class ImageFile implements IFile{
    String name;
    String owner;
    int width;   // in pixels
    int height;  // in pixels

    ImageFile(String name, String owner, int width, int height){
        this.name = name;
        this.owner = owner;
        this.width = width;
        this.height = height;
    }

    // Compute the size of this ImageFile, in bytes
    public int size(){
        return this.width * this.height;
    }  
}

//to represent an audio file
class AudioFile implements IFile{
    String name;
    String owner;
    int speed;   // in bytes per second
    int length;  // in seconds of recording time

    AudioFile(String name, String owner, int speed, int length){
        this.name = name;
        this.owner = owner;
        this.speed = speed;
        this.length = length;
    }

    // compute the size of this file
    public int size(){
        return this.speed * this.length;
    }  
}

