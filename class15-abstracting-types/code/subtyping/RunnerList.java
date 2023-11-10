


// represents a list of Runners
interface ILoR {
	// total distance run by all
	public int totalDist();
}

class MTLoR implements ILoR {
  MTLoR() {}

  public int totalDist() {
	  return 0;
  }
}

class ConsLoR implements ILoR {
  Runner first;
  ILoR rest;
  
  ConsLoR(Runner first, ILoR rest) {
    this.first = first;
    this.rest = rest;
  }
  
  public int totalDist() {
	  return this.first.getDist() + this.rest.totalDist();
  }

  
}

