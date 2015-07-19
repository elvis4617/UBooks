package elvis.ubooks.category.service;

import java.util.List;

import elvis.ubooks.book.dao.BookDao;
import elvis.ubooks.category.dao.CategoryDao;
import elvis.ubooks.category.domain.Category;
import elvis.ubooks.category.domain.CategoryException;

public class CategoryService {
	private CategoryDao categoryDao = new CategoryDao();
	private BookDao bookDao = new BookDao();

	public List<Category> findAllCategory() {
		return categoryDao.findAllCategory();
	}

	public Category loadCategorybyCid(String cid) {
		return categoryDao.loadCategoryByCid(cid);
	}
	
	public Category loadCategorybyCname(String cname){
		return categoryDao.loadCategoryByCname(cname);
	}
	
	public Category loadCategorybyBid(String bid) {
		String cid = bookDao.getCidByBid(bid);
		return loadCategorybyCid(cid);
	}

	public void modifyCategory(String cid, String cname) {
		categoryDao.edit(cid, cname);
	}

	public void deleteCategory(String cid) throws CategoryException {
		if(bookDao.getCountByCid(cid) > 0)
			throw new CategoryException("Cant delete this category");
		categoryDao.delete(cid);
	}

	public void add(Category category) throws CategoryException {
		Category _category = loadCategorybyCname(category.getCname());
		if(_category != null) throw new CategoryException("Category exists");
		categoryDao.add(category);
	}

	
}
