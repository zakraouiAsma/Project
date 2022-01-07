package Projet.Projet_ISI.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import Projet.Projet_ISI.metier.PlageHoraire;
import Projet.Projet_ISI.metier.Salle;


public class PlageHoraireDao {
	private static Connection cnx;

	public PlageHoraire  findById(String idPlageH)
	{
		
		cnx=Connexion.getInstance();
		PlageHoraire p=null;
		if (idPlageH==null)
			return p;
		
		  try {
			 
			  PreparedStatement pstm = cnx.prepareStatement("select * from PlageHoraire where idPlageH= ?" );
			
			  pstm.setString(1,idPlageH);
			  
			  ResultSet set=pstm.executeQuery();
			 // System.out.println(set.next());
			  if(set.next())
			  {
				 
				  p=new PlageHoraire(set.getString("idPlageH"),set.getDate(2).toLocalDate(),set.getDouble(3),set.getDouble(4));
				  
			  }
			pstm.close();
		  }catch(SQLException e) {
			  e.printStackTrace();  
		  }
	
		return p;
		}
	
	public   void save (PlageHoraire p) {
		if (p==null)
			return ;
		cnx=Connexion.getInstance();
		 int n=0;
		 //requete parametre 
		 String q="insert into PlageHoraire (idPlageH ,date ,heureDebut,heureFin) values (?,?,?,?) " ;
		 //prepared statment 
		 PreparedStatement pstm =null ;
		 try {
			 pstm=cnx.prepareStatement(q);
					 //set
					 pstm.setString(1, p.getIdPlageH());
					 pstm.setDate(2, java.sql.Date.valueOf(p.getDate()));
					 pstm.setDouble(3,p.getHeureDebut());
					 pstm.setDouble(4,p.getHeureFin());
					 
					 //execution
					n= pstm.executeUpdate();
					if (n!=0)
						System.out.println("horaire inserer avec succés");
		 }catch (SQLException e1) {
			// e1.printStackTrace();
			 if (e1 instanceof SQLIntegrityConstraintViolationException )
			 {
				 System.out.println("la palge horaire existe deja");
			 }
		 }
		 try {
			 if (n==0) {
				 pstm=cnx.prepareStatement("update PlageHoraire set date=? , heureDebut=?,heureFin=?  where trim (idPlageH)=?");
			
				
				 //set
				 pstm.setString(4, p.getIdPlageH());
				 pstm.setDate(2, java.sql.Date.valueOf(p.getDate()));
				 pstm.setDouble(3,p.getHeureDebut());
				 pstm.setDouble(1,p.getHeureFin());
				
				
				 
		    	pstm.executeUpdate();
			
			 System.out.println("mise a jour de HORAIRE terminé avec succés");
			 }
			 
			 
		 }catch(SQLException e2) {
             e2.getMessage();
		 }
		 finally {
		Connexion.close();
		 }
		 
	}
	
}
