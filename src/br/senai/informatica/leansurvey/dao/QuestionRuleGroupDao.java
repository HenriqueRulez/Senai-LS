package br.senai.informatica.leansurvey.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.senai.informatica.leansurvey.model.Questionrule;
import br.senai.informatica.leansurvey.model.Questionrulegroup;

@Repository
public class QuestionRuleGroupDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void insertQuestionrulegroup(Questionrulegroup questionrulegroup){
		
		manager.persist(questionrulegroup);
		
	}
	
	
	public List<Questionrulegroup> findQuestionrulegroup(){
		
		TypedQuery<Questionrulegroup> query = manager.createQuery("SELECT qr FROM Questionrulegroup qr", Questionrulegroup.class);
		
		return query.getResultList();
		
	}
	
	
	public List<Questionrulegroup> findQuestionRuleGroupById(long idQuestionrulegroup){
		
		TypedQuery<Questionrulegroup> query = manager.createQuery("SELECT qr FROM Questionrulegroup qr WHERE qr.id = :id", Questionrulegroup.class);
		query.setParameter("id", idQuestionrulegroup);
		
		return query.getResultList();
		
	}
	
	@Transactional
	public void deleteQuestionrule(long idQuestionrulegroup){
		
		Questionrulegroup questionrulegroup = manager.find(Questionrulegroup.class, idQuestionrulegroup);
		
		manager.remove(questionrulegroup);
		
	}
	
}
