package fr.diginamic.banque;

import javax.persistence.Entity;

@Entity
public class LivretA extends Compte {
	private double taux;

	public LivretA() {
	}

	public LivretA(double taux) {
		super();
		this.taux = taux;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

}
