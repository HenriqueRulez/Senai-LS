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

import br.senai.informatica.leansurvey.dao.AnswerquestionDao;
import br.senai.informatica.leansurvey.model.Answerquestion;

@RestController
public class AnswerquestionController {

	@Autowired
	private AnswerquestionDao answerquestionDao; 
	
	@RequestMapping(value="/answerquestion", method=RequestMethod.POST, consumes=org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Answerquestion> insert(@RequestBody Answerquestion answerquestion){
		
		try {
			
			answerquestionDao.insertAnswerquestion(answerquestion);
			URI location = new URI("/answerquestion/" + answerquestion.getId());
			return ResponseEntity.created(location).body(answerquestion);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@RequestMapping(value="/answerquestion/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAnswerquestion(@PathVariable("id") long idAnswerquestion){
		
		answerquestionDao.deleteAnswerquestion(idAnswerquestion);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(value="/answerquestion", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Answerquestion> findAnswerquestion(){
		
		return answerquestionDao.findAnswerquestion();
		
	}
	
	
	
	@RequestMapping(value="/answerquestion/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Answerquestion> findAnswerquestionById(@PathVariable("id") long idAnswerquestion){
		
		return answerquestionDao.findAnswerquestionById(idAnswerquestion);
		
	}
	
	
	
	
}

