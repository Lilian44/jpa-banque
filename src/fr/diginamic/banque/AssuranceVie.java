package fr.diginamic.banque;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class AssuranceVie extends Compte {
	private LocalDate dateFin;
	private double taux;

	public AssuranceVie(LocalDate dateFin, double taux) {
		super();
		this.dateFin = dateFin;
		this.taux = taux;
	}

	public AssuranceVie() {
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

}
