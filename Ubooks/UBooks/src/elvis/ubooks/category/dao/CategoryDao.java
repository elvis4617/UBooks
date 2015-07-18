package elvis.ubooks.category.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
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
}
