package elvis.ubooks.book.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import elvis.ubooks.book.domain.Book;
import elvis.ubooks.book.domain.BookException;
import elvis.ubooks.book.service.BookService;

public class BookServlet extends BaseServlet {
	private BookService bookService = new BookService();

	public String findAllBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("bookList", bookService.findAllBook());
		return "f:/jsps/book/list.jsp";
	}
	
	public String findBooksByCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid = request.getParameter("cid");
		List<Book> bookList = bookService.findBooksByCategory(cid);
		request.setAttribute("bookList", bookList);
		return "f:/jsps/book/list.jsp";
	}
	
	public String loadBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bid = request.getParameter("bid");
		Book book = bookService.loadBook(bid);
		request.setAttribute("book", book);
		return "f:/jsps/book/desc.jsp";
	}

	public String search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String text = request.getParameter("critaria");
		System.out.println(text);
		try {
			List<Book> bookList = bookService.search(text);
			request.setAttribute("bookList", bookList);
			return "f:/jsps/book/list.jsp";
		} catch (BookException e) {
			request.setAttribute("msg", e.getMessage());
			return "f:/jsps/book/list.jsp";
		}
	}
	
	
	
}
