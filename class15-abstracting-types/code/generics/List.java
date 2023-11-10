

/*********   GENERICS   ***********/


// represents a list of things
interface ILoT<T> {
	// produces a sum of the result of applying F to 
	// every object in this list
	public int totalOf(NumberFunction<T> F);
}

class MTLoT<T> implements ILoT<T> {
	MTLoT() {}
	
	public int totalOf(NumberFunction<T> F) {
		return 0;
	}

	/*
	public int totalSomething(ObjectWithANumberProducingMethod F) {
		return 0;
	}
	*/
}

class ConsLoT<T> implements ILoT<T> {
	T first;
	ILoT<T> rest;

	public ConsLoT(T first, ILoT<T> rest) {
		this.first = first;
		this.rest = rest;
	}

	
	public int totalOf(NumberFunction<T> F) {
				// used
		return F.apply(this.first) + this.rest.totalOf(F);
	}
}

interface NumberFunction<Z> {
	int apply(Z obj);			// declared
}







/*
 
 A <T>-parameterized
    [Listof T] is either:         // parametric polymorphism
   - empty or
   - (cons  T   [Listof T])
   
   
totalPrice : [Listof Book]   -> Number
   
   
 
 
 
 A List-of-Things is either:
    - empty or
    - (cons  Any   List-of-Thing)
 
 
 (cons 5 (cons "hi" (cons (make-posn 6 7) empty))))
 
 
 */


