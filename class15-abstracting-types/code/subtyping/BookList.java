

// represents a list of books
interface ILoB {
	// total prices of all books in list
	public int totalPrice();
}

class MTLoB implements ILoB {
	MTLoB() {}

	public int totalPrice() {
		return 0;
	}

}


class ConsLoB implements ILoB {
	Book first;
	ILoB rest;

	ConsLoB(Book first, ILoB rest) {
		this.first = first;
		this.rest = rest;
	}
	
	public int totalPrice() {
		return this.first.salePrice() + this.rest.totalPrice();
	}


}