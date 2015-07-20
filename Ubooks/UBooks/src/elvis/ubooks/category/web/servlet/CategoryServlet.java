package elvis.ubooks.category.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import elvis.ubooks.category.service.CategoryService;

public class CategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 5756677955604271393L;
	
	private CategoryService categoryService = new CategoryService();

	public String findAllCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("categoryList", categoryService.findAllCategory());
		return "f:/jsps/left.jsp";
	}
	
	
}
