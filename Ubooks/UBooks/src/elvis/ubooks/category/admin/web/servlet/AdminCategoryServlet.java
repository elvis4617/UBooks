package elvis.ubooks.category.admin.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import elvis.ubooks.category.domain.Category;
import elvis.ubooks.category.domain.CategoryException;
import elvis.ubooks.category.service.CategoryService;

public class AdminCategoryServlet extends BaseServlet {
	private static final long serialVersionUID = -183298064672218300L;
	private CategoryService categoryService = new CategoryService();
	
	public String findAllCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("categoryList", categoryService.findAllCategory());
		return "f:/adminjsps/admin/category/list.jsp";
	}
	
	public String addCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Category category = CommonUtils.toBean(request.getParameterMap(), Category.class);
		category.setCid(CommonUtils.uuid());
		try {
			categoryService.add(category);
			return findAllCategory(request, response);
		} catch (CategoryException e) {
			request.setAttribute("msg", e.getMessage());
			return "f:/adminjsps/admin/category/add.jsp";
		}
		
	}

	public String loadCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid = request.getParameter("cid");
		Category category = categoryService.loadCategorybyCid(cid);
		request.setAttribute("category", category);
		return "f:/adminjsps/admin/category/mod.jsp";
	}
	
	public String modifyCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid = request.getParameter("cid");
		String cname = request.getParameter("cname");
		categoryService.modifyCategory(cid, cname);
		request.setAttribute("msg", "edit successfully");
		return "f:/adminjsps/admin/msg.jsp";
	}
	
	public String deleteCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid = request.getParameter("cid");
		try {
			categoryService.deleteCategory(cid);
			return findAllCategory(request, response);
		} catch (CategoryException e) {
			request.setAttribute("msg", e.getMessage());
			return "f:/adminjsps/admin/msg.jsp";
		}
	}
}
