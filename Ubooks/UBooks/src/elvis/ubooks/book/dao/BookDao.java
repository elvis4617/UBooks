package elvis.ubooks.book.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.jdbc.TxQueryRunner;
import elvis.ubooks.book.domain.Book;

public class BookDao {
	private QueryRunner qr = new TxQueryRunner();

	public List<Book> findAllBook() {
		try{
			String sql = "select * from book where del = false";
			return qr.query(sql, new BeanListHandler<Book>(Book.class));
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public List<Book> findBooksByCategory(String cid) {
		try{
			String sql = "select * from book where del = false and cid=?";
			return qr.query(sql, new BeanListHandler<Book>(Book.class), cid);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public Book loadBook(String cid) {
		try{
			String sql = "select * from book where del = false and bid=?";
			return qr.query(sql, new BeanHandler<Book>(Book.class), cid);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public List<Book> search(String text) {
		try{
			String sql = "select * from book where del = false and bname like ?";
			text = "%" + text + "%";
			return qr.query(sql, new BeanListHandler<Book>(Book.class),text);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public int getCountByCid(String cid) {
		try{
			String sql = "select count(*) from book where cid=?";
			Number number = (Number) qr.query(sql, new ScalarHandler(),cid);
			return number.intValue();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public String getCidByBid(String bid) {
		try{
			String sql = "select cid from book where del = false and bid=?";
			Map<String, Object> map = qr.query(sql, new MapHandler(), bid);
			return (String) map.get("cid");
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void modify(Book book) {
		try{
			String sql = "UPDATE book SET bname=?, price=?, author=?, cid=? where del = false and bid=?";
			System.out.println(book.getCategory() == null);
			qr.update(sql, book.getBname(), book.getPrice(), book.getAuthor(), book.getCategory().getCid(), book.getBid());
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void delete(String bid) {
		try{
			String sql = "update book set del=true where bid=?";
			qr.update(sql, bid);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void add(Book book) {
		try{
			String sql = "insert into book values(?,?,?,?,?,?,?)";
			Object[] params = {
					book.getBid(),
					book.getBname(),
					book.getPrice(),
					book.getAuthor(),
					book.getImage(),
					book.getCategory().getCid(),
					book.isDel()
			};
			qr.update(sql, params);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}
}
