package ua.petstore.dao;

import java.util.List;

import ua.petstore.model.Product;

public interface ProductDAO {
	List<Product> getAllProduct();

	List<Product> getAllProductCategory(int category);

	Product getProductById(int id);
}
