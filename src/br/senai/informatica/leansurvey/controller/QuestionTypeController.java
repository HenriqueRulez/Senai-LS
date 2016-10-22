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

import br.senai.informatica.leansurvey.dao.QuestionTypeDao;
import br.senai.informatica.leansurvey.model.Questionrule;
import br.senai.informatica.leansurvey.model.Questiontype;
	
	
	@RestController
	public class QuestionTypeController {

				@Autowired
				private QuestionTypeDao questionTypeDao;
				
				@RequestMapping(value="/questiontype", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
				public ResponseEntity<Questiontype> insert (@RequestBody Questiontype questionType){			
					try {
						questionTypeDao.InsertQuestionType(questionType);
						URI location = new URI ("/questiontype/" + questionType.getId());
						return ResponseEntity.created(location).body(questionType);
					   
					} catch (Exception e) {
						e.printStackTrace();
						return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
					}


		}
		
				

				@RequestMapping(value="/questiontype/{id}", method=RequestMethod.DELETE)
				public ResponseEntity<Void> delete(@PathVariable long id){
					
					try {
						questionTypeDao.deleteQuestiontype(id);
						return ResponseEntity.noContent().build();
						
					} catch (Exception e) {
						e.printStackTrace();
						return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
					}

			}
				
				@RequestMapping(value="/questiontype", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
				public List<Questiontype> list(){
					
					return questionTypeDao.findQuestiontype();
					
				}
				
				@RequestMapping(value="/questiontype/{id}", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
				public List<Questiontype> findQuestionTypeById(@PathVariable("id") long idQuestiontype){
					
					return questionTypeDao.findQuestiontypeById(idQuestiontype);
					
				}
		
	}

