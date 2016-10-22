package br.senai.informatica.leansurvey.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.senai.informatica.leansurvey.model.Questionrule;

@Repository
public class QuestionRuleDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void insertQuestionrule(Questionrule questionrule){
		
		manager.persist(questionrule);
		
	}
	
	
	public List<Questionrule> findQuestionrule(){
		
		TypedQuery<Questionrule> query = manager.createQuery("SELECT qr FROM Questionrule qr", Questionrule.class);
		
		return query.getResultList();
		
	}
	
	
	public List<Questionrule> findQuestionRuleById(long idQuestionrule){
		
		TypedQuery<Questionrule> query = manager.createQuery("SELECT qr FROM Questionrule qr WHERE qr.id = :id", Questionrule.class);
		query.setParameter("id", idQuestionrule);
		
		return query.getResultList();
		
	}
	
	@Transactional
	public void deleteQuestionrule(long idQuestionrule){
		
		Questionrule questionrule = manager.find(Questionrule.class, idQuestionrule);
		
		manager.remove(questionrule);
		
	}
	
}
