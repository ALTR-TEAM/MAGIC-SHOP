package Ecommerce.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Ecommerce.Repository.ClientsInterface;
import Ecommerce.model.Clients;

@Service
@Transactional 
public class ClientsImp {

	@Autowired 
	
	// Objet de type ClientsInterface
	ClientsInterface  interfaceClient;
	
	//Fonction Ajout des Clients
	public void Add(Clients client) {
		
		interfaceClient.save(client); // C'est l'équivalent du requete Insert
	}
	
	// Fonction d'affichage des Clients
	public List<Clients> Affichage() {
		List<Clients> resultat=(List<Clients>) interfaceClient.findAll(); // Select * from Clients sans where
		
		return resultat;
	}
	
	//Suppresion d'un Client avec son ID
	public void deleteClient(int id) {
		interfaceClient.deleteById(id);
	}
	
	
	//Fonction modification des Clients

	public Clients detailsclient(int id) {
		
		Clients clt = interfaceClient.findById(id).get();
		
		return clt;
		
	}
	
	//Fonction Authentification des Clients
	public Clients Auth (String email) {
		
		Clients slt = interfaceClient.findByEmail(email);
		
		return slt;
		
	}

}
