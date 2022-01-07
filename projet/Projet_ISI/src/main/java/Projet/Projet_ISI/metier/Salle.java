package Projet.Projet_ISI.metier;

public class Salle {
	private String numSalle;
	private double Superficier;
	private Batiment adresse;
	public Salle(String numSalle, double superficier, Batiment adresse) {
		super();
		this.numSalle = numSalle;
		Superficier = superficier;
		this.adresse = adresse;
	}
	public Salle(String numSalle) {
	
		this.numSalle = numSalle;
		// TODO Auto-generated constructor stub
	}
	public Salle(String numSalle, double superficier) {
		super();
		this.numSalle = numSalle;
		Superficier = superficier;
		// TODO Auto-generated constructor stub
	}
	public String getNumSalle() {
		return numSalle;
	}
	public void setNumSalle(String numSalle) {
		this.numSalle = numSalle;
	}
	public double getSuperficier() {
		return Superficier;
	}
	public void setSuperficier(double superficier) {
		Superficier = superficier;
	}
	public Batiment getAdresse() {
		return adresse;
	}
	public Batiment getBatiment() {
		// TODO Auto-generated method stub
		return adresse;
	}
	 
	public Batiment setAdresse(Batiment adresse) {
		return this.adresse = adresse;
	}
	@Override
	public String toString() {
		return "Salle [numSalle=" + numSalle + ", Superficier=" + Superficier + ", adresse=" + adresse + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numSalle == null) ? 0 : numSalle.hashCode());
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
		Salle other = (Salle) obj;
		if (numSalle == null) {
			if (other.numSalle != null)
				return false;
		} else if (!numSalle.equals(other.numSalle))
			return false;
		return true;
	}
	

	
}
