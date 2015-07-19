package elvis.ubooks.book.admin.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import elvis.ubooks.book.domain.Book;
import elvis.ubooks.book.service.BookService;
import elvis.ubooks.category.domain.Category;
import elvis.ubooks.category.service.CategoryService;

public class AdminBookServlet extends BaseServlet {
	private BookService bookService = new BookService();
	private CategoryService categoryService = new CategoryService();

	public String findAllBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("bookList", bookService.findAllBook());
		return "f:/adminjsps/admin/book/list.jsp";
	}
	
	public String loadBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bid = request.getParameter("bid");
		Book book = bookService.loadBook(bid);
		Category category = categoryService.loadCategorybyBid(bid);
		book.setCategory(category);
		List<Category> categoryList = categoryService.findAllCategory();
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("book", book);
		return "f:/adminjsps/admin/book/desc.jsp";
	}
	
	public String mod(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Book book = CommonUtils.toBean(request.getParameterMap(), Book.class);
		double price = Double.valueOf(request.getParameter("price"));
		String cid = request.getParameter("cid");
		System.out.println(cid);
		Category category = categoryService.loadCategorybyCid(cid);
		System.out.println(category==null);
		book.setPrice(price);
		book.setCategory(category);
		bookService.modifyBook(book);
		request.setAttribute("msg", "modify book successfullly");
		return "f:/adminjsps/admin/msg.jsp";
	}
	
	public String del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Book book = CommonUtils.toBean(request.getParameterMap(), Book.class);
		bookService.deleteBook(book);
		request.setAttribute("msg", "delete book successfullly");
		return "f:/adminjsps/admin/msg.jsp";
	}
	
	
	
}
