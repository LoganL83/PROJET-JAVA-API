package springboot.dao;

import java.util.List;

import springboot.exceptions.DaoException;
import springboot.model.User;;

public interface UserDao {

	void add(User user) throws DaoException;
	List<User> lister() throws DaoException;

}

