package fr.diginamic.banque;

import javax.persistence.Entity;

@Entity
public class Virement extends Operation {

	private String beneficiaire;

	public Virement(String beneficiaire) {
		super();
		this.beneficiaire = beneficiaire;
	}

	public Virement() {
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

}
