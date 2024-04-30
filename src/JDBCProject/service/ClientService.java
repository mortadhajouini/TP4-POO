package JDBCProject.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import JDBCProject.beans.Client;
import JDBCProject.connexion.Connexion;
import JDBCProject.dao.IDao;

public class ClientService implements IDao<Client> {

	@Override
	public boolean create(Client o) {
		PreparedStatement pstmt;
		try {
			pstmt = Connexion.getConnexion().prepareStatement("Insert Into Client(nom,prenom) VALUES (?,?)");
			pstmt.setString(1,o.getNom());
			pstmt.setString(2,o.getPrenom());
			int x= pstmt.executeUpdate();
			if(x>0) {
			return true;
			}
			else {
				return false;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<Client> findAll() {
		ArrayList<Client> l = new ArrayList <> ();
		try {
			Statement stmt =Connexion.getConnexion().createStatement();	
			ResultSet rs = stmt.executeQuery("SELECT * FROM Client");
			while (rs.next()) {
				l.add(new Client(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public Client findById(int id) {
		try {

			PreparedStatement ps =Connexion.getConnexion().prepareStatement("Select * from Client where id = ? ");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();	
			return new Client(rs.getInt(1),rs.getString(2),rs.getString(3));
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delete(Client o) {
		PreparedStatement pstmt;
		try {
			pstmt = Connexion.getConnexion().prepareStatement("delete from Client where id=?");
			pstmt.setInt(1,o.getId());
			pstmt.executeUpdate();
			return true;
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Client o) {
		PreparedStatement pstmt;
		Scanner scanner = new Scanner(System.in);

        System.out.println("Nom= ");
        String nom = scanner.nextLine();
        System.out.println("Prenom= ");
        String Prenom = scanner.nextLine();
		try {
			pstmt = Connexion.getConnexion().prepareStatement("update Client set nom=?, prenom=? where id=?");
			pstmt.setString(1,nom);
			pstmt.setString(2,Prenom);
			pstmt.setInt(3,o.getId());
			pstmt.executeUpdate();
			return true;
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}


 
}
