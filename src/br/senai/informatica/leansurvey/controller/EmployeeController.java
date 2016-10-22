package br.senai.informatica.leansurvey.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.senai.informatica.leansurvey.dao.EmployeeDao;
import br.senai.informatica.leansurvey.model.Employee;


@RestController
public class EmployeeController {
	

		@Autowired
		private EmployeeDao employeeDao;
		
		@RequestMapping(value="/employee", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public ResponseEntity<Employee> insert (@RequestBody Employee employee){			
			try {
				employeeDao.insertEmployee(employee);
				URI location = new URI ("/employee/" + employee.getId());
				return ResponseEntity.created(location).body(employee);
			   
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}


}

		@RequestMapping (value="/login",
				method=RequestMethod.POST,
				consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,
				produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	    public ResponseEntity<String> logar (@RequestBody Employee employee){
	    		
	    	try {
	    		employee = employeeDao.logar(employee);
				
				if (employee != null){
				    
					return (ResponseEntity<String>) ResponseEntity.ok();
				}
				else{
					return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
				}
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    	
	    }
		
		@RequestMapping(value="/employee/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> deleteEmployee(@PathVariable("id") long idEmployee){
			
			employeeDao.deleteEmployee(idEmployee);
			return ResponseEntity.noContent().build();
			
		}
		
		@RequestMapping(value="/employee", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Employee> findEmployee(){
			
			return employeeDao.findEmployee();
			
		}
		
		@RequestMapping(value="/employee/{id}", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Employee> findEmployeeById(@PathVariable("id") long idEmployee){
			
			return employeeDao.findEmployeeById(idEmployee);
			
		}
		
		
		
}
