package Personne;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personne.utilisateur")
public class Utilisateur implements Serializable{
        
	  private static final long serialVersionUID = 1L;
		
	    @Id
	    @Column(name = "id", unique = true)
        private int id;
	    
	    @Column(name = "nom", nullable = false)
        private String nom;
	    
	    @Column(name = "prenom", nullable = false)
        private String prenom;
	    
        
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
}
