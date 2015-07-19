package elvis.ubooks.book.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import elvis.ubooks.book.domain.Book;

public class BookDao {
	private QueryRunner qr = new TxQueryRunner();

	public List<Book> findAllBook() {
		try{
			String sql = "select * from book";
			return qr.query(sql, new BeanListHandler<Book>(Book.class));
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public List<Book> findBooksByCategory(String cid) {
		try{
			String sql = "select * from book where cid=?";
			return qr.query(sql, new BeanListHandler<Book>(Book.class), cid);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public Book loadBook(String cid) {
		try{
			String sql = "select * from book where bid=?";
			return qr.query(sql, new BeanHandler<Book>(Book.class), cid);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public List<Book> search(String text) {
		try{
			String sql = "select * from book where bname like ?";
			text = "%" + text + "%";
			return qr.query(sql, new BeanListHandler<Book>(Book.class),text);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
