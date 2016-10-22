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

import br.senai.informatica.leansurvey.dao.InterviewerDao;
import br.senai.informatica.leansurvey.model.Interviewer;

@RestController
public class InterviewerController {

	@Autowired
	private InterviewerDao	interviewerDao;
	

	@RequestMapping(value="/interviewer", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Interviewer> insert(@RequestBody Interviewer interviewer){
	
		try {
			
			interviewerDao.insertInterviewer(interviewer);
			URI location = new URI ("/interviewer/" + interviewer.getId());
			return ResponseEntity.created(location).body(interviewer);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value="/interviewer/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteInterviewer(@PathVariable("id") long idInterviewer){
		
		interviewerDao.deleteInterviewer(idInterviewer);
		return ResponseEntity.noContent().build();
		
		
	}
	
	@RequestMapping(value="/interviewer", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Interviewer> findInterviewer(){
		
		return interviewerDao.findInterviewer();
		
	}
	
	@RequestMapping(value="/interviewer/{id}", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Interviewer> findInterviewerById(@PathVariable("id") long idInterviewer){
		
		return interviewerDao.findInterviewerById(idInterviewer);
		
	}
	
}
