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
import br.senai.informatica.leansurvey.dao.QuestionRuleGroupDao;
import br.senai.informatica.leansurvey.model.Question;
import br.senai.informatica.leansurvey.model.Questionrule;
import br.senai.informatica.leansurvey.model.Questionrulegroup;

@RestController
public class QuestionRuleGroupController {

	@Autowired
	private QuestionRuleGroupDao qrgDao;
	
	@RequestMapping(value="/questionrulegroup", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Questionrulegroup> insert (@RequestBody Questionrulegroup qr){			
		try {
			qrgDao.insertQuestionrulegroup(qr);
			URI location = new URI ("/questionrulegroup/" + qr.getId());
			return ResponseEntity.created(location).body(qr);
		   
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}


}

	@RequestMapping(value="/questionrulegroup/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable long id){
		
		try {
			qrgDao.deleteQuestionrule(id);;
			return ResponseEntity.noContent().build();
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

}
	@RequestMapping(value="/questionrulegroup", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Questionrulegroup> list(){
		
		return qrgDao.findQuestionrulegroup();
		
	}
	
	@RequestMapping(value="/questionrulegroup/{id}", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Questionrulegroup> findQuestionRuleGroupById(@PathVariable("id") long idQuestionrulegroup){
		
		return qrgDao.findQuestionRuleGroupById(idQuestionrulegroup);
		
	}
	
	
}
