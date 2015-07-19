package elvis.ubooks.order.domain;

import java.util.Date;
import java.util.List;

import elvis.ubooks.user.domain.User;

public class Order {
	private String oid;
	private Date orderTime;
	private double total;
	private int state; // 1. preOrder-Negotiation 2. meet-pay 3.finished order
	private User owner;

	private List<OrderItem> orderItems;
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", orderTime=" + orderTime + ", total="
				+ total + ", state=" + state + ", owner=" + owner
				+ ", address=" + address + "]";
	}

	private String address;
}
