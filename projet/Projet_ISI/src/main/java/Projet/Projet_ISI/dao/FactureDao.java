package Projet.Projet_ISI.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import Projet.Projet_ISI.metier.Facture;
import Projet.Projet_ISI.metier.Reservation;





public class FactureDao {
	private static Connection cnx;

	public  Facture findById(String numF)
	{
		
		cnx=Connexion.getInstance();
		Facture f=null;Reservation r=null;
		if (numF==null)
			return f;
		
		  try {
			 
			  PreparedStatement pstm = cnx.prepareStatement("select * from fACTURE where numf= ?" );
			
			  pstm.setString(1,numF);
			  
			  ResultSet set=pstm.executeQuery();
			 // System.out.println(set.next());
			  if(set.next())
			  {
				 
				  f=new Facture(set.getString("numF"),set.getDouble(2),set.getDate(2).toLocalDate());
				  r=f.setNumReserv(new Reservation(set.getString("numReservation")));
				
			  }
			pstm.close();
		  }catch(SQLException e) {
			  e.printStackTrace();  
		  }
		  System.out.println(f);
		return f;
		}
	public   void save (Facture f) {
		if (f==null)
			return ;
		cnx=Connexion.getInstance();
		 int n=0;
		 //requete parametre 
		 String q="insert into facture (numF , Montant ,datef,numReservation) values (?,?,?,?) " ;
		 //prepared statment 
		 PreparedStatement pstm =null ;
		 try {
			 pstm=cnx.prepareStatement(q);
					 //set
					 pstm.setString(1, f.getNumFact());
					 pstm.setDouble(2,f.getMonatnt());
					 pstm.setDate(3, java.sql.Date.valueOf(f.getDateF()));
					 pstm.setString(4,f.getReservation().getNumReservation());
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
				 pstm=cnx.prepareStatement("update facture set montant=? , date=? ,numReservation=? where trim (numF)=?");
			
				
				 //set
				 pstm.setString(1, f.getNumFact());
				 pstm.setDouble(2,f.getMonatnt());
				 pstm.setDate(3, java.sql.Date.valueOf(f.getDateF()));
				 pstm.setString(4,f.getReservation().getNumReservation());
				
				 
		    	pstm.executeUpdate();
			
			 System.out.println("mise a jour de la Facture terminé avec succés");
			 }
			 
			 
		 }catch(SQLException e2) {
             e2.getMessage();
		 }
		 finally {
		Connexion.close();
		 }
		 
	}
	
	
}

