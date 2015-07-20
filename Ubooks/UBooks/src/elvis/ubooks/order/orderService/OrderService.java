package elvis.ubooks.order.orderService;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.jdbc.JdbcUtils;
import elvis.ubooks.order.dao.OrderDao;
import elvis.ubooks.order.domain.Order;
import elvis.ubooks.order.domain.OrderException;

public class OrderService {
	private OrderDao orderDao = new OrderDao();

	public void addOrder(Order order) throws OrderException {
		try{
			JdbcUtils.beginTransaction();
			orderDao.addOrder(order);
			orderDao.addOrderItemList(order.getOrderItems());
			JdbcUtils.commitTransaction();
		}catch(Exception e){
			try {
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e1) {
				throw new RuntimeException(e);
			}
			throw new RuntimeException(e);
			//throw new OrderException("Fail to commit order");
		}
	}

	public List<Order> loadOrderByUid(String uid) {
		return orderDao.loadOrderByUid(uid);
	}

	public Object loadOrders() {
		return orderDao.loadOrders();
	}

	
}
