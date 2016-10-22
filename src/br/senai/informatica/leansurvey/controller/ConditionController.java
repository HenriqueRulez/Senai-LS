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

import br.senai.informatica.leansurvey.dao.ConditionDao;
import br.senai.informatica.leansurvey.model.Condition;

@RestController
public class ConditionController {

	@Autowired
	private ConditionDao conditionDao;
	
	@RequestMapping(value="/condition", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Condition> insert(@RequestBody Condition condition){
		
		try {
			
			conditionDao.insertCondition(condition);
			URI location = new URI("/condition/" + condition.getId());
			return ResponseEntity.created(location).body(condition);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value="/condition/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteContidion(@PathVariable("id") long idCondition){
		
		conditionDao.deleteCondition(idCondition);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(value="/condition", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Condition> findCondition(){
		
		return conditionDao.findCondition();		
	}
	
	
	@RequestMapping(value="/condition/{id}", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Condition> findConditionById(@PathVariable("id") long idCondition){
		
		return conditionDao.findConditionById(idCondition);
		
	}
	
	
}
