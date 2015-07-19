package elvis.ubooks.cart.domain;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import elvis.ubooks.book.service.BookService;

public class Cart {
	private Map<String, CartItems> cart = new LinkedHashMap<String, CartItems>();
	
	
	public Map<String, CartItems> getCart() {
		return cart;
	}

	public void setCart(Map<String, CartItems> cart) {
		this.cart = cart;
	}

	public void add(String bid, int count){
		if(cart.keySet().contains(bid)){
			CartItems item = cart.get(bid);
			item.setCount(count + item.getCount());
		}else{
			cart.put(bid, new CartItems(new BookService().loadBook(bid), count));
		}
	}
	
	public void clear(){
		cart.clear();
	}
	
	public void delete(String bid){
		cart.remove(bid);
	}
	
	public double getTotal(){
		BigDecimal total = new BigDecimal("0");
		for(CartItems c : cart.values()){
			total = total.add(new BigDecimal(c.getSubTotal()+""));
		}
		return total.doubleValue();
	}
	
	public Collection<CartItems> getCartItems(){
		return cart.values();
	}
}
