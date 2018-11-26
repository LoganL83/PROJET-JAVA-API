package springboot.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import springboot.exceptions.DaoException;
import springboot.model.User;

public class UserDaoImpl implements UserDao {

	private DaoFactory daoFactory;

	UserDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void add(User user)throws DaoException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {

			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("INSERT INTO User(email, mot_de_passe) VALUES(?, ?);");
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getMot_de_passe());
			preparedStatement.executeUpdate();

			connexion.commit();
			
		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	@Override

	public List<User> lister() {

		List<User> users = new ArrayList<User>();

		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;

		try {

			connexion = daoFactory.getConnection();

			statement = connexion.createStatement();

			resultat = statement.executeQuery("SELECT email, mot_de_passe FROM User;");

			while (resultat.next()) {

				String email = resultat.getString("email");
				String mot_de_passe = resultat.getString("mot_de_passe");

				User user = new User();

				user.setEmail(email);
				user.setMot_de_passe(mot_de_passe);
				users.add(user);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return users;
	}
}

