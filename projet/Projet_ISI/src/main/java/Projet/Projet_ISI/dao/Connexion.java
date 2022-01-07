package Projet.Projet_ISI.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

	private static String  url="jdbc:mysql://localhost/reserv";
	private static String user="root";
	private static String pass ="";
	private static Connection cnx=null;
	
	
	public static Connection getInstance()  {
		try {
			if(cnx==null ||  cnx.isClosed())
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
					cnx=DriverManager.getConnection(url,user ,pass);
					System.out.println("Vous ete connecté");
				} 
				catch (SQLException e) {
					System.out.println("Vous n'ete pas  connecté");
				}//Fin connection
			return cnx;	
	}
	
	public static void close() {
		try {
		if(cnx!=null && !cnx.isClosed())
				cnx.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println(" Echec de la fermeture de la Connexion ");
			}
		}
}
