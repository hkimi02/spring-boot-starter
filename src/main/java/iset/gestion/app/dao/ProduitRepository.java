package iset.gestion.app.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import iset.gestion.app.entities.Produit;


@RestResource
public interface ProduitRepository extends JpaRepository<Produit, String>{

	Page<Produit> findByDesignationContains(String mc, PageRequest of);

	/*@Query("select p from Produit p where p.designation like :x")
	public Page<Produit> chercherProduit(@Param("x") String mc,Pageable pageable);
	public Page<Produit> findByDesignationContains(String mc,PageRequest pageRequest);*/
	
}


