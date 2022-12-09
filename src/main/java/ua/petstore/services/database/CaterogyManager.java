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

public class CaterogyManager {
	private static final String GET_ALL_CATEROGY = "SELECT * FROM category";
	private Logger logger = Logger.getLogger(DBWorker.class.getName());
	private DBWorker worker;
	
	public CaterogyManager(DBWorker worker) {
		this.worker = worker;
	}
	
	public List<Category> getAllCategory() {
		List<Category> categories = null;
		Connection con = worker.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(GET_ALL_CATEROGY);
			rs = ps.executeQuery();
			categories = new ArrayList<Category>();
			
			while (rs.next()) {
				categories.add(new Category().setId(rs.getInt("id")).setUrl(rs.getString("url")).setName(rs.getString("name")).setIcon(rs.getString("icon")));
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
		return categories;
	}
}
