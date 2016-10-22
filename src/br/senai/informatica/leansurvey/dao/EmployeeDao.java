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

	//Objeto EntityManager - Quem vai criar o EntityManager é o Spring. Não precisa instanciar
	@PersistenceContext
	private EntityManager manager;

	@Transactional
	public void insertEmployee(Employee employee) {
		//Ele persiste os dados do objeto. Faz tudo.
		//Se não usar CASCATETYOPE.ALL da problema.
		System.out.println(employee.getName());
		manager.persist(employee);
		
	}
	
	//JPQL
	//Método para excluir
	@Transactional
	public void deleteEmployee(long idEmployee){
		//Busca o employee e depois o remove
		Employee employee = manager.find(Employee.class, idEmployee);
		
		manager.remove(employee);
		
	}
	
	//Método para mostrar
	public List<Employee> findEmployee(){
		
		//Precisa especificar o tipo de objeto a ser buscado. Busca o objeto completo.
		TypedQuery<Employee> query = manager.createQuery("SELECT e FROM Employee e", Employee.class);
		
		return query.getResultList();
	}
	
	//Método para buscar determinada entrada
	public List<Employee> findEmployeeById(long idEmployee){
		
		TypedQuery<Employee> query = manager.createQuery("SELECT e FROM Employee e WHERE e.id =:id", Employee.class);
		query.setParameter("id", idEmployee);
		
		return query.getResultList();
	}
	
	/**
	 * 
	 * 
	 * 				Tirar dúvida do UPDATE!!
	 * 					SEPA é o persist.
	 * 
	 */
	
	public Employee logar (Employee employee){
		TypedQuery<Employee> query = manager.createQuery("select e from Employee e where e.username = :username and "
	+"e.password = :password", Employee.class) ;
		
		query.setParameter("username", employee.getUsername());
		query.setParameter("password", employee.getPassword());
		
		// Usar o query.getSingleResult() dentro de trycatch, pois ele não retorna null, ele dá nullpointerexception.
		try {
			return query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		
	}
	
	
	
}

