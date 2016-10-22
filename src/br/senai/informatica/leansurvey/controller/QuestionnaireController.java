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

import br.senai.informatica.leansurvey.dao.QuestionnaireDao;
import br.senai.informatica.leansurvey.model.Questionnaire;

@RestController
public class QuestionnaireController {

	@Autowired
	private QuestionnaireDao questionnaireDao;
	
	@RequestMapping(value="/questionnaire", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Questionnaire> insert (@RequestBody Questionnaire questionnaire){			
		try {
			questionnaireDao.insertQuestionnaire(questionnaire);
			URI location = new URI ("/questionnaire/" + questionnaire.getId());
			return ResponseEntity.created(location).body(questionnaire);
		   
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}


}

	
	@RequestMapping(value="/questionnaire/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable long id){
		
		try {
			questionnaireDao.deleteQuestionnaire(id);
			return ResponseEntity.noContent().build();
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

}

	
	@RequestMapping(value="/questionnaire", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Questionnaire> list(){
		
		return questionnaireDao.findQuestionnaire();
		
	}
	
	
	@RequestMapping(value="/questionnaire/{id}", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Questionnaire> findQuestionnaireById(@PathVariable("id") long idQuestionnaire){
		
		return questionnaireDao.findQuestionnaireById(idQuestionnaire);
		
	}
	
}
