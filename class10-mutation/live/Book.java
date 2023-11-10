import java.util.Objects;

/** Represent books */
class Book {
    private String title;
    private int price;
    private int quantity;
    private Author author;

    Book(String title, int price, int quantity, Author ath) {
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.author = ath;
        
        this.author.setBook(this);
    }
    

    @Override
	public int hashCode() {
		return Objects.hash(author, price, quantity, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && price == other.price && quantity == other.quantity
				&& Objects.equals(title, other.title);
	}


	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", quantity=" + quantity + ", author=" + author + "]";
	}


	/** is the given author the same as this book's author */
	public boolean sameAuthor(Author other) {
		return this.author.equals(other);
	}
	
	
	/** produces this book's author */
	public Author getAuthor() {
		return this.author;
	}
	

}