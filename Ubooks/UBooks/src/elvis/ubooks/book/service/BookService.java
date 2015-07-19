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
			System.out.println("epty");
			throw new BookException("No Result");
		}
		return bookList;
	}
}
