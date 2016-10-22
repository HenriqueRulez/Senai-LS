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


import br.senai.informatica.leansurvey.dao.QuestionnaireanswerDao;
import br.senai.informatica.leansurvey.model.Question;
import br.senai.informatica.leansurvey.model.Questionnaireanswer;

@RestController
public class QuestionnaireanswerController {
	

	@Autowired
	private QuestionnaireanswerDao qaDao;
	
	@RequestMapping(value="/questionnaireanswer", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Questionnaireanswer> insert (@RequestBody Questionnaireanswer qa){			
		try {
			qaDao.insertQuestionnaireanswer(qa);
			URI location = new URI ("/questionnaireanswer/" + qa.getId());
			return ResponseEntity.created(location).body(qa);
		   
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}


}
	
	@RequestMapping(value="/questionnaireanswer/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable long id){
		
		try {
			qaDao.deleteQuestionnaireanswer(id);
			return ResponseEntity.noContent().build();
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

}
	
	@RequestMapping(value="/questionnaireanswer", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Questionnaireanswer> list(){
		
		return qaDao.findQuestionnaireanswer();
		
	}
	
	
	@RequestMapping(value="/questionnaireanswer/{id}", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Questionnaireanswer> findQuestionnaireanswerById(@PathVariable("id") long idQuestionnaireanswer){
		
		return qaDao.finddQuestionnaireanswerById(idQuestionnaireanswer);
		
	}
	
	


}
