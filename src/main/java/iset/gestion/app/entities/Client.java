package iset.gestion.app.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.rest.core.annotation.RestResource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
@RestResource
@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Client implements Serializable {
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Id
	Long idClient;
	String nom;
	String adresse;
	@OneToMany (mappedBy = "client")
	Collection<Produit> produits;

}
