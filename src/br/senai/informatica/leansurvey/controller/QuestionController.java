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

import br.senai.informatica.leansurvey.dao.QuestionDao;
import br.senai.informatica.leansurvey.model.Question;

@RestController
public class QuestionController {

			@Autowired
			private QuestionDao questionDao;
			
			@RequestMapping(value="/question", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
			public ResponseEntity<Question> insert (@RequestBody Question question){			
				try {
					questionDao.insertQuestion(question);
					URI location = new URI ("/question/" + question.getId());
					return ResponseEntity.created(location).body(question);
				   
				} catch (Exception e) {
					e.printStackTrace();
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}			
	}
	
			@RequestMapping(value="/question/{id}", method=RequestMethod.DELETE)
			public ResponseEntity<Void> delete(@PathVariable long id){
				
				try {
					questionDao.deleteQuestion(id);
					return ResponseEntity.noContent().build();
					
				} catch (Exception e) {
					e.printStackTrace();
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
	
}
			
			@RequestMapping(value="/question", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
			public List<Question> list(){
				
				return questionDao.findQuestion();
				
			}
			
			@RequestMapping(value="/question/{id}", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
			public List<Question> findQuestionById(@PathVariable("id") long idQuestion){
				
				return questionDao.findQuestionById(idQuestion);
				
			}
			
			
			
}
