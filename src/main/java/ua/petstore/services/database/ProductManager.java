package ua.petstore.services.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.stereotype.Service;

import ua.petstore.dao.ProductDAO;
import ua.petstore.model.Product;

@Service
public class ProductManager implements ProductDAO {
	private EntityManager manager = Persistence.createEntityManagerFactory("petstore").createEntityManager();

	public ProductManager() {
	}

	@Override
	public List<Product> getAllProduct() {
		return manager.createNamedQuery("Product.getAllProduct", Product.class).getResultList();
	}

	@Override
	public List<Product> getAllProductCategory(int category) {
		return manager.createNamedQuery("Product.getAllProductCategory", Product.class).setParameter("category", category).getResultList();
	}

	@Override
	public Product getProductById(int id) {
		return manager.find(Product.class, id);
	}
}
