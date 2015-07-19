package elvis.ubooks.category.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import elvis.ubooks.category.domain.Category;

public class CategoryDao {
	private QueryRunner qr = new TxQueryRunner();

	public List<Category> findAllCategory() {
		try{
			String sql = "select * from category";
			return qr.query(sql, new BeanListHandler<Category>(Category.class));
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public Category loadCategoryByCid(String cid) {
		try{
			String sql = "select * from category where cid=?";
			return qr.query(sql, new BeanHandler<Category>(Category.class),cid);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Category loadCategoryByCname(String cname) {
		try{
			String sql = "select * from category where cname=?";
			return qr.query(sql, new BeanHandler<Category>(Category.class),cname);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void edit(String cid, String cname) {
		try{
			String sql = "update category set cname=? where cid=?";
			qr.update(sql, cname, cid);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void delete(String cid) {
		try{
			String sql = "delete from category where cid=?";
			qr.update(sql, cid);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void add(Category category) {
		try{
			String sql = "insert into category values(?,?)";
			qr.update(sql, category.getCid(), category.getCname());
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
