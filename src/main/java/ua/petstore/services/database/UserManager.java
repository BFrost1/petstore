package ua.petstore.services.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.stereotype.Service;

import ua.petstore.dao.UserDAO;
import ua.petstore.model.User;
import ua.petstore.services.encoding.Encoding;

@Service
public class UserManager implements UserDAO {
	private EntityManager manager = Persistence.createEntityManagerFactory("petstore").createEntityManager();

	public UserManager() {

	}
	
	@Override
	public User getUserById(int id) {
		return manager.find(User.class, id);
	}
	
	@Override
	public User getUserByLogin(String login) {
		List<User> users = manager.createNamedQuery("User.getUserByEmail", User.class).setParameter("email", login).getResultList();
		return users.isEmpty() ? null : users.get(0);
	}
	
	@Override
	public User getUserByLoginPassword(String login, String password) {
		List<User> users = manager.createNamedQuery("User.getUserByEmailPassword", User.class).setParameter("email", login).setParameter("password", Encoding.md5EncryptionWithSalt(password)).getResultList();
		return users.isEmpty() ? null : users.get(0);

	}
	
	@Override
	public User addUser(User user) {
		manager.getTransaction().begin();
		user.setPassword(Encoding.md5EncryptionWithSalt(user.getPassword()));
		User userDB = manager.merge(user);
		manager.getTransaction().commit();
		return userDB;
	}
}
