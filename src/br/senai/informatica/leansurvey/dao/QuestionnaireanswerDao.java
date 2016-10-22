package br.senai.informatica.leansurvey.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.senai.informatica.leansurvey.model.Questionnaireanswer;

@Repository
public class QuestionnaireanswerDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void insertQuestionnaireanswer(Questionnaireanswer questionnaireanswer){
		
		manager.persist(questionnaireanswer);
		
	}
	
	@Transactional
	public void deleteQuestionnaireanswer(long idQuestionnaireanswer){
		
		Questionnaireanswer questionnaireanswer = manager.find(Questionnaireanswer.class, idQuestionnaireanswer);
		manager.remove(questionnaireanswer);
		
	}
	
	public List<Questionnaireanswer> findQuestionnaireanswer(){
		
		TypedQuery<Questionnaireanswer> query = manager.createQuery("SELECT qa FROM Questionnaireanswer qa", Questionnaireanswer.class);
		return query.getResultList();
		
	}
	
	public List<Questionnaireanswer> finddQuestionnaireanswerById(long idQuestionnaireanswer){
		
		TypedQuery<Questionnaireanswer> query = manager.createQuery("SELECT qa FROM Questionnaireanswer qa WHERE qa.id = :id", Questionnaireanswer.class);
		query.setParameter("id", idQuestionnaireanswer);
		
		return query.getResultList();
	}
	
	
}
