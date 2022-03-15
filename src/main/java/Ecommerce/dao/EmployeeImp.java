package Ecommerce.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Ecommerce.Repository.EmployeeInterface;
import Ecommerce.model.Employee;

@Service
@Transactional 
public class EmployeeImp {

	@Autowired 
	// Objet de type Employee Interface 
	EmployeeInterface  interfaceEmployee;
	
	//Fonction Ajout des Employee
	public void Add(Employee employee) {
		
		interfaceEmployee.save(employee); // C'est l'équivalent de requete Insert
	}
	
	//Fonction Authentification par mail d'un Employee 
	
	public Employee verifEmail(String Email) {
		
		return interfaceEmployee.findByEmail(Email);
		
	}
	
	// Fonction d'Affichage des Employee
	public List<Employee> Affichage() {
		List<Employee> resultat=(List<Employee>) interfaceEmployee.findAll();
		return resultat;
	}
	
	//Suppresion employee
	public void deleteEmployee(int id) {
		interfaceEmployee.deleteById(id);
	}
	
	
	//Fonction modif des employee
	public void Update(Employee employee) {
		
		interfaceEmployee.save(employee); // C'est l'équivalent de requete Insert
	}

}
