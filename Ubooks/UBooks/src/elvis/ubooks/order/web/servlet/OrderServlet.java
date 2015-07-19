package elvis.ubooks.order.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import elvis.ubooks.cart.domain.Cart;
import elvis.ubooks.cart.domain.CartItems;
import elvis.ubooks.order.domain.Order;
import elvis.ubooks.order.domain.OrderException;
import elvis.ubooks.order.domain.OrderItem;
import elvis.ubooks.order.orderService.OrderService;
import elvis.ubooks.user.domain.User;

public class OrderServlet extends BaseServlet {
	private OrderService orderService = new OrderService();

	public String addOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		
		Order order = new Order();
		order.setOid(CommonUtils.uuid());
		order.setOrderTime(new Date());
		order.setState(1); 
		order.setOwner((User)request.getSession().getAttribute("session_user"));
		order.setTotal(cart.getTotal());
		
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		
		for(CartItems c: cart.getCartItems()){
			OrderItem item = new OrderItem(
						CommonUtils.uuid(),
						c.getCount(),
						c.getSubTotal(),
						order,
						c.getBook()
					);
			orderItemList.add(item);
		}
		
		order.setOrderItems(orderItemList);
		
		try {
			orderService.addOrder(order);
			request.setAttribute("order", order);
			cart.clear();
			return "f:/jsps/order/desc.jsp";
		} catch (OrderException e) {
			request.setAttribute("msg", e.getMessage());
			return "f:/jsps/msg.jsp";
		}
	}

	public String myOrders(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("session_user");
		String uid = user.getUid();
		List<Order> orderList = orderService.loadOrderByUid(uid);
		request.setAttribute("orderList", orderList);
		return "f:/jsps/order/list.jsp";
	}
	
	
	
	
}
