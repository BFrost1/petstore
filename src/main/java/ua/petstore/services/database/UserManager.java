package ua.petstore.services.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import ua.petstore.model.User;
import ua.petstore.services.encoding.Encoding;

public class UserManager {
	private static final String GET_USER = "SELECT id, last_name, first_name, email, password, phone, agreement  FROM user WHERE email = ? AND password = ?";
	private static final String ADD_USER = "INSERT INTO user (first_name, last_name, email, password, phone, agreement) VALUES(?,?,?,?,?,?)";
	private static final String GET_EMAIL_USER = "SELECT email FROM user WHERE email = ?";
	
	private Logger logger = Logger.getLogger(DBWorker.class.getName());
	private DBWorker worker;

	public UserManager(DBWorker worker) {
		this.worker = worker;
	}

	public User getUser(String login, String password) {
		User user = null;
		Connection con = worker.getConnection();
		if (Objects.nonNull(login) && Objects.nonNull(password) && Objects.nonNull(con)) {
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				ps = con.prepareStatement(GET_USER);
				ps.setString(1, login);
				ps.setString(2, Encoding.md5EncryptionWithSalt(password));
				rs = ps.executeQuery();
				if (rs.next()) {
					user = new User().setId(rs.getInt("id")).setFirstName(rs.getString("first_name"))
							.setLastName(rs.getString("last_name")).setEmail(rs.getString("email"))
							.setPassword(rs.getString("password")).setPhone(rs.getString("phone"))
							.setAgreement(rs.getBoolean("agreement"));
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
		}
		return user;
	}

	public boolean addUser(User user) {
		Connection con = worker.getConnection();
		if (Objects.nonNull(user)) {
			PreparedStatement ps = null;
			try {
				ps = con.prepareStatement(ADD_USER);
				ps.setString(1, user.getFirstName());
				ps.setString(2, user.getLastName());
				ps.setString(3, user.getEmail());
				ps.setString(4, Encoding.md5EncryptionWithSalt(user.getPassword()));
				ps.setString(5, user.getPhone());
				ps.setBoolean(6, user.isAgreement());
				ps.execute();
			} catch (SQLException e) {
				logger.log(Level.INFO, e.getMessage());
				return false;
			} finally {
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
		}
		return true;
	}
	
	public boolean checkEmailUser(String email) {
		Connection con = worker.getConnection();
		String user = null;
		if (Objects.nonNull(email)) {
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				ps = con.prepareStatement(GET_EMAIL_USER);
				ps.setString(1, email);
				rs = ps.executeQuery();
				if (rs.next()) {
					user = rs.getString("email");
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
		}
		return user == null ? false : true;
	}
}
