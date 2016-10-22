package br.senai.informatica.leansurvey.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.senai.informatica.leansurvey.dao.GenderDao;
import br.senai.informatica.leansurvey.model.Gender;

@RestController
public class GenderController {

	@Autowired
	private GenderDao genderDao;
	
	@RequestMapping(value="/gender", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Gender> insert(@RequestBody Gender gender){
		
		try {
			
			genderDao.insertGenderDao(gender);
			URI location = new URI ("/gender/"+ gender.getId());
			return ResponseEntity.created(location).body(gender);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value="/gender/{id}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Gender> update (@PathVariable long id, @RequestBody Gender gender){
		
		
		try {
			genderDao.updateGender(gender.getDescription(), id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	

	
	
	@RequestMapping(value="/gender/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteGender(@PathVariable("id") long idGender){
		
		genderDao.deleteGender(idGender);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(value="/gender", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Gender> findGender(){
		
		return genderDao.findGender();
		
	}
	
	@RequestMapping(value="/gender/{id}", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Gender> findGenderById(@PathVariable("id") long idGender){
		
		return genderDao.findGenderById(idGender);
		
	}
	
}
