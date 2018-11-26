package springboot.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {

	private String url;
	private String email;
	private String mot_de_passe;

	DaoFactory(String url, String email, String mot_de_passe) {

		this.url = url;
		this.email = email;
		this.mot_de_passe = mot_de_passe;

	}

	public static DaoFactory getInstance() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		}

		DaoFactory instance = new DaoFactory(

				"jdbc:mysql://localhost:3306/taFormation", "root", "ioplop88");
		return instance;

	}

	public Connection getConnection() throws SQLException {

		return DriverManager.getConnection(url, email, mot_de_passe);

	}

	// Recupération du Dao

	public UserDao getUtilisateurDao() {

		return new UserDaoImpl(this);

	}

}

