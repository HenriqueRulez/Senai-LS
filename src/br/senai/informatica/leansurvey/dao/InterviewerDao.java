package br.senai.informatica.leansurvey.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.senai.informatica.leansurvey.model.Interviewer;

@Repository
public class InterviewerDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void insertInterviewer(Interviewer interviewer){
		
		manager.persist(interviewer);
		
	}
	
	@Transactional
	public void deleteInterviewer(long idInterviewer){
		
		Interviewer interviewer = manager.find(Interviewer.class, idInterviewer);
		
		manager.remove(interviewer);
		
	}
	
	
	public List<Interviewer> findInterviewer(){
	
		TypedQuery<Interviewer> query = manager.createQuery("SELECT i FROM Interviewer i", Interviewer.class);
		return query.getResultList();
		
	}
	
	
	public List<Interviewer> findInterviewerById(long idInterviewer){
		
		TypedQuery<Interviewer> query = manager.createQuery("SELECT i FROM Interviewer i WHERE i.id = :id", Interviewer.class);
		query.setParameter("id", idInterviewer);
		
		return query.getResultList();
		
	}
	
	
}
