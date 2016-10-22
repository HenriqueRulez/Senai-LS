package br.senai.informatica.leansurvey.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.senai.informatica.leansurvey.model.Answerquestion;

@Repository
public class AnswerquestionDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void insertAnswerquestion(Answerquestion answerquestion){
		
		manager.persist(answerquestion);
		
	}
	
	@Transactional
	public void deleteAnswerquestion(long idAnswerquestion){
		
		Answerquestion answerquestion = manager.find(Answerquestion.class, idAnswerquestion);
		manager.remove(answerquestion);
		
	}
	
	public List<Answerquestion> findAnswerquestion(){
		
		TypedQuery<Answerquestion> query = manager.createQuery("SELECT aq FROM Answerquestion aq", Answerquestion.class);
		return query.getResultList();
		
	}
	
	public List<Answerquestion> findAnswerquestionById(long idAnswerquestion){
		
		TypedQuery<Answerquestion> query = manager.createQuery("SELECT aq FROM Answerquestion aq WHERE aq.id = :id", Answerquestion.class);
		query.setParameter("id", idAnswerquestion);
		
		return query.getResultList();
	}
	
	
}
