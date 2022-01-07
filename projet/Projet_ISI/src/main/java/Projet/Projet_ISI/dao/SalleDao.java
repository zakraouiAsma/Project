package Projet.Projet_ISI.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import Projet.Projet_ISI.metier.Batiment;
import Projet.Projet_ISI.metier.Demandeur;
import Projet.Projet_ISI.metier.Salle;

public class SalleDao {

	
	private static Connection cnx;

	public  Salle findById(String numSalle)
	{
		
		cnx=Connexion.getInstance();
		Salle s=null;Batiment b=null;
		if (numSalle==null)
			return s;
		
		  try {
			 
			  PreparedStatement pstm = cnx.prepareStatement("select * from salle where numSalle= ?" );
			
			  pstm.setString(1,numSalle);
			  
			  ResultSet set=pstm.executeQuery();
			 // System.out.println(set.next());
			  if(set.next())
			  {
				 
				  s=new Salle(set.getString("numSalle"),set.getDouble(2));
				  b=s.setAdresse(new Batiment(set.getString("adresse")));
				
			  }
			pstm.close();
		  }catch(SQLException e) {
			  e.printStackTrace();  
		  }
		  System.out.println(s);
		return s;
		}
	public   void save (Salle s) {
		if (s==null)
			return ;
		cnx=Connexion.getInstance();
		 int n=0;
		 //requete parametre 
		 String q="insert into Salle (numSalle , superficier ,adresse) values (?,?,?) " ;
		 //prepared statment 
		 PreparedStatement pstm =null ;
		 try {
			 pstm=cnx.prepareStatement(q);
					 //set
					 pstm.setString(1, s.getNumSalle());
					 pstm.setDouble(2,s.getSuperficier());
					 pstm.setString(3,s.getBatiment().getAdresse());
					 //execution
					n= pstm.executeUpdate();
					if (n!=0)
						System.out.println("Salle inserer avec succés");
		 }catch (SQLException e1) {
			// e1.printStackTrace();
			 if (e1 instanceof SQLIntegrityConstraintViolationException )
			 {
				 System.out.println("la salle existe deja dans la base ");
			 }
		 }
		 try {
			 if (n==0) {
				 pstm=cnx.prepareStatement("update salle set superficier=? , adresse=? where trim (numSalle)=?");
			
				
				 //set
				 pstm.setString(3, s.getNumSalle());
				 pstm.setDouble(2,s.getSuperficier());
				 pstm.setString(1,s.getBatiment().getAdresse());
				
				 
		    	pstm.executeUpdate();
			
			 System.out.println("mise a jour de la salle  terminé avec succés");
			 }
			 
			 
		 }catch(SQLException e2) {
             e2.getMessage();
		 }
		 finally {
		Connexion.close();
		 }
		 
	}
	
}
