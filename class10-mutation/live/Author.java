import java.util.Objects;

/** Represents authors of books */
class Author {
   
	private String name;
	private int yob;
	private Book book;

    Author(String name, int yob, Book bk) {
        this.name = name;
        this.yob = yob;
        this.book = bk;
    }

	@Override
	public int hashCode() {
		return Objects.hash(book, name, yob);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return Objects.equals(book, other.book) && Objects.equals(name, other.name) && yob == other.yob;
	}
	
	 @Override
		public String toString() {
			return "Author [name=" + name + ", yob=" + yob + ", book=" + book + "]";
		}

	

	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * 	Sets this author's book to the given bk

	 * @param book the book to set
	 */
	public void setBook(Book bk) {
		if (bk == null) {
			throw new RuntimeException("attempted to set a null book for " + this);
		} else if (!bk.sameAuthor(this)) {
			throw new RuntimeException("inconsistent update of book for " + this);
		} else {	
			this.book = bk;
		}
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the yob
	 */
	public int getYob() {
		return yob;
	}
	
	

}