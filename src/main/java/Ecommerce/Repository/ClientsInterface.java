package Ecommerce.Repository;

import org.springframework.data.repository.CrudRepository;

import Ecommerce.model.Clients;

public interface ClientsInterface extends  CrudRepository <Clients, Integer> {

	// Clients c'est le nom de l'Entity
		// Interface c'est le type de la clé Primaire de la table/Entity
		
		//Fonction de Authentification pour les clients 
			Clients findByEmail(String email); // Select * from clients where email-email
}
