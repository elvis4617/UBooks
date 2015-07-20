package elvis.ubooks.cart.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import elvis.ubooks.cart.domain.Cart;

public class CartServlet extends BaseServlet {

	private static final long serialVersionUID = 6672396514660893930L;

	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bid = request.getParameter("bid");
		int count = Integer.parseInt(request.getParameter("count"));
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		cart.add(bid, count);
		return "f:/jsps/cart/list.jsp";
	}
	
	public String clear(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		cart.clear();
		return "f:/jsps/cart/list.jsp";
	}
	
	public String delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bid = request.getParameter("bid");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		cart.delete(bid);
		return "f:/jsps/cart/list.jsp";
	}

}
