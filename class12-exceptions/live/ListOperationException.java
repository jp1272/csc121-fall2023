

public class ListOperationException extends Exception {

	private int index;
	
	public ListOperationException(int index) {
		super("index out of bounds: " + index);
		this.index = index;
	}
	
	public int getIndex() {
		return this.index;
	}
	
}
