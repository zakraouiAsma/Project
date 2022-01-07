package Projet.Projet_ISI.metier;

public class Batiment {
	public Batiment(String adresse) {
		// TODO Auto-generated constructor stub
		this.adresse=adresse;
	}

	
	private String adresse;


	public String getAdresse() {
		// TODO Auto-generated method stub
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
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
		Batiment other = (Batiment) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Batiment [adresse=" + adresse + "]";
	}
}
