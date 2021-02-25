package fr.diginamic;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.diginamic.banque.Adresse;
import fr.diginamic.banque.AssuranceVie;
import fr.diginamic.banque.Banque;
import fr.diginamic.banque.Client;
import fr.diginamic.banque.Compte;
import fr.diginamic.banque.LivretA;
import fr.diginamic.banque.Operation;
import fr.diginamic.banque.Virement;

public class TestBanque {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager em = entityManagerFactory.createEntityManager();

		EntityTransaction tr = em.getTransaction();
		tr.begin();
//		on ajoute un compte qui est lié a 2 clients
		Banque b1 = new Banque();
		b1.setNom("La banque");

		Compte c1 = new Compte();
		c1.setNumero("FR00102107");
		c1.setSolde(1000.16);
		em.persist(c1);

		Compte c2 = new Compte();
		c2.setNumero("FR0010456");
		c2.setSolde(5000.16);
		em.persist(c2);

		Compte c3 = new Compte();
		c3.setNumero("FR000598949");
		c3.setSolde(200.16);
		em.persist(c3);

		Adresse ad1 = new Adresse();
		ad1.setCodePostal(44160);
		ad1.setNumero(54);
		ad1.setVille("Nantes");
		ad1.setRue("balec");

		Client client1 = new Client();
		client1.setNom("Guepin");
		client1.setPrenom("Lilian");
		client1.getComptes().add(c1);
		client1.setAdresse(ad1);
		em.persist(client1);

		Client client2 = new Client();
		client2.setNom("Skywalker");
		client2.setPrenom("Luke");
		client2.getComptes().add(c1);
		client2.setAdresse(ad1);
		em.persist(client2);

		b1.getClients().add(client1);
		b1.getClients().add(client2);

		Client client3 = new Client();
		client3.setNom("Organa");
		client3.setPrenom("Leia");
		client3.getComptes().add(c2);
		client3.getComptes().add(c3);
		client3.setAdresse(ad1);
		em.persist(client3);

		b1.getClients().add(client3);

		LivretA lv = new LivretA(5);
		lv.setNumero("fr00013132");
		lv.setSolde(500);
		em.persist(lv);
		client1.getComptes().add(lv);

		LocalDate specificDate = LocalDate.of(2025, Month.JANUARY, 1);
		AssuranceVie av = new AssuranceVie(specificDate, 5.0);
		av.setNumero("fr000013215");
		av.setSolde(20000);
		em.persist(av);

		em.persist(b1);
		client2.getComptes().add(av);

		Virement vir = new Virement("skywalker");
		LocalDate today = LocalDate.now();
		vir.setDate(today);
		vir.setMontant(120);
		vir.setMotif("salaire");
		vir.setCompte(c3);

		em.persist(vir);

		Operation op = new Operation();
		op.setDate(today);
		op.setMontant(150);
		op.setMotif("noel");
		op.setCompte(c1);
		em.persist(op);

		tr.commit();

	}

}
