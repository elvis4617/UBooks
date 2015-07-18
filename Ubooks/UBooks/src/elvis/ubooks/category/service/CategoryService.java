package elvis.ubooks.category.service;

import java.util.List;

import elvis.ubooks.category.dao.CategoryDao;
import elvis.ubooks.category.domain.Category;

public class CategoryService {
	private CategoryDao categoryDao = new CategoryDao();

	public List<Category> findAllCategory() {
		return categoryDao.findAllCategory();
	}
}
