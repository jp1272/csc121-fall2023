import java.util.Objects;

public class Unknown implements IAT {
	

	/** count the number of known people in this family tree */
	public int count() {
		return 0;
	}
	
	@Override
	public boolean equals(Object other) {
	    return other instanceof Unknown;
	}

	@Override
	public int hashCode() {
	    return Unknown.class.hashCode();
	}

}
