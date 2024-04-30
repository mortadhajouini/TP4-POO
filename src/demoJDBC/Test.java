package demoJDBC;

import java.sql.Connection;

import JDBCProject.beans.Client;
import JDBCProject.connexion.Connexion;
import JDBCProject.service.ClientService;

public class Test {
	public static void main(String args[]){
	Connection cn =Connexion.getConnexion();
	Client C1= new Client("Mortadha","Jouini");
	Client C2= new Client("Sedki","Shabou");
	Client C3= new Client("Ahmed","Mghirbi");
	Client C4= new Client("Dhia","MArsit");
	Client C5= new Client("Jihed","Harnif");
	ClientService s= new ClientService();
	//s.create(C3);
	//s.create(C4);
	//s.create(C5);
	System.out.println(s.findById(4));
	System.out.println(s.delete(s.findById(6)));
	System.out.println(s.update(s.findById(2)));
	for(Client c: s.findAll()) {
		System.out.println(c);
		}


	}
}
