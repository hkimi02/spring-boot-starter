package iset.gestion.app.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.io.Serializable;

@Entity
public class Produit implements Serializable {
	@Id
	private String reference;
	private String designation;
	private double prix;
	private int quantite;
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	

}
