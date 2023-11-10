

import java.util.Objects;

/** Represents a list of people in a phone contact list */
interface ILoP {
    
}



class MTLoP implements ILoP {

    public MTLoP() {}

   

    
    // auto-generated methods
    
    @Override
    public boolean equals(Object other) {
        return other instanceof MTLoP;
    }

    @Override
    public int hashCode() {
        return MTLoP.class.hashCode();
    }
}



class ConsLoP implements ILoP {
    Person first;
    ILoP rest;

    public ConsLoP(Person first, ILoP rest) {
        this.first = first;
        this.rest = rest;
    }
    

   
    
    // auto-generated methods  
    
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
        ConsLoP other = (ConsLoP) obj;
        return Objects.equals(first, other.first) && Objects.equals(rest, other.rest);
    }

}