package br.senai.informatica.leansurvey.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.senai.informatica.leansurvey.model.Employee;


@Repository
public class EmployeeDao {

	//Objeto EntityManager - Quem vai criar o EntityManager � o Spring. N�o precisa instanciar
	@PersistenceContext
	private EntityManager manager;

	@Transactional
	public void insertEmployee(Employee employee) {
		//Ele persiste os dados do objeto. Faz tudo.
		//Se n�o usar CASCATETYOPE.ALL da problema.
		System.out.println(employee.getName());
		manager.persist(employee);
		
	}
	
	//JPQL
	//M�todo para excluir
	@Transactional
	public void deleteEmployee(long idEmployee){
		//Busca o employee e depois o remove
		Employee employee = manager.find(Employee.class, idEmployee);
		
		manager.remove(employee);
		
	}
	
	//M�todo para mostrar
	public List<Employee> findEmployee(){
		
		//Precisa especificar o tipo de objeto a ser buscado. Busca o objeto completo.
		TypedQuery<Employee> query = manager.createQuery("SELECT e FROM Employee e", Employee.class);
		
		return query.getResultList();
	}
	
	//M�todo para buscar determinada entrada
	public List<Employee> findEmployeeById(long idEmployee){
		
		TypedQuery<Employee> query = manager.createQuery("SELECT e FROM Employee e WHERE e.id =:id", Employee.class);
		query.setParameter("id", idEmployee);
		
		return query.getResultList();
	}
	
	/**
	 * 
	 * 
	 * 				Tirar d�vida do UPDATE!!
	 * 					SEPA � o persist.
	 * 
	 */
	
	public Employee logar (Employee employee){
		TypedQuery<Employee> query = manager.createQuery("select e from Employee e where e.username = :username and "
	+"e.password = :password", Employee.class) ;
		
		query.setParameter("username", employee.getUsername());
		query.setParameter("password", employee.getPassword());
		
		// Usar o query.getSingleResult() dentro de trycatch, pois ele n�o retorna null, ele d� nullpointerexception.
		try {
			return query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		
	}
	
	
	
}

