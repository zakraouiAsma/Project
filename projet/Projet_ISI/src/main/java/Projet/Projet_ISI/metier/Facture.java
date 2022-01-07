package Projet.Projet_ISI.metier;

import java.time.LocalDate;

public class Facture {
	private String numFact;
	private double Monatnt ;
	private LocalDate dateF ;
	private Reservation numReserv;
	public Facture(String numFact, double monatnt, LocalDate dateF, Reservation numReserv) {
		super();
		this.numFact = numFact;
		Monatnt = monatnt;
		this.dateF = dateF;
		this.numReserv = numReserv;
	}
	public Facture(String numFact, double monatnt, LocalDate dateF) {
		super();
		this.numFact = numFact;
		Monatnt = monatnt;
		this.dateF = dateF;
		// TODO Auto-generated constructor stub
	}
	public String getNumFact() {
		return numFact;
	}
	public void setNumFact(String numFact) {
		this.numFact = numFact;
	}
	public double getMonatnt() {
		return Monatnt;
	}
	public void setMonatnt(double monatnt) {
		Monatnt = monatnt;
	}
	public LocalDate getDateF() {
		return dateF;
	}
	public void setDateF(LocalDate dateF) {
		this.dateF = dateF;
	}
	public Reservation getNumReserv() {
		return numReserv;
	}
	public Reservation setNumReserv(Reservation numReserv) {
		return this.numReserv = numReserv;
	}
	@Override
	public String toString() {
		return "Facture [numFact=" + numFact + ", Monatnt=" + Monatnt + ", dateF=" + dateF + ", numReserv=" + numReserv
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateF == null) ? 0 : dateF.hashCode());
		result = prime * result + ((numFact == null) ? 0 : numFact.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Facture other = (Facture) obj;
		if (dateF == null) {
			if (other.dateF != null)
				return false;
		} else if (!dateF.equals(other.dateF))
			return false;
		if (numFact == null) {
			if (other.numFact != null)
				return false;
		} else if (!numFact.equals(other.numFact))
			return false;
		return true;
	}
	public Reservation getReservation() {
		// TODO Auto-generated method stub
		return numReserv;
	}
	
	
}
