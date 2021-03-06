package elvis.ubooks.book.service;

import java.util.List;

import elvis.ubooks.book.dao.BookDao;
import elvis.ubooks.book.domain.Book;
import elvis.ubooks.book.domain.BookException;

public class BookService {
	private BookDao bookDao = new BookDao();

	public List<Book> findAllBook() {
		return bookDao.findAllBook();
	}

	public List<Book> findBooksByCategory(String cid) {
		return bookDao.findBooksByCategory(cid);
	}

	public Book loadBook(String bid) {
		return bookDao.loadBook(bid);
	}

	public List<Book> search(String text) throws BookException {
		//not completed
		List<Book> bookList = bookDao.search(text);
		if(bookList.isEmpty()){
			throw new BookException("No Result");
		}
		return bookList;
	}

	public void modifyBook(Book book) {
		bookDao.modify(book);
	}

	public void deleteBook(Book book) {
		bookDao.delete(book.getBid());
	}

	public void upload(Book book) {
		bookDao.add(book);
	}
}
