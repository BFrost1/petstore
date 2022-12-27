package ua.petstore.dao;

import ua.petstore.model.User;

public interface UserDAO {
	User getUserById(int id);

	User getUserByLogin(String login);

	User getUserByLoginPassword(String login, String password);

	User addUser(User user);
}
