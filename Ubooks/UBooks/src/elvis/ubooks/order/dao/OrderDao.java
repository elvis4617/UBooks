package elvis.ubooks.order.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;
import elvis.ubooks.book.domain.Book;
import elvis.ubooks.category.service.CategoryService;
import elvis.ubooks.order.domain.Order;
import elvis.ubooks.order.domain.OrderItem;

public class OrderDao {
	private QueryRunner qr = new TxQueryRunner();
	
	public void addOrder(Order order){
		try{
			String sql = "insert into orders values(?,?,?,?,?,?)";
			Object[] params = {
					order.getOid(),
					new Timestamp(order.getOrderTime().getTime()),
					order.getTotal(),
					order.getState(),
					order.getOwner().getUid(),
					order.getAddress()
			};
			qr.update(sql, params);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void addOrderItemList(List<OrderItem> orderItemList){
		try{
			String sql = "insert into orderitem values(?,?,?,?,?)";
			Object[][] params = new Object[orderItemList.size()][];
			
			for(int i=0; i< orderItemList.size(); i++){
				OrderItem o = orderItemList.get(i);
				params[i] = new Object[]{
					o.getIid(),
					o.getCount(),
					o.getSubtotal(),
					o.getOrder().getOid(),
					o.getBook().getBid()
				};
			}
			
			qr.batch(sql, params);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public List<Order> loadOrderByUid(String uid) {
		try{
			String sql = "select * from orders where uid=?";
			List<Order> orderList =  qr.query(sql, new BeanListHandler<Order>(Order.class),uid);
			
			for(Order o : orderList){
				loadOrderItems(o);
			}
			return orderList;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void loadOrderItems(Order order) {
		try{
			String sql = "select * from orderitem i, book b where i.bid=b.bid and oid=?";
			List<Map<String, Object>> mapList = qr.query(sql, new MapListHandler(), order.getOid());
			List<OrderItem> orderItemList = toOrderItemList(mapList);
			order.setOrderItems(orderItemList);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	private List<OrderItem> toOrderItemList(List<Map<String, Object>> mapList) {
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		for(Map<String, Object> m : mapList){
			OrderItem item = toOrderItem(m);
			orderItemList.add(item);
		}
		return orderItemList;
	}

	private OrderItem toOrderItem(Map<String, Object> m) {
		OrderItem item = CommonUtils.toBean(m, OrderItem.class);
		Book book = CommonUtils.toBean(m, Book.class);
		item.setBook(book);
		return item;
	}
		
}
