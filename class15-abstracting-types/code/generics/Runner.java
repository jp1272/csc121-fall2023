

/*
+---------------------------+
| Runner                    |
+---------------------------+
| String name               |
| int age                   |
| int dist                  |
| int time                  |
+---------------------------+
| boolean isOver40()        |
| boolean isNamed(String)   |
| int minsPerMile()         |
+---------------------------+  
*/

// represents info about a marathon runner
public class Runner {
  String name;
  int age;
  int dist;   // run distance - miles
  int time;   // best run time - minutes
  
  Runner(String name, int age, int dist, int time) {
    this.name = name;
    this.age = age;
    this.dist = dist;
    this.time = time;
  }
  
  public int getDist() {
	  return this.dist;
  }
  
  // is this runner over 40?
  public boolean isOver40() { return this.age > 40; }
  
  // computes minutes per mile for this runner's best run time
  public int minsPerMile() { return this.time / this.dist; }
  
  // does this runner have the given name?
  public boolean isNamed(String name) {
    return this.name.equals(name);
  }
  
}
