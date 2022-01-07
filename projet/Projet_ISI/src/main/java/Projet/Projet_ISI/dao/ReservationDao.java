package Projet.Projet_ISI.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Collection;

import Projet.Projet_ISI.metier.Demandeur;
import Projet.Projet_ISI.metier.Reservation;
import Projet.Projet_ISI.metier.Salle;
import Projet.Projet_ISI.metier.PlageHoraire;

public class ReservationDao {
	private static Connection cnx;

	 public static Collection<Reservation>findAll(){
		 Collection<Reservation>liste=new ArrayList<>();
		 Connection cnx = Connexion.getInstance();
		 String req="select numReservation,Prix,code,idPlageH,numSalle from Reservation";
			Reservation r=null;Demandeur d=null;PlageHoraire p=null;Salle s=null;
			  try {
				  PreparedStatement pstm=cnx.prepareStatement(req);
				  ResultSet res=pstm.executeQuery();
				while ( res.next()){
			r=new Reservation (res.getString("numReservation"),res.getFloat(2));
			
				s=r.setNumSalle(new Salle(res.getString("numSalle")));
				p=r.setIdPlageH(new PlageHoraire(res.getString("idPlageH")));
				s=r.setCode(new Demandeur(res.getString("code")));
				
				
				liste.add(r);
				}
					
					 
			  }catch(SQLException e) {
				  System.out.println(e.getMessage());  
			  }
			  finally
			  {
				  Connexion.close();
			  }
		 
		 
		 
		 
		return liste;}
	 public   void save (Reservation r) {
			if (r==null)
				return ;
			cnx=Connexion.getInstance();
			 int n=0;
			 //requete parametre 
			 String q="insert into reservation (numReservation,prix,code,idPlageH,numSalle) values (?,?,?,?,?) " ;
			 //prepared statment 
			 PreparedStatement pstm =null ;
			 try {
				 pstm=cnx.prepareStatement(q);
						 //set
						 pstm.setString(1, r.getNumReservation());
						 pstm.setFloat(2, r.getPrix());
						  pstm.setString(3, r.getDemandeur().getCode()); 
						  pstm.setString(4, r.getPlageHoraire().getIdPlageH());
						  pstm.setString(5, r.getNumSalle().getNumSalle());					
						  //execution
						n= pstm.executeUpdate();
						if (n!=0)
							System.out.println("Reservation inserer avec succés");
			 }catch (SQLException e1) {
				// e1.printStackTrace();
				 if (e1 instanceof SQLIntegrityConstraintViolationException )
				 {
					 System.out.println("la reservation existe deja dans la base ");
				 }
			 }
			 try {
				 if (n==0) {
					 pstm=cnx.prepareStatement("update Reservation set prix=?,code=? ,idPlageH=?,numSalle=? where trim (numReservation)=?");
				
					
					 //set
					 pstm.setFloat(1, r.getPrix());
					  pstm.setString(2, r.getDemandeur().getCode()); 
					  pstm.setString(3, r.getPlageHoraire().getIdPlageH());
					  pstm.setString(4, r.getNumSalle().getNumSalle());	
					  pstm.setString(5, r.getNumReservation());
					
					 
			    	pstm.executeUpdate();
				
				 System.out.println("mise a jour de la reservation  terminé avec succés");
				 }
				 
				 
			 }catch(SQLException e2) {
	             e2.getMessage();
			 }
			 finally {
			Connexion.close();
			 }
			 
		}
		public void delete (String a) {
			
			Connection cnx=Connexion.getInstance();
			try {
				PreparedStatement pstmt =cnx.prepareStatement("update Reservation set etat=1 where numReservation=?");
				pstmt.setString(1, a);
				int n=pstmt.executeUpdate();
				if(n==1) 
					System.out.println("la reservation "+a+" a ete archive avec succes");
					else 
						System.out.println("la reservation  "+a+"n'existe pas ");
			
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
}
