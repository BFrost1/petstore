package ua.petstore.services.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.stereotype.Service;

import ua.petstore.dao.CategoryDAO;
import ua.petstore.model.Category;

@Service
public class CategoryManager implements CategoryDAO {
	private EntityManager manager = Persistence.createEntityManagerFactory("petstore").createEntityManager();

	public CategoryManager() {
	}

	@Override
	public List<Category> getAllCategory() {
		return manager.createNamedQuery("Category.getAllCategory", Category.class).getResultList();
	}
}
