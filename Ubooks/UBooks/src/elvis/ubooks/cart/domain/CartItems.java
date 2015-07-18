package elvis.ubooks.cart.domain;

import java.math.BigDecimal;

import elvis.ubooks.book.domain.Book;

public class CartItems {
	private Book book;
	private int count;
	
	public CartItems(Book book, int count) {
		super();
		this.book = book;
		this.count = count;
	}
	public double getSubTotal(){
		BigDecimal b1 = new BigDecimal(book.getPrice()+"");
		BigDecimal b2 = new BigDecimal(count+"");
		return b1.multiply(b2).doubleValue();
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "CartItems [book=" + book + ", count=" + count + "]";
	}
	
	
}
