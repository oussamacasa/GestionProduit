package org.sid;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import com.sun.istack.internal.NotNull;

@Entity
public class Produit implements  Serializable {
	
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 3, max = 70)
	private String description; 
	@DecimalMin("3")
	private double prix; 
	private int quantite;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	Produit(Long id, String description, double prix, int quantite) {
		super();
		this.id = id;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
	}
	public Produit() {
		super();
	}  
	
	

}
