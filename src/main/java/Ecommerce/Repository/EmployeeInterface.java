package Ecommerce.Repository;

import org.springframework.data.repository.CrudRepository;

import Ecommerce.model.Employee;

public interface EmployeeInterface extends CrudRepository<Employee, Integer> {
	
	//Fonction de Authentification pour les Employees
			Employee findByEmail(String email); // Select * from employee where email-email

}
