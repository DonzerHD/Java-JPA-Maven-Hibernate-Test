package Personne;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestSystem {

	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("Personne");

	public static void main(String[] args) {
		addUtilisateur(1, "LEMAY", "Thomas");
       
		ENTITY_MANAGER_FACTORY.close();

	}

	public static void addUtilisateur(int id, String nom, String prenom) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			Utilisateur utilisateur1 = new Utilisateur();
			utilisateur1.setId(id);
			utilisateur1.setNom(nom);
			utilisateur1.setPrenom(prenom);
			em.persist(utilisateur1);
			et.commit();
		} catch (Exception ex) {
			if (et != null) {
				et.rollback();
			}
			ex.printStackTrace();
		} finally {
			em.close();
		}

	}

	/*public static void getUtilisateur(int id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT a FROM personne.utilisateur a WHERE a.id = :id ";

		TypedQuery<Utilisateur> tq = em.createQuery(query, Utilisateur.class);
		tq.setParameter("id", id);
		Utilisateur util = null;
		try {
			util = tq.getSingleResult();
			System.out.println(util.getNom() + " " + util.getPrenom());
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
	}

	public static void getUtilisateurs() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String strQuery = "SELECT a FROM personne.utilisateur a WHERE a.id IS NOT NULL";
		TypedQuery<Utilisateur> tq = em.createQuery(strQuery, Utilisateur.class);
		List<Utilisateur> utils;
		try {
			utils = tq.getResultList();
			utils.forEach(util -> System.out.println(util.getNom() + " " + util.getPrenom()));
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}

	}

	public static void changeNomUtilisateur(int id, String nom) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		Utilisateur util = null;
		try {
			et = em.getTransaction();
			et.begin();
			util = em.find(Utilisateur.class, id);
			util.setNom(nom);
			em.persist(util);
			et.commit();
		} catch (Exception ex) {
			if (et != null) {
				et.rollback();
			}
			ex.printStackTrace();
		} finally {
			em.close();
		}

	}

	public static void deleteUtilisateur(int id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		Utilisateur util = null;
		try {
			et = em.getTransaction();
			et.begin();
			util = em.find(Utilisateur.class, id);
			em.remove(util);

			em.persist(util);
			et.commit();
		} catch (Exception ex) {
			if (et != null) {
				et.rollback();
			}
			ex.printStackTrace();
		} finally {
			em.close();
		}

	} */

}
