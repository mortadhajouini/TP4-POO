package JDBCProject.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	static Connection conn;
	public static Connection getConnexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			}
		catch(ClassNotFoundException ex) {
			System.out.println("Problème de chargement du Driver!");
			System.exit(1);
			}
		String url = "jdbc:mysql://localhost:3306/jdbc";
		try {
		conn = DriverManager.getConnection(url, "root","");

		}
		catch (SQLException e) {
		System.err.println("Error opening SQL connection:"+ e.getMessage());
		}
		
		return conn;
		
	}
}
