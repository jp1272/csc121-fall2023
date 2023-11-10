

// represents a list of things
interface ILoT {
	public int totalSomething(ObjectWithANumberProducingMethod F);
}

class MTLoT implements ILoT {
	MTLoT() {}

	public int totalSomething(ObjectWithANumberProducingMethod F) {
		return 0;
	}
}

interface ObjectWithANumberProducingMethod {
	int crunch(Object o);
}

class ConsLoT implements ILoT {
	Object first;
	ILoT rest;

	public ConsLoT(Object first, ILoT rest) {
		this.first = first;
		this.rest = rest;
	}

	//  totalSomething : Listof-Object  (Object -> Number)    ->  number
	
	
	public int totalSomething(ObjectWithANumberProducingMethod F) {
		return F.crunch(this.first) + this.rest.totalSomething(F);
	}
}
