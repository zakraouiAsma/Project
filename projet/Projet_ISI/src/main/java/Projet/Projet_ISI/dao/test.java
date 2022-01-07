
package Projet.Projet_ISI.dao;

import java.time.LocalDate;
import java.util.List;

import Projet.Projet_ISI.metier.Batiment;
import Projet.Projet_ISI.metier.Demandeur;
import Projet.Projet_ISI.metier.Facture;
import Projet.Projet_ISI.metier.PlageHoraire;
import Projet.Projet_ISI.metier.Reservation;
import Projet.Projet_ISI.metier.Salle;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DemandeurDao dd= new DemandeurDao();
		Demandeur d1 =new Demandeur("123AZ","ahmed","rue 2000");
		dd.save(d1);
		Demandeur d2 =new Demandeur("122AB","ahlem","rue 2000");
		 dd.save(d2);
	     BatimentDao b= new BatimentDao();
	     Batiment b1= new Batiment("rue abd rahmen");
	     b.save(b1);
	    SalleDao s=new SalleDao();
	    Salle s1= new Salle("12s",12.0,b1);
	    s.save(s1);
	    LocalDate d=  LocalDate.of(2021,12,21);
		 
		PlageHoraireDao p= new PlageHoraireDao();
		PlageHoraire p1= new PlageHoraire("14plage",d,12.0,14.0);
		p.save(p1);
		PlageHoraire p2= new PlageHoraire("12plage",d,12.0,14.0);
		p.save(p2);
		ReservationDao r= new ReservationDao();
		Salle s2=new Salle("S1",59.0);
		Reservation r1=new Reservation("res1",12.0f,d1,p1,s1);
		Reservation r2=new Reservation("res3",13.0f,d2,p1,s1);
		r.save(r2);
		
		r.save(r1);
		 FactureDao f=new FactureDao();
		    LocalDate d11=  LocalDate.of(2021,12,21);
		    Facture f1=new Facture ("fa123",100.0,d11,r1);
		      f.save(f1);
		      List <Reservation>liste=(List<Reservation>) new ReservationDao().findAll();
		      System.out.println(liste); 
		/*
		 * dd.save(d2); //System.out.println();
		 * System.out.println(dd.findById("122AB")); dd.delete("123AZ"); //List
		 * <Demandeur>liste=(List<Demandeur>) new DemandeurDao().findAll();
		 * 
		 * 
		 * List <Demandeur>liste1=(List<Demandeur>) new
		 * DemandeurDao().findAll(); System.out.println(liste1);
		 */
	}

}
