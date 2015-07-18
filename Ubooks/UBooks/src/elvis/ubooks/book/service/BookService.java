package elvis.ubooks.book.service;

import java.util.List;

import elvis.ubooks.book.dao.BookDao;
import elvis.ubooks.book.domain.Book;

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
}
