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

import br.senai.informatica.leansurvey.dao.QuestionRuleDao;
import br.senai.informatica.leansurvey.model.Question;
import br.senai.informatica.leansurvey.model.Questionrule;

@RestController
public class QuestionRuleController {

	@Autowired
	private QuestionRuleDao qrDao;
	
	@RequestMapping(value="/questionrule", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Questionrule> insert (@RequestBody Questionrule qr){			
		try {
			qrDao.insertQuestionrule(qr);
			URI location = new URI ("/questionrule/" + qr.getId());
			return ResponseEntity.created(location).body(qr);
		   
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}


}

	@RequestMapping(value="/questionrule/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable long id){
		
		try {
			qrDao.deleteQuestionrule(id);
			return ResponseEntity.noContent().build();
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

}
	@RequestMapping(value="/questionrule", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Questionrule> list(){
		
		return qrDao.findQuestionrule();
		
	}
	
	@RequestMapping(value="/questionrule/{id}", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Questionrule> findQuestionRuleById(@PathVariable("id") long idQuestionrule){
		
		return qrDao.findQuestionRuleById(idQuestionrule);
		
	}
	
	
}
