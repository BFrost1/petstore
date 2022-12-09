package ua.petstore.services.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import ua.petstore.model.Category;
import ua.petstore.model.Product;

public class ProductManager {
	private static final String GET_ALL_PRODUCT = "SELECT product.id AS id_product, product.name AS name_product, product.description, product.price, category.id AS id_category, category.name AS name_category, category.url, category.icon, product.image FROM product JOIN category ON product.category_id = category.id";
	private static final String GET_PRODUCT_BY_CATEGORY = GET_ALL_PRODUCT + " WHERE category.id = ?";
	private static final String GET_PRODUCT_BY_ID = GET_ALL_PRODUCT + " WHERE product.id = ?";

	private Logger logger = Logger.getLogger(DBWorker.class.getName());
	private DBWorker worker;

	public ProductManager(DBWorker worker) {
		this.worker = worker;
	}

	public List<Product> getAllProduct() {
		return getAllProduct(null);
	}

	public List<Product> getAllProduct(String category) {
		List<Product> products = null;
		Connection con = worker.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			if (Objects.nonNull(category)) {
				ps = con.prepareStatement(GET_PRODUCT_BY_CATEGORY);
				ps.setString(1, category);
			} else {
				ps = con.prepareStatement(GET_ALL_PRODUCT);
			}

			rs = ps.executeQuery();
			products = new ArrayList<Product>();
			while (rs.next()) {
				products.add(new Product().setId(rs.getInt("id_product")).setName(rs.getString("name_product"))
						.setDescription(rs.getString("description")).setPrice(rs.getDouble("price"))
						.setCategory(new Category().setId(rs.getInt("id_category")).setUrl(rs.getString("url"))
								.setName(rs.getString("name_category")).setIcon(rs.getString("icon")))
						.setImageURL(rs.getString("image")));
			}
		} catch (SQLException e) {
			logger.log(Level.INFO, e.getMessage());
		} finally {
			try {
				if (Objects.nonNull(rs)) {
					rs.close();
				}
			} catch (SQLException e2) {
				logger.log(Level.INFO, e2.getMessage());
			}
			try {
				if (Objects.nonNull(ps)) {
					ps.close();
				}
			} catch (SQLException e1) {
				logger.log(Level.INFO, e1.getMessage());
			}
			try {
				if (Objects.nonNull(con)) {
					con.close();
				}
			} catch (SQLException e) {
				logger.log(Level.INFO, e.getMessage());
			}
		}
		return products;
	}

	public Product getProductById(String id) {
		Product product = null;
		Connection con = worker.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(GET_PRODUCT_BY_ID);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				product = new Product().setId(rs.getInt("id_product")).setName(rs.getString("name_product"))
						.setDescription(rs.getString("description")).setPrice(rs.getDouble("price"))
						.setCategory(new Category().setId(rs.getInt("id_category")).setUrl(rs.getString("url"))
								.setName(rs.getString("name_category")).setIcon(rs.getString("icon")))
						.setImageURL(rs.getString("image"));
			}
		} catch (SQLException e) {
			logger.log(Level.INFO, e.getMessage());
		} finally {
			try {
				if (Objects.nonNull(rs)) {
					rs.close();
				}
			} catch (SQLException e2) {
				logger.log(Level.INFO, e2.getMessage());
			}
			try {
				if (Objects.nonNull(ps)) {
					ps.close();
				}
			} catch (SQLException e1) {
				logger.log(Level.INFO, e1.getMessage());
			}
			try {
				if (Objects.nonNull(con)) {
					con.close();
				}
			} catch (SQLException e) {
				logger.log(Level.INFO, e.getMessage());
			}
		}
		return product;
	}
}
