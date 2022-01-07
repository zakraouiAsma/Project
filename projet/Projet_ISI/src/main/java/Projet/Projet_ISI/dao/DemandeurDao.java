package Projet.Projet_ISI.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Projet.Projet_ISI.metier.Demandeur;
import Projet.Projet_ISI.metier.PlageHoraire;
import Projet.Projet_ISI.metier.Reservation;
import Projet.Projet_ISI.metier.Salle;



public class DemandeurDao {
	
	private static Connection cnx;

	

	public static  Demandeur findById(String code)
	{
		
		cnx=Connexion.getInstance();
		Demandeur d=null;
		if (code==null)
			return d;
		
		  try {
			 
			  PreparedStatement pstm = cnx.prepareStatement("select * from demandeur where code= ?" );
			
			  pstm.setString(1,code);
			  
			  ResultSet set=pstm.executeQuery();
			 // System.out.println(set.next());
			  if(set.next())
			  {
				 
				  d=new Demandeur(set.getString("code"),set.getString("nom"),set.getString("adresse"));
				
			  }
			pstm.close();
		  }catch(SQLException e) {
			  e.printStackTrace();  
		  }
		  System.out.println(d);
		return d;
		}
	 public static Collection<Demandeur>findAll(){
		 Collection<Demandeur>liste1=new ArrayList<>();
		 Connection cnx = Connexion.getInstance();
		 String req="select code,nom,adresse from Demandeur";
			Demandeur p=null;
 try {
				  PreparedStatement pstm=cnx.prepareStatement(req);
				  ResultSet res=pstm.executeQuery();
				while ( res.next()){
			p=new Demandeur (res.getString("code"),res.getString(2),res.getString(3));
			
				
				liste1.add(p);
				}
					
					 
			  }catch(SQLException e) {
				  System.out.println(e.getMessage());  
			  }
			  finally
			  {
				  Connexion.close();
			  }
		 
		 
		 
		 
		return liste1;}
	
	
		public static  Demandeur save (Demandeur d) {
			if (d==null)
				return d ;
			cnx=Connexion.getInstance();
			 int n=0;
			 //requete parametre 
			 String q="insert into Demandeur (code , nom ,adresse) values (?,?,?) " ;
			 //prepared statment 
			 PreparedStatement pstm =null ;
			 try {
				 pstm=cnx.prepareStatement(q);
						 //set
						 pstm.setString(1, d.getCode());
						 pstm.setString(2, d.getNom());
						 pstm.setString(3, d.getAdresse());
						 //execution
						n= pstm.executeUpdate();
						if (n!=0)
							System.out.println("client inserer avec succés");
			 }catch (SQLException e1) {
				// e1.printStackTrace();
				 if (e1 instanceof SQLIntegrityConstraintViolationException )
				 {
					 System.out.println("le client existe deja dans la base ");
				 }
			 }
			 try {
				 if (n==0) {
					 pstm=cnx.prepareStatement("update Demandeur set nom=? , adresse=? where trim (code)=?");
				
					
					 //set
					
					pstm.setString(1,d.getNom());
					 pstm.setString(3,d.getCode());
					 pstm.setString(2,d.getAdresse());
					 
			    	pstm.executeUpdate();
				
				 System.out.println("mise a jour de la client  terminé avec succés");
				 }
				 
				 
			 }catch(SQLException e2) {
	             e2.getMessage();
			 }
			 finally {
			Connexion.close();
			 }
			return d;
			 
		}
		public  static void delete (String a) {
			
			Connection cnx=Connexion.getInstance();
			try {
				PreparedStatement pstmt =cnx.prepareStatement("update Demandeur set etat=1 where code=?");
				pstmt.setString(1, a);
				int n=pstmt.executeUpdate();
				if(n==1) 
					System.out.println("le client "+a+" a ete archive avec succes");
					else 
						System.out.println("le client "+a+"n'existe pas ");
			
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
}
