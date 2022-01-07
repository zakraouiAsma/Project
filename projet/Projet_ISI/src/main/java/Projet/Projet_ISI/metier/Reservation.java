package Projet.Projet_ISI.metier;

public class Reservation {

private String numReservation;
 private float prix;
 private Demandeur code;
 private PlageHoraire IdPlageH;
 private Salle numSalle;
public Reservation(String numReservation, float prix, Demandeur code, PlageHoraire idPlageH, Salle numSalle) {
	super();
	this.numReservation = numReservation;
	this.prix = prix;
	this.code = code;
	IdPlageH = idPlageH;
	this.numSalle = numSalle;
}
public Reservation(String numReservation, float prix) {
	// TODO Auto-generated constructor stub
	super();
	this.numReservation = numReservation;
	this.prix = prix;
}
public Reservation(String numReservation) {
	// TODO Auto-generated constructor stub
	super();
	this.numReservation = numReservation;
}
public String getNumReservation() {
	return numReservation;
}
public void setNumReservation(String numReservation) {
	this.numReservation = numReservation;
}
public float getPrix() {
	return prix;
}
public void setPrix(float prix) {
	this.prix = prix;
}
public Demandeur getCode() {
	return code;
}

public Salle setCode(Demandeur code) {
	this.code = code;
	return numSalle;
}
public PlageHoraire getIdPlageH() {
	return IdPlageH;
}
public PlageHoraire getPlageHoraire() {
	return IdPlageH;
}
public PlageHoraire setIdPlageH(PlageHoraire idPlageH) {
	return IdPlageH = idPlageH;
}
public Salle getNumSalle() {
	return numSalle;
}
public Salle setNumSalle(Salle numSalle) {
	return this.numSalle = numSalle;
}
@Override
public String toString() {
	return "Reservation [numReservation=" + numReservation + ", prix=" + prix + ", code=" + code + ", IdPlageH="
			+ IdPlageH + ", numSalle=" + numSalle + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((numReservation == null) ? 0 : numReservation.hashCode());
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
	Reservation other = (Reservation) obj;
	if (numReservation == null) {
		if (other.numReservation != null)
			return false;
	} else if (!numReservation.equals(other.numReservation))
		return false;
	return true;
}
public Demandeur getDemandeur() {
	// TODO Auto-generated method stub
	return code;
}
 
	
}
