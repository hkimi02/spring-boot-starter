package iset.gestion.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import iset.gestion.app.entities.Client;

@RestResource
public interface ClientRepository extends JpaRepository<Client, Long>{

}
