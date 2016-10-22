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

import br.senai.informatica.leansurvey.dao.EnterpriseDao;
import br.senai.informatica.leansurvey.model.Enterprise;

@RestController
public class EnterpriseController {

	@Autowired
	private EnterpriseDao enterpriseDao;
	
	@RequestMapping(value="/enterprise", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Enterprise> insert(@RequestBody Enterprise enterprise){
		
		try {
			
			enterpriseDao.InsertEnterprise(enterprise);
			URI location = new URI ("/enterprise/" + enterprise.getId());
			return ResponseEntity.created(location).body(enterprise);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value="/enterprise/{id}")
	public ResponseEntity<Void> deleteEnterprise(@PathVariable("id") long idEnterprise){
		
		enterpriseDao.deleteEnterprise(idEnterprise);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(value="/enterprise", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Enterprise> findEnterprise(){
		
		return enterpriseDao.findEnterprise();
				
	}
	
	@RequestMapping(value="/enterprise/{id}", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Enterprise> findEnterpriseById(@PathVariable("id") long idEnterprise){
		
		
		return enterpriseDao.findEnterpriseById(idEnterprise);
		
		
	}
	
	
}
