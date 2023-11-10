
import java.util.Objects;

/*********   GENERICS   ***********/


// represents a list of things
interface ILoT<T> {
	// produces a sum of the result of applying F to 
	// every object in this list
	public int totalOf(NumberFunction<T> F);
	
	//abstracts over the onlyFiction and selectOver40 methods
	public ILoT<T> filter(IPredicate<T> F);
}



class MTLoT<T> implements ILoT<T> {
	MTLoT() {}
	
	public int totalOf(NumberFunction<T> F) {
		return 0;
	}

	@Override
	public ILoT<T> filter(IPredicate<T> F) {
		return this;
	}

	// auto-generated methods
    
    @Override
    public boolean equals(Object other) {
        return other instanceof MTLoT;
    }

    @Override
    public int hashCode() {
        return MTLoT.class.hashCode();
    }

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

	//selects only things that are true for the boolean method
	@Override
	public ILoT<T> filter(IPredicate<T> F) {
		if (F.select(this.first)) {
			return new ConsLoT<T>(this.first, this.rest.filter(F));
		} else {
			return this.rest.filter(F);
		}
	}


	@Override
	public int hashCode() {
		return Objects.hash(first, rest);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsLoT other = (ConsLoT) obj;
		return Objects.equals(first, other.first) && Objects.equals(rest, other.rest);
	}
	
}



interface IPredicate<Z> {
	boolean select(Z obj);
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




