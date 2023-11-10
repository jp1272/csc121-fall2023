// represents a list of books
package practice;

import java.util.Objects;

interface ILoB {
	// total prices of all books in list
	public int totalPrice();
	
    // selects only the books in this list that are fiction
    public ILoB onlyFiction();
    
    // selects only the books whose sale price is less than the given price
    public ILoB onlyLessThan(int price);

}

class MTLoB implements ILoB {
	MTLoB() {}

	public int totalPrice() {
		return 0;
	}

    public ILoB onlyFiction() {
        return this;
    }
    
    public ILoB onlyLessThan(int price) {
        return this;
    }



    // auto-generated methods
    
    @Override
    public boolean equals(Object other) {
        return other instanceof MTLoB;
    }

    @Override
    public int hashCode() {
        return MTLoB.class.hashCode();
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

	public ILoB onlyFiction() {
        if (this.first.isFiction()) {
            return new ConsLoB(this.first, this.rest.onlyFiction());
        } else {
            return this.rest.onlyFiction();
        }
    }
	
    public ILoB onlyLessThan(int price) {
        if (this.first.salePrice() < price) {
            return new ConsLoB(this.first, this.rest.onlyLessThan(price));
        } else {
            return this.rest.onlyLessThan(price);
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
        ConsLoB other = (ConsLoB) obj;
        return Objects.equals(first, other.first) && Objects.equals(rest, other.rest);
    }
	
}