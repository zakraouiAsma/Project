package Projet.Projet_ISI.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import Projet.Projet_ISI.metier.Batiment;
import Projet.Projet_ISI.metier.Demandeur;

public class BatimentDao {
	private static Connection cnx;
	public   void save (Batiment b) {
		if (b==null)
			return ;
		cnx=Connexion.getInstance();
		 int n=0;
		 //requete parametre 
		 String q="insert into Batiment (adresse) values (?) " ;
		 //prepared statment 
		 PreparedStatement pstm =null ;
		 try {
			 pstm=cnx.prepareStatement(q);
					 //set
					
					 pstm.setString(1, b.getAdresse());
					 //execution
					n= pstm.executeUpdate();
					if (n!=0)
						System.out.println("Batiment inserer avec succés");
		 }catch (SQLException e1) {
			// e1.printStackTrace();
			 if (e1 instanceof SQLIntegrityConstraintViolationException )
			 {
				 System.out.println("Batiment existe deja dans la base ");
			 }
		 }
		 
		 finally {
		Connexion.close();
		 }
		 
	}
}
