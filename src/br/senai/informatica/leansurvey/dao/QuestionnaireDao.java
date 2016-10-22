package br.senai.informatica.leansurvey.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.senai.informatica.leansurvey.model.Questionnaire;

@Repository
public class QuestionnaireDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void insertQuestionnaire(Questionnaire questionnaire){
		
		manager.persist(questionnaire);
		
	}
	
	@Transactional
	public void deleteQuestionnaire(long idQuestionnaire){
		
		Questionnaire questionnaire = manager.find(Questionnaire.class, idQuestionnaire);
		
		manager.remove(questionnaire);
		
	}
	
	public List<Questionnaire> findQuestionnaire(){
		
		TypedQuery<Questionnaire> query = manager.createQuery("SELECT q FROM Questionnaire q", Questionnaire.class);
		
		return query.getResultList();
		
	}
	
	public List<Questionnaire> findQuestionnaireById(long idQuestionnaire){
		
		TypedQuery<Questionnaire> query = manager.createQuery("SELECT q FROM Questionnaire q WHERE q.id = :id", Questionnaire.class);
		query.setParameter("id", idQuestionnaire);
		
		return query.getResultList();
		
	}
	
}
