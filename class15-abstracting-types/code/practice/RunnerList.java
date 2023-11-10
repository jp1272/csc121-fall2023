// represents a list of Runners
package practice;

import java.util.Objects;

interface ILoR {
    // total distance run by all
    public int totalDist();

    // selects only the runners that are over 40
    public ILoR selectOver40();
}

class MTLoR implements ILoR {
    MTLoR() {}

    public int totalDist() {
        return 0;
    }

    public ILoR selectOver40() {
        return this;
    }

    // auto-generated methods

    @Override
    public boolean equals(Object other) {
        return other instanceof MTLoR;
    }

    @Override
    public int hashCode() {
        return MTLoR.class.hashCode();
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

    public ILoR selectOver40() {
        if (this.first.isOver40()) {
            return new ConsLoR(this.first, this.rest.selectOver40());
        } else {
            return this.rest.selectOver40();
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
        ConsLoR other = (ConsLoR) obj;
        return Objects.equals(first, other.first) && Objects.equals(rest, other.rest);
    }

}

