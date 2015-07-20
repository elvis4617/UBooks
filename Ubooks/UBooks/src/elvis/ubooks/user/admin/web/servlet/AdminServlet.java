package elvis.ubooks.user.admin.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import elvis.ubooks.user.domain.User;
import elvis.ubooks.user.service.UserException;
import elvis.ubooks.user.service.UserService;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/adminjsps/AdminServlet")
public class AdminServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	
	public String adminLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		try {
			User user = userService.adminLogin(form);
			request.getSession().setAttribute("session_admin", user);
			return "r:/adminjsps/admin/main.jsp";
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			return "f:/adminjsps/login.jsp";
		}
	}
	
	public String logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		return "r:/adminjsps/login.jsp";
	}
	
	
}
