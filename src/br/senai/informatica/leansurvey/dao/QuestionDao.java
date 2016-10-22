package br.senai.informatica.leansurvey.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.senai.informatica.leansurvey.model.Question;

@Repository
public class QuestionDao {

	@PersistenceContext
	private EntityManager manager;
	
	
	@Transactional
	public void insertQuestion(Question question){
		manager.persist(question);
	}
	
	
	public List<Question> findQuestion(){
		
		TypedQuery<Question> query = manager.createQuery("SELECT q FROM Question q", Question.class);
		return query.getResultList();
		
	}
	
	public List<Question> findQuestionById (long idQuestion){
		
		TypedQuery<Question> query = manager.createQuery("SELECT q FROM Question q WHERE q.id = :id", Question.class);
		query.setParameter("id", idQuestion);
		
		return query.getResultList();
		
	}
	
	@Transactional
	public void deleteQuestion(long idQuestion){
		
		Question question = manager.find(Question.class, idQuestion);
		
		manager.remove(question);
		
	}
	
}
