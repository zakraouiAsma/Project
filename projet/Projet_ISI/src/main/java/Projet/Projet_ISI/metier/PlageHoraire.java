package Projet.Projet_ISI.metier;

import java.time.LocalDate;

public class PlageHoraire {
	private String idPlageH;
	private LocalDate Date;
	private double heureDebut;
	private double heureFin;
	public PlageHoraire(String idPlageH, LocalDate date, double heureDebut, double heureFin) {
		super();
		this.idPlageH = idPlageH;
		Date = date;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}
	public PlageHoraire(String idPlageH ) {
		// TODO Auto-generated constructor stub
		super();
		this.idPlageH = idPlageH;	
	}
	public String getIdPlageH() {
		return idPlageH;
	}
	public void setIdPlageH(String idPlageH) {
		this.idPlageH = idPlageH;
	}
	public LocalDate getDate() {
		return Date;
	}
	public void setDate(LocalDate date) {
		Date = date;
	}
	public double getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(double heureDebut) {
		this.heureDebut = heureDebut;
	}
	public double getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(double heureFin) {
		this.heureFin = heureFin;
	}
	@Override
	public String toString() {
		return "PlageHoraire [idPlageH=" + idPlageH + ", Date=" + Date + ", heureDebut=" + heureDebut + ", heureFin="
				+ heureFin + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPlageH == null) ? 0 : idPlageH.hashCode());
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
		PlageHoraire other = (PlageHoraire) obj;
		if (idPlageH == null) {
			if (other.idPlageH != null)
				return false;
		} else if (!idPlageH.equals(other.idPlageH))
			return false;
		return true;
	}
	
}
