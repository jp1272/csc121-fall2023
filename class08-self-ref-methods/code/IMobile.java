
/*
               +---------+                  
               | IMobile |<---------------+
               +---------+                |
               +---------+                |
                   |                      |
                  / \                     |
                  ---                     |
                   |                      |
         ---------------------            |
         |                   |            |
  +--------------+   +---------------+    |
  | Simple       |   | Complex       |    |
  +--------------+   +---------------+    |
  | int length   |   | int length    |    |
  | int weight   |   | int leftside  |    |
  | Color color  |   | int rightside |    |
  +--------------+   | IMobile left  |----+ 
                     | IMobile right |----+  
                     +---------------+ 
*/

/** to represent a mobile */
interface IMobile {
  // TEMPLATE: public ??? imobileMethod(...);
  
  /** compute the total weight of this mobile */
  // public int totalWeight();
  
  /** compute the total height of this mobile */
  // public int height();
  
  /*
  Design a function to compute the torque on a mobile. Loosely speaking, 
  torque is a measure of the turning force on an object. Suppose the torque
  is given by the formula:
  
  torque = (total right hand weight * right hand distance) - 
           (total left hand weight * left hand distance )
           
  Note: Torque is not recursive. If a mobile has a submobile, the torque
  does not need to know the submobile's torques, just the weight of the 
  whole submobile. Think about the fact that the whole submobile's weight 
  is suspended by a thin string from a single point on the higher mobile,
  thus the subtorques don't matter because all the weight of the submobile
  is exerted on one point, so it might as well just be a weight.
  */
  
  /** compute the "torque" on this mobile structure */
  // public int torque();
  
  /*
  A mobile is balanced if:

    - The mobile's torque is zero.
    - Its left submobile is balanced.
    - Its right submobile is balanced.
    
  Note that simple weights are always balanced for the purposes of this 
  calculation.
  */
  
  /** is this mobile is balanced? */
  // public boolean isBalanced();

}
